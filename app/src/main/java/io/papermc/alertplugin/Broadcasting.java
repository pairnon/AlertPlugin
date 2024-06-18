package io.papermc.alertplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

    public static void broadcastAlert(String message) {
        Bukkit.broadcast(Component.text("[ALERT] " + message, NamedTextColor.RED));
        sendSoundToAllPlayers(Sound.BLOCK_NOTE_BLOCK_SNARE);
    }

    public static void sendSoundToAllPlayers(Sound sound) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            Location loc = player.getLocation();
            player.playSound(loc, sound, 1.0F, 1.0F);
        }
    }

}
