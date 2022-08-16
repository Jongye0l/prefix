package com.Jongyeol.prefix.command;

import com.Jongyeol.Library.CheckSet.Other;
import com.Jongyeol.Library.notification.CommandNotification;
import com.Jongyeol.Library.prefix.Prefix;
import com.Jongyeol.prefix.Main;
import com.Jongyeol.prefix.prefix.load;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class setprefix implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String cmd, String[] args) {
        if(args.length < 1) {
            Sender.sendMessage(ChatColor.GREEN + "사용법 : /" + cmd + " <OfflinePlayer> <prefix>");
            return true;
        }
        OfflinePlayer target = Other.getOfflinePlayer(args[0]);
        if(target == null) {
            Sender.sendMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
            return true;
        }
        if(args.length < 2) {
            setPrefix(target, "");
            Sender.sendMessage(Prefix.getPrefix(target) + target.getName() + ChatColor.GREEN + "님에 칭호를 초기화하였습니다.");
            CommandNotification.CommandNoti("Prefix.setprefix", Prefix.getPrefix(target) + target.getName() + ChatColor.GREEN + "님에 칭호를 초기화하였습니다.", Sender);
            return true;
        }
        String prefix = setPrefix(target, args[1] + " ");
        Sender.sendMessage(Prefix.getPrefix(target) + target.getName() + ChatColor.GREEN + "님에 칭호를 " + prefix + ChatColor.GREEN + "로 설정하였습니다.");
        CommandNotification.CommandNoti("Prefix.setprefix", Prefix.getPrefix(target) + target.getName() + ChatColor.GREEN + "님에 칭호를 " + prefix + ChatColor.GREEN + "로 설정하였습니다.", Sender);
        return true;
    }
    public static String setPrefix(OfflinePlayer player, String prefix){
        FileConfiguration config = Main.main.getConfig();
        String prefixx = "";
        if(prefix.equals("")) {
            prefixx = "";
        } else {
            String[] pre = prefix.split("");
            for(int i = 0; i < pre.length; i++){
                if(pre[i].equals("&")) {
                    if(pre.length > i + 1) {
                        if(org.bukkit.ChatColor.getByChar(pre[i + 1]) == null) {
                            prefixx = prefixx + pre[i];
                            continue;
                        }
                    }
                    prefixx = prefixx + org.bukkit.ChatColor.COLOR_CHAR;
                    continue;
                }
                prefixx = prefixx + pre[i];
            }
        }
        config.set("Prefix." + player.getUniqueId(), prefixx);
        Main.main.saveConfig();
        if(player instanceof Player){
            load.load((Player) player);
        }
        return prefixx;
    }
}
