package me.megamagnum.main.events;

import me.megamagnum.main.Main;
import me.megamagnum.main.commands.commandJoin;
import me.megamagnum.main.commands.commandSetup;
import me.megamagnum.main.scoreboardcreat;
import me.megamagnum.main.storage.Storage;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class HitEvent implements Listener {
    public static HashMap<String, Integer> points = new HashMap<>();

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        Main main = Main.getPlugin(Main.class);
        if(event.getEntity() instanceof Player) {
            Entity damaged = event.getEntity();
            Entity damagedealer = event.getDamager();
          //  if(event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
                if (commandJoin.joinedplayers.contains(damaged.getUniqueId())) {
                    if (Storage.get().getBoolean("Minigame." + "started", true)) {
                        Integer kills = points.get(damagedealer.getName());
                        points.replace( damagedealer.getName(), kills++);


                        scoreboardcreat.updatescoreboard((Player) damaged);
                        damaged.setInvulnerable(true);

                        new BukkitRunnable(){
                            public void run(){
                                damaged.setInvulnerable(false);

                            }

                        }.runTaskLater(main, 60);
                        Player p = (Player) damaged;
                        p.getInventory().clear();
                        commandSetup.tprandom((Player) damaged);



               //     }
                }
            }
        }
    }




}