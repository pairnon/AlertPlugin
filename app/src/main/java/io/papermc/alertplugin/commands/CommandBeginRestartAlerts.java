package io.papermc.alertplugin.commands;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import io.papermc.alertplugin.Broadcasting;
import io.papermc.alertplugin.Main;

public class CommandBeginRestartAlerts implements CommandExecutor {

    private static final int DURATION_IN_MINUTES = 10;

    private static ArrayList<Integer> schedulingValuesContainer = new ArrayList<Integer>();
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("minecraft.op")) {
            Broadcasting.sendErrorResponse(sender, "You do not have access to this command.");
            return true;
        }

        if (Main.restartAlertsInProgress) {
            Broadcasting.sendErrorResponse(sender, "Restart alerts have already been scheduled.");
            return true;
        }

        Main.restartAlertsInProgress = true;
        Broadcasting.sendSuccessResponse(sender, "Beginning restart alerts (" + DURATION_IN_MINUTES + " minutes).");

        scheduleRestartAlerts();

        return true;
    }

    private static void scheduleRestartAlerts() {

        Broadcasting.broadcastRedAlert("Server restarting in " + DURATION_IN_MINUTES + " minutes.");
        
        Main.restartAlertsTimer = new Timer();

        for (int i = 5; i >= 1; i--) {
            schedulingValuesContainer.add(i);
            int lastIndex = schedulingValuesContainer.size() - 1;
            if (i != 1) {
                Main.restartAlertsTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Broadcasting.broadcastRedAlert("Server restarting in " + schedulingValuesContainer.get(lastIndex) + " minutes.");
                    }
                }, calculateDelayFromMinutes(i));
            } else {
                Main.restartAlertsTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Broadcasting.broadcastRedAlert("Server restarting in " + schedulingValuesContainer.get(lastIndex) + " minute.");
                    }
                }, calculateDelayFromMinutes(i));
            }

        }

        for (int i = 30; i >= 20; i -= 10) {
            schedulingValuesContainer.add(i);
            int lastIndex = schedulingValuesContainer.size() - 1;
            Main.restartAlertsTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Broadcasting.broadcastRedAlert("Server restarting in " + schedulingValuesContainer.get(lastIndex) + " seconds.");
                }
            }, calculateDelayFromSeconds(i));
        }

        for (int i = 10; i >= 1; i--) {
            schedulingValuesContainer.add(i);
            int lastIndex = schedulingValuesContainer.size() - 1;
            if (i != 1) {
                Main.restartAlertsTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Broadcasting.broadcastRedAlert("Server restarting in " + schedulingValuesContainer.get(lastIndex) + " seconds.");
                    }
                }, calculateDelayFromSeconds(i));
            } else {
                Main.restartAlertsTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Broadcasting.broadcastRedAlert("Server restarting in " + schedulingValuesContainer.get(lastIndex) + " second.");
                    }
                }, calculateDelayFromSeconds(i));
            }


        }
    }

    private static int calculateDelayFromMinutes(int remainingMinutes) {
        return (DURATION_IN_MINUTES - remainingMinutes) * 60000;
    }

    private static int calculateDelayFromSeconds(int remainingSeconds) {
        return ((DURATION_IN_MINUTES * 60) - remainingSeconds) * 1000;
    }

}