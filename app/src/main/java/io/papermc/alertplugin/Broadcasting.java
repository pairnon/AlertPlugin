package io.papermc.alertplugin;

import org.bukkit.command.CommandSender;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class Broadcasting {

    public static void sendMessageResponse(CommandSender c, String message) {
        c.sendMessage(Component.text("[AP] " + message, NamedTextColor.GOLD));
    }

    public static void sendSuccessResponse(CommandSender c, String message) {
        c.sendMessage(Component.text("[AP] " + message, NamedTextColor.GREEN));
    }
    
    public static void sendErrorResponse(CommandSender c, String message) {
        c.sendMessage(Component.text("[AP] " + message, NamedTextColor.RED));
    }

}
