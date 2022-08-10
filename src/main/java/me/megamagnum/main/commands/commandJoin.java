package me.megamagnum.main.commands;

import me.megamagnum.main.storage.Storage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class commandJoin implements CommandExecutor {
    public static ArrayList<UUID> joinedplayers = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Boolean starting = Storage.get().getBoolean("Minigame." + "IsStarting");
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (starting) {
                if(joinedplayers.contains(p.getUniqueId())) {
                    p.sendMessage(ChatColor.RED + "Already joined!");
                }else{
                    joinedplayers.add(p.getUniqueId());
                    p.sendMessage(ChatColor.RED + "Joined the minigame. Wait till it starts!");
                }


            } else {

                p.sendMessage(ChatColor.RED + "There is no minigame starting! Ask a admin to start a minigame event!");
            }


        } else {
            sender.sendMessage("Sorry you are unable to join!");
        }


        return true;
    }



}

