package com.Jongyeol.prefix;

import com.Jongyeol.prefix.prefix.Repeat;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.logging.Level;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        int d = config.getInt("reloadtime");
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        BukkitTask Repeat = new Repeat().runTaskTimer(this, 0L, d);
        if(Bukkit.getPluginManager().getPlugin("LuckPerms") == null) {
            getLogger().log(Level.SEVERE, "Luckperms 플러그인이 감지되지 않았습니다.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        if (Bukkit.getPluginManager().getPlugin("JongyeolLibrary") == null) {
            getLogger().log(Level.SEVERE, "JongyeolLibrary 플러그인이 감지되지 않았습니다.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
    @Override
    public void onDisable() {}
}
