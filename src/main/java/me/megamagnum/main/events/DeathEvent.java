package me.megamagnum.main.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
    
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if(e.getEntity() instanceof Player){
            Player p = e.getEntity().getPlayer();


            e.setKeepInventory(true);


            if(e.getEntity().getKiller() == null){
                e.setDeathMessage(p.getDisplayName()+ ChatColor.RED + " killed himself... lol");

            }else {
                Player k = e.getEntity().getKiller();

                e.setDeathMessage(p.getDisplayName() + ChatColor.RED + "was killed by" + ChatColor.RESET + k.getDisplayName());

            }



        }
        
        
    }
    
}
