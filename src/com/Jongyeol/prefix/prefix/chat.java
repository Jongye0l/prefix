package com.Jongyeol.prefix.prefix;

import com.Jongyeol.Library.prefix.Prefix;
import com.Jongyeol.prefix.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chat {
    public static void OnChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setFormat(Main.main.getConfig().getString("Prefix." + player.getUniqueId()) + Prefix.getPrefix(player) + player.getName() + ChatColor.RESET + " : " + event.getMessage());
    }
}
