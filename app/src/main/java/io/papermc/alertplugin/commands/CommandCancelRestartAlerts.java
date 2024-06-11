package io.papermc.alertplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import io.papermc.alertplugin.Broadcasting;
import io.papermc.alertplugin.Main;

public class CommandCancelRestartAlerts implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    
        if (!sender.hasPermission("minecraft.op")) {
            Broadcasting.sendErrorResponse(sender, "You do not have access to this command.");
            return true;
        }

        if (!Main.restartAlertsInProgress) {
            Broadcasting.sendErrorResponse(sender, "Restart alerts have not been scheduled.");
            return true;
        }

        Main.restartAlertsTimer.cancel();
        Main.restartAlertsInProgress = false;

        Broadcasting.sendSuccessResponse(sender, "Restart alerts have been cancelled.");


        return true;
    }
}
