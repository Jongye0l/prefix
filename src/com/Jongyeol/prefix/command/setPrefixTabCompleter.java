package com.Jongyeol.prefix.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class setPrefixTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender Sender, Command command, String cmd, String[] args) {
        if (args.length == 1) {
            return null;
        }
        return new ArrayList<>();
    }
}
