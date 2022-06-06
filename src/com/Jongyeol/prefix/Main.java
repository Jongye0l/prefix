package com.Jongyeol.prefix;

import com.Jongyeol.prefix.prefix.Repeat;
import com.Jongyeol.prefix.Notification.madeby;
import org.bukkit.configuration.file.FileConfiguration;
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
    }
    @Override
    public void onDisable() {}
}
