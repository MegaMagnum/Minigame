package me.megamagnum.main;

import me.megamagnum.main.commands.commandJoin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MinigameTimer {
   static Main main = Main.getPlugin(Main.class);




    public static void timer(){

        // Timer every 1 minute!
        new BukkitRunnable(){
            public void run(){
                int times = 5;
                times--;
                for(Player online : Bukkit.getOnlinePlayers()){
                if (commandJoin.joinedplayers.contains(online.getUniqueId())) {
                    String message = ChatColor.RED + "Time remaining: " + times + " minutes!";

                    online.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                }
                }
            }
        }.runTaskTimer(main, 1200, 1200 );






    }
}