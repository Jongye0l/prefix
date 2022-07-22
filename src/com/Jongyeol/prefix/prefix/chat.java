package com.Jongyeol.prefix.prefix;

import com.Jongyeol.Library.prefix.Prefix;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chat {
    public static void OnChat(AsyncPlayerChatEvent event) {
        event.setFormat(Prefix.getPrefix(event.getPlayer()) + event.getPlayer().getName() + ChatColor.RESET + " : " + event.getMessage());
    }
}
