package me.megamagnum.main;

import me.megamagnum.main.commands.commandJoin;
import me.megamagnum.main.events.HitEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.HashMap;

public class scoreboardcreat {
    static HashMap points = HitEvent.points;
   static ScoreboardManager manager  = Bukkit.getScoreboardManager();
   static Scoreboard scoreboard = manager.getNewScoreboard();

   static Objective objective = scoreboard.registerNewObjective("test", "Dummy", ChatColor.RED + "Snowballed");


    public static void scoreboard(Player player){
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        for(int i = 0; i < commandJoin.joinedplayers.size(); i++) {
            Integer kills = (Integer) points.get(player.getName());
            Score score = objective.getScore(ChatColor.AQUA + player.getName() +":");
            score.setScore(kills);
        }

        player.setScoreboard(scoreboard);

    }

    public static void removescoreboard(Player player){
        ScoreboardManager manager  = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        player.setScoreboard(scoreboard);

    }
    public static void updatescoreboard(Player player){
        for(int i = 0; i < commandJoin.joinedplayers.size(); i++) {
            Score score = objective.getScore(ChatColor.AQUA + player.getName() + ":");
            Integer kills = (Integer) points.get(player.getName());
            score.setScore(kills);
        }


    }
}