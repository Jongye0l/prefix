package com.Jongyeol.prefix.prefix;

import com.Jongyeol.prefix.luckypermsapi.LuckPermHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class load {
    public static void load(Player player) {
        if(LuckPermHandler.Prefixset(player)) {
            player.setDisplayName(LuckPermHandler.getPrefix(player) + " " + player.getName());
            player.setPlayerListName(LuckPermHandler.getPrefix(player) + " " + player.getName());
            //Team t = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam("" + player.getName());
            //t.setPrefix("");
        }
    }
}
