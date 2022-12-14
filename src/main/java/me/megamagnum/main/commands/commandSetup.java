package me.megamagnum.main.commands;

import me.megamagnum.main.Main;
import me.megamagnum.main.MinigameTimer;
import me.megamagnum.main.events.HitEvent;
import me.megamagnum.main.scoreboardcreat;
import me.megamagnum.main.storage.Storage;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;

public class commandSetup implements CommandExecutor {

    HashMap points = HitEvent.points;

    public HashMap<Player, ItemStack[]> itemhash = new HashMap<Player, ItemStack[]>();
    Main main = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(Storage.get().get("Minigame." + "IsStarting") == null){
            Storage.get().set("Minigame." + "IsStarting", false);
        }
        if (Storage.get().get("Minigame." + "IsStarting").equals(false) && Storage.get().get("Minigame." + "started").equals(false)) {
            Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "A minigame will start in 5 minutes! Use /join to join the minigame!");
            Storage.get().set("Minigame." + "IsStarting", true);
            Storage.save();
            Boolean starting = Storage.get().getBoolean("Minigame." + "IsStarting");
            new BukkitRunnable() {
                int mleft = 5;
                public void run() {
                    //Waiting timer!
                    mleft--;
                    if (mleft == 1) {
                        cancel();
                    }
                    Bukkit.broadcastMessage(ChatColor.AQUA + "A minigame is going to begin! Do /join to join the minigame. Minigame will start in " + mleft + " minutes!");
                }
            }.runTaskTimer(main, 1200, 1200);
            //1200 - 1 minute
            new BukkitRunnable() {
                public void run() {
                    // Start game
                    MinigameTimer.timer();

                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (commandJoin.joinedplayers.contains(online.getUniqueId())) {
                            online.setSaturation(20);
                            Integer standard = 0;
                            points.put(online.getUniqueId(), standard);

                            Storage.get().set("Players."+online.getUniqueId() +"."+  "loc", online.getLocation());
                            Storage.save();
                            online.sendMessage(ChatColor.LIGHT_PURPLE + "Minigame starting..");
                            Storage.get().set("Players."+"mainhand." + online.getUniqueId(), online.getInventory().getItemInMainHand());
                            //Set scoreboard
                            scoreboardcreat.scoreboard(online);


                            // All start inventory interactions
                            ItemStack[] playerinv = online.getInventory().getContents();
                            HashMap<Player, ItemStack[]> itemhash = new HashMap<Player, ItemStack[]>();
                            itemhash.put(online, playerinv);
                            online.getInventory().clear();

                            // TP to arena (Storage for coords)
                            tprandom(online);


                            // Save old maxhealth and set maxhealth to 1
                            new BukkitRunnable(){
                                public void run(){
                                    // End minigame
                                    scoreboardcreat.removescoreboard(online);


                                    if(itemhash.containsKey(online)) {
                                        ItemStack[] items = itemhash.get(online);
                                        PlayerInventory inv = online.getInventory();
                                        for (ItemStack item : items) {
                                            if (item == null) {

                                            } else {
                                                online.getInventory().addItem(item);
                                            }
                                        }
                                        Location oldloc = Storage.get().getLocation("Players." + online.getUniqueId() + "." + "loc");

                                        online.teleport(oldloc);


                                        Storage.get().set("Minigame." + "started", false);
                                        Storage.save();

                                        commandJoin.joinedplayers.clear();

                                    }
                                    }

                            }.runTaskLater(main, 6000);

                        }
                    }
                 //   Storage.get().set("Minigame."+"started", true);
                    Storage.save();

                   Storage.get().set("Minigame." + "IsStarting", false);
                   Storage.save();

                }

            }.runTaskLater(main, 180);

        }else{
            sender.sendMessage(ChatColor.RED+ "A minigame is busy or being started!");

        }
        return true;
    }
    public static void tprandom(Player online){

        ItemStack snowball = new ItemStack(Material.SNOWBALL);
        ItemMeta snowballmeta = snowball.getItemMeta();
        snowballmeta.setDisplayName(ChatColor.AQUA + "Dit is geen sneeuw..");
        snowball.setItemMeta(snowballmeta);
        snowball.setAmount(576);

        online.getInventory().addItem(snowball);

        int loc1x =     Storage.get().getInt("Respawnloc."+ "loc1." +"x");
        int loc1y =     Storage.get().getInt("Respawnloc."+ "loc1." +"y");
        int loc1z =     Storage.get().getInt("Respawnloc."+ "loc1." +"z");

        int loc2x =     Storage.get().getInt("Respawnloc."+ "loc2." +"x");
        int loc2y =     Storage.get().getInt("Respawnloc."+ "loc2." +"y");
        int loc2z =     Storage.get().getInt("Respawnloc."+ "loc2." +"z");

        int loc3x =     Storage.get().getInt("Respawnloc."+ "loc3." +"x");
        int loc3y =     Storage.get().getInt("Respawnloc."+ "loc3." +"y");
        int loc3z =     Storage.get().getInt("Respawnloc."+ "loc3." +"z");

        int loc4x =     Storage.get().getInt("Respawnloc."+ "loc4." +"x");
        int loc4y =     Storage.get().getInt("Respawnloc."+ "loc4." +"y");
        int loc4z =     Storage.get().getInt("Respawnloc."+ "loc4." +"z");

        int loc5x =     Storage.get().getInt("Respawnloc."+ "loc5." +"x");
        int loc5y =     Storage.get().getInt("Respawnloc."+ "loc5." +"y");
        int loc5z =     Storage.get().getInt("Respawnloc."+ "loc5." +"z");

        int loc6x =     Storage.get().getInt("Respawnloc."+ "loc6." +"x");
        int loc6y =     Storage.get().getInt("Respawnloc."+ "loc6." +"y");
        int loc6z =     Storage.get().getInt("Respawnloc."+ "loc6." +"z");

        World world = online.getWorld();

        Location loc1 = new Location(world, loc1x, loc1y,loc1z);
        Location loc2 = new Location(world, loc2x,loc2y,loc2z);
        Location loc3 = new Location(world, loc3x, loc3y, loc3z);
        Location loc4 = new Location(world, loc4x, loc4y, loc4z);
        Location loc5 = new Location(world, loc5x, loc5y, loc5z);
        Location loc6 = new Location(world, loc6x, loc6y, loc6z);



        Location[] respawn = {loc1, loc2, loc3, loc4, loc5, loc6};
        Random r = new Random();
        int locr = r.nextInt(6);
        int randomint = locr;
        online.teleport(respawn[randomint]);
        online.sendMessage("loc:"+randomint);


    }




    }