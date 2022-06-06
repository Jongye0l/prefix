package com.Jongyeol.prefix.prefix;

import com.Jongyeol.prefix.luckypermsapi.LuckPermHandler;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;

public class join {
    public static void OnJoin(PlayerJoinEvent event) {
        if(LuckPermHandler.Prefixset(event.getPlayer())){
            event.setJoinMessage(LuckPermHandler.getPrefix(event.getPlayer()) + " " + event.getPlayer().getName() + ChatColor.YELLOW + "님이 게임에 접속하셨습니다.");
        } else {
            event.setJoinMessage(event.getPlayer().getName() + ChatColor.YELLOW + "님이 게임에 접속하셨습니다.");
        }
        load.load(event.getPlayer());
    }
}
