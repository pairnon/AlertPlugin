package io.papermc.alertplugin;

import java.util.Timer;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import io.papermc.alertplugin.commands.CommandBeginRestartAlerts;
import io.papermc.alertplugin.commands.CommandBroadcastAlert;
import io.papermc.alertplugin.commands.CommandCancelRestartAlerts;

public class Main extends JavaPlugin implements Listener {

    public static boolean restartAlertsInProgress = false;
    public static Timer restartAlertsTimer;
    
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        this.getCommand("beginrestartalerts").setExecutor(new CommandBeginRestartAlerts());
        this.getCommand("cancelrestartalerts").setExecutor(new CommandCancelRestartAlerts());
        this.getCommand("broadcastalert").setExecutor(new CommandBroadcastAlert());
    }

}
