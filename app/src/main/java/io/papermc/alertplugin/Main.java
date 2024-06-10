package io.papermc.alertplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import io.papermc.alertplugin.commands.CommandRestartAlert;

public class Main extends JavaPlugin implements Listener {
    
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        this.getCommand("restartalert").setExecutor(new CommandRestartAlert());
    }

}
