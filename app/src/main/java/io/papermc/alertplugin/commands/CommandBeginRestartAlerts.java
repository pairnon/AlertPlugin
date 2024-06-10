package io.papermc.alertplugin.commands;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import io.papermc.alertplugin.Broadcasting;

public class CommandBeginRestartAlerts implements CommandExecutor {

    private static final int DURATION_IN_MINUTES = 10;

    private static int schedulingValueContainer = 0;
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("minecraft.op")) {
            Broadcasting.sendErrorResponse(sender, "You do not have access to this command.");
            return true;
        }
        
        Broadcasting.sendSuccessResponse(sender, "Beginning restart alerts (" + DURATION_IN_MINUTES + " minutes).");

        scheduleRestartAlerts();

        return true;
    }

    private static void scheduleRestartAlerts() {

        Broadcasting.broadcastRedAlert("Server restarting in " + DURATION_IN_MINUTES + " minutes.");
        Timer timer = new Timer();

        for (int i = 5; i >= 1; i--) {
            schedulingValueContainer = i;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Broadcasting.broadcastRedAlert("Server restarting in " + schedulingValueContainer + " minutes.");
                }
            }, calculateDelayFromMinutes(schedulingValueContainer));

        }

        for (int i = 30; i >= 20; i -= 10) {
            schedulingValueContainer = i;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Broadcasting.broadcastRedAlert("Server restarting in " + schedulingValueContainer + " seconds.");
                }
            }, calculateDelayFromSeconds(schedulingValueContainer));
        }

        for (int i = 10; i >= 1; i--) {
            schedulingValueContainer = i;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Broadcasting.broadcastRedAlert("Server restarting in " + schedulingValueContainer + " seconds.");
                }
            }, calculateDelayFromSeconds(schedulingValueContainer));

        }
    }

    private static int calculateDelayFromMinutes(int remainingMinutes) {
        return (DURATION_IN_MINUTES - remainingMinutes) * 60000;
    }

    private static int calculateDelayFromSeconds(int remainingSeconds) {
        return ((DURATION_IN_MINUTES * 60) - remainingSeconds) * 1000;
    }

}