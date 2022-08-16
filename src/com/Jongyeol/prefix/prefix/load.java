package com.Jongyeol.prefix.prefix;

import com.Jongyeol.Library.prefix.Prefix;
import com.Jongyeol.prefix.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class load {
    public static void load(Player player) {
        FileConfiguration config = Main.main.getConfig();
        String prefix = config.getString("Prefix." + player.getUniqueId());
        if(prefix.equals("")) prefix = Prefix.getPrefix(player);
        player.setDisplayName(prefix + player.getName());
        player.setPlayerListName(prefix + player.getName());
        Team t = player.getScoreboard().getTeam("" + player.getName());
        if(t == null) t = player.getScoreboard().registerNewTeam("" + player.getName());
        t.setPrefix(prefix);
        ChatColor color = ChatColor.RESET;
        String[] pre = prefix.split("");
        for(int i = 0; i < pre.length; i++){
            if(pre[i].equals(ChatColor.COLOR_CHAR + "")) color = ChatColor.getByChar(pre[i+1]);
        }
        t.setColor(color);
        if(!t.hasEntry(player.getName())) t.addEntry(player.getName());
    }
}
