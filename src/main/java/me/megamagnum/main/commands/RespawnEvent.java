package me.megamagnum.main.commands;

import me.megamagnum.main.Main;
import me.megamagnum.main.storage.Storage;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class RespawnEvent implements Listener {
    Main main = Main.getPlugin(Main.class);



    @EventHandler
    public void onDeath(PlayerRespawnEvent e) {
        if (e.getPlayer() instanceof Player) {
            Player p = e.getPlayer();
         //   if (commandJoin.joinedplayers.contains(p.getUniqueId())) {
             //   if (Storage.get().getBoolean("Minigame." + "started", true)) {

              //  Player killer =    e.getEntity().getKiller();


                p.setInvulnerable(true);
                p.setInvisible(true);

                new BukkitRunnable(){
                    public void run(){
                        p.setInvulnerable(false);
                        p.setInvisible(false);



                    }

                }.runTaskLater(main, 60);




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

           World world = p.getWorld();

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
                    e.setRespawnLocation(respawn[randomint]);
                    p.sendMessage("loc:"+randomint);

                    double maxhealth = p.getMaxHealth();
                    p.setHealth(maxhealth);


                }
            }
      // }

   // }


}
