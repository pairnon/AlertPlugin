package io.papermc.alertplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import io.papermc.alertplugin.Broadcasting;

public class CommandBroadcastAlert implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("minecraft.op")) {
            Broadcasting.sendErrorResponse(sender, "You do not have access to this command.");
            return true;
        }

        if (args.length == 0) {
            Broadcasting.sendErrorResponse(sender, "You must specify a message.");
            return true;
        }

        String message = "";

        for (String word : args) {
            message += word;
            message += " ";
        }

        Broadcasting.broadcastRedAlert(message);

        return true;
    }
    
}
