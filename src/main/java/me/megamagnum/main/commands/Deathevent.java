package me.megamagnum.main.commands;

import me.megamagnum.main.storage.Storage;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class Deathevent implements Listener {
    @EventHandler
    public void onDeath(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (commandJoin.joinedplayers.contains(p.getUniqueId())) {
                if (Storage.get().getBoolean("Minigame." + "started", true)) {

                    Location loc1 = new Location(p.getWorld(), 46, 64, 28);
                    Location loc2 = new Location(p.getWorld(), 38, 64, 31);
                    Location loc3 = new Location(p.getWorld(), 40, 64, 31);
                    Location loc4 = new Location(p.getWorld(), 46, 64, 31);
                    Location loc5 = new Location(p.getWorld(), 41, 64, 25);
                    Location loc6 = new Location(p.getWorld(), 43, 64, 22);

                    Location[] respawn = {loc1, loc2, loc3, loc4, loc5, loc6};
                    Random r = new Random();
                    int locr = r.nextInt(6);
                    p.teleport(respawn[locr]);
                }
            }
        }

    }
}
