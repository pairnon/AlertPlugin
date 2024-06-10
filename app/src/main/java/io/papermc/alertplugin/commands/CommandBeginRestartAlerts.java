package io.papermc.alertplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import io.papermc.alertplugin.Broadcasting;

public class CommandBeginRestartAlerts implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("minecraft.op")) {
            Broadcasting.sendErrorResponse(sender, "You do not have access to this command.");
            return true;
        }
        
        Broadcasting.sendSuccessResponse(sender, "Beginning restart alerts.");

        return true;
    }

}
