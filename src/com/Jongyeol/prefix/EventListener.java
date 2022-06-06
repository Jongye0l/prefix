package com.Jongyeol.prefix;

import com.Jongyeol.prefix.prefix.chat;
import com.Jongyeol.prefix.prefix.join;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener{
    @EventHandler
    public void OnChat(AsyncPlayerChatEvent event) {
        chat.OnChat(event);
    }
    @EventHandler
    public void OnJoin(PlayerJoinEvent event) {
        join.OnJoin(event);
    }
}
