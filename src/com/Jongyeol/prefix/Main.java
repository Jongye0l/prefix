package com.Jongyeol.prefix;

import com.Jongyeol.prefix.prefix.Repeat;
import com.Jongyeol.prefix.Notification.madeby;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        int d = config.getInt("reloadtime");
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        BukkitTask Repeat = new Repeat().runTaskTimer(this, 0L, d);
        BukkitTask madeby = new madeby().runTaskTimer(this, 0L, 54000L);
        Plugin Luckperms = Bukkit.getPluginManager().getPlugin("LuckPerms");
        if(Luckperms == null) {
            System.out.println("Luckperms플러그인이 감지되지 않았습니다.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
    @Override
    public void onDisable() {}
}
