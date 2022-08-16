package com.Jongyeol.prefix.prefix;

import com.Jongyeol.Library.prefix.Prefix;
import com.Jongyeol.prefix.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class join {
    public static void OnJoin(PlayerJoinEvent event) {
        FileConfiguration config = Main.main.getConfig();
        if(!config.contains("Prefix." + event.getPlayer().getUniqueId())){
            config.set("Prefix." + event.getPlayer().getUniqueId(), "");
        }
        event.setJoinMessage(Prefix.getPrefix(event.getPlayer()) + event.getPlayer().getName() + ChatColor.YELLOW + "님이 게임에 접속하셨습니다.");
        load.load(event.getPlayer());
    }
    public static void OnQuit(PlayerQuitEvent event){
        event.setQuitMessage(Prefix.getPrefix(event.getPlayer()) + event.getPlayer().getName() + ChatColor.YELLOW + "님이 게임을 떠났습니다.");
    }
}
