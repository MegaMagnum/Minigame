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
        player.setScoreboard(scoreboard);
        Score score = objective.getScore(player.getPlayer());
        int i = (int) points.get(player.getName());
        score.setScore(i);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);


    }

    public static void removescoreboard(Player player){
        ScoreboardManager manager  = Bukkit.getScoreboardManager();
        Scoreboard scoreboardclean = manager.getNewScoreboard();

        player.setScoreboard(scoreboardclean);

    }
    public static void updatescoreboard(Player player){
        Score score = objective.getScore(player.getPlayer());
        int i = (int) points.get(player.getName());
        score.setScore(i);
        player.setScoreboard(scoreboard);



    }
}