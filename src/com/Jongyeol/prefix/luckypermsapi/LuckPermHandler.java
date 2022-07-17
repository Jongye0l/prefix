package com.Jongyeol.prefix.luckypermsapi;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import org.bukkit.entity.Player;

public class LuckPermHandler {
    private static LuckPerms luckPerms;
    public static String getPrefix(Player player) {
        return getPrimaryGroup(player).getCachedData().getMetaData().getPrefix().replace("&", "§");
    }
    public static Group getPrimaryGroup(Player player) {
        return LuckPermHandler.luckPerms.getGroupManager().getGroup(LuckPermHandler.luckPerms.getUserManager().getUser(player.getUniqueId()).getPrimaryGroup());
    }
    public static boolean Prefixset(Player player) {
        return getPrimaryGroup(player).getCachedData().getMetaData().getPrefix() != null;
    }
    static {
        luckPerms = LuckPermsProvider.get();
    }
}
