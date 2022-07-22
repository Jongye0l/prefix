package com.Jongyeol.prefix.luckypermsapi;

import com.Jongyeol.prefix.prefix.load;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.event.user.UserDataRecalculateEvent;
import net.luckperms.api.event.user.track.UserPromoteEvent;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class LuckyPermReload {
    private LuckPerms luckPerms;
    public LuckyPermReload(){
        luckPerms = LuckPermsProvider.get();
        luckPerms.getEventBus().subscribe(UserPromoteEvent.class, e -> onUpdateEvent(e.getUser()));
        luckPerms.getEventBus().subscribe(UserDataRecalculateEvent.class, e -> onUpdateEvent(e.getUser()));
    }

    private void onUpdateEvent(User user){
        final UUID uuid = user.getUniqueId();
        final Player player = Bukkit.getPlayer(uuid);
        if(player != null){
            load.load(player);
        }
    }
}
