package com.Jongyeol.prefix;

import com.Jongyeol.prefix.command.setPrefixTabCompleter;
import com.Jongyeol.prefix.command.setprefix;
import com.Jongyeol.prefix.luckypermsapi.LuckyPermReload;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Main extends JavaPlugin {
    public static Main main;
    @Override
    public void onEnable() {
        main = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        if(Bukkit.getPluginManager().getPlugin("LuckPerms") == null) {
            getLogger().log(Level.SEVERE, "Luckperms 플러그인이 감지되지 않았습니다.");
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
            new LuckyPermReload();
        }
        final Plugin JongyeolLibrary = Bukkit.getPluginManager().getPlugin("JongyeolLibrary");
        if(JongyeolLibrary == null){
            getLogger().log(Level.SEVERE, "JongyeolLibrary 플러그인이 감지되지 않았습니다.");
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
            String version = JongyeolLibrary.getDescription().getVersion();
            String[] versions = version.split("\\.");
            boolean a = true;
            if(Integer.parseInt(versions[0]) < 1){
                a = false;
            } else if(Integer.parseInt(versions[1]) < 2){
                a = false;
            } else if (Integer.parseInt(versions[2]) < 0) {
                a = false;
            }
            if(!a){
                getLogger().log(Level.SEVERE, "JongyeolLibrary 플러그인에 버전이 지원하지 않는 버전입니다. 업데이트를 해주세요!");
                Bukkit.getPluginManager().disablePlugin(this);
            }
        }
        getCommand("setprefix").setExecutor(new setprefix());
        getCommand("setprefix").setTabCompleter(new setPrefixTabCompleter());
    }
    @Override
    public void onDisable() {}
}
