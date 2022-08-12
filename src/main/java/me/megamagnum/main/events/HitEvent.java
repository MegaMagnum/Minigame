package me.megamagnum.main.events;

import me.megamagnum.main.Main;
import me.megamagnum.main.commands.commandJoin;
import me.megamagnum.main.commands.commandSetup;
import me.megamagnum.main.scoreboardcreat;
import me.megamagnum.main.storage.Storage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class HitEvent implements Listener {
    public static HashMap<UUID, Integer> points = new HashMap<>();

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        Main main = Main.getPlugin(Main.class);
        Player damaged = (Player) event.getEntity();
        if(event.getEntity() instanceof Player) {



                if (commandJoin.joinedplayers.contains(damaged.getUniqueId())) {
                 //   if (Storage.get().getBoolean("Minigame." + "started", true)) {
                        Projectile snowball = (Projectile) event.getDamager();
                        if(snowball.getShooter() instanceof Player){
                            Player shooter = ((Player) snowball.getShooter()).getPlayer();
                      Integer kills = points.get(shooter.getUniqueId()) + 1;
                      points.replace(shooter.getUniqueId(), kills);



                      points.replace(shooter.getUniqueId(), kills);
                            for (Player online : Bukkit.getOnlinePlayers()) {
                                if (commandJoin.joinedplayers.contains(online.getUniqueId())) {
                                    scoreboardcreat.updatescoreboard(online);
                                }
                            }
                       damaged.setInvulnerable(true);

                        new BukkitRunnable(){
                            public void run(){
                                damaged.setInvulnerable(false);

                            }

                        }.runTaskLater(main, 60);
                        Player p = (Player) damaged;
                        p.getInventory().clear();
                        commandSetup.tprandom((Player) damaged);



                   }
            //    }
            }
        }
}




}