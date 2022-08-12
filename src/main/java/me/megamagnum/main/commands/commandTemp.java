package me.megamagnum.main.commands;

import me.megamagnum.main.events.HitEvent;
import me.megamagnum.main.scoreboardcreat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class commandTemp implements CommandExecutor {
    static HashMap points = HitEvent.points;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        int i = (int) points.get(player.getUniqueId());
        player.sendMessage(String.valueOf(i));

        scoreboardcreat.updatescoreboard(player);

        return true;
    }
}