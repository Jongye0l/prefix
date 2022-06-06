package com.Jongyeol.prefix;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class variables {
    public static boolean FoundPlayer(Player player) {
        boolean b = false;
        for (Player player2 : Bukkit.getOnlinePlayers()){
            if(player2.equals(player)){b = true;}
        }
        if(b) { return true; }
        return false;
    }
}
