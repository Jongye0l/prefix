package com.Jongyeol.prefix.command;

import com.Jongyeol.Library.CheckSet.Other;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setrank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String Cmd, String[] args) {
        if(args.length < 1) {
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + Cmd + " <player> <rank>");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if(!Other.playerCheck(target)) {
            Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
            return true;
        }
        return true;
    }

}
