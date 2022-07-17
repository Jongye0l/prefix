package com.Jongyeol.prefix;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class variables {
    public static boolean FoundPlayer(Player player) {
        for (Player player2 : Bukkit.getOnlinePlayers()){
            if(player2.equals(player)){return true;}
        }
        return false;
    }
}
