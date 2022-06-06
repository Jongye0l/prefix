package com.Jongyeol.prefix.prefix;

import com.Jongyeol.prefix.luckypermsapi.LuckPermHandler;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chat {
    public static void OnChat(AsyncPlayerChatEvent event) {
        if(LuckPermHandler.Prefixset(event.getPlayer())){
            event.setFormat(LuckPermHandler.getPrefix(event.getPlayer()) + " " + event.getPlayer().getName() + ChatColor.RESET + " : " + event.getMessage());
        } else {
            event.setFormat(event.getPlayer().getName() + ChatColor.RESET + " : " + event.getMessage());
        }
    }
}
