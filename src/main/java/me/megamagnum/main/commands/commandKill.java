package me.megamagnum.main.commands;

import me.megamagnum.main.events.HitEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class commandKill implements CommandExecutor {

    static HashMap points = HitEvent.points;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        int kills = (int) points.get(player.getName()) + 1;
        points.replace(player.getName(), kills);



        return true;
    }
}