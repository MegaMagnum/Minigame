package me.megamagnum.main.commands;

import me.megamagnum.main.Main;
import me.megamagnum.main.storage.Storage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class commandSetup implements CommandExecutor {
    Main main = Main.getPlugin(Main.class);


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "A minigame will start in 5 minutes! Use /join to join the minigame!");
            Storage.get().set("Minigame."+"IsStarting", true);
            Storage.save();
            Boolean starting = Storage.get().getBoolean("Minigame."+"IsStarting");

            Player p = (Player) sender;
            new BukkitRunnable(){
                int mleft = 5;
                public void run(){
                mleft--;
                if(mleft == 0){
                    cancel();
                }
                    Bukkit.broadcastMessage(ChatColor.AQUA + "A minigame is going to begin! Do /join to join the minigame. Minigame will start in " + mleft + " minutes!");

                }

            }.runTaskTimer(main, 1200, 1200);
            //1200

            new BukkitRunnable(){
                public void run(){
                for(Player online : Bukkit.getOnlinePlayers()){
                    if(commandJoin.joinedplayers.contains(online.getUniqueId())){
                        Location loc = online.getLocation();
                        online.teleport(loc.add(0, 20, 0));
                        online.sendMessage(ChatColor.LIGHT_PURPLE + "Minigame starting..");
                    }
                }
                Storage.get().set("Minigame."+"IsStarting", false);



                }


            }.runTaskLater(main, 240);
        }



        return true;
    }
}
