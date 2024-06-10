package io.papermc.alertplugin.commands;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import io.papermc.alertplugin.Broadcasting;

public class CommandBeginRestartAlerts implements CommandExecutor {

    private static final int DURATION_IN_MINUTES = 10;
    
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

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 5 minutes.");
            }
        }, calculateDelayFromMinutes(5));

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 4 minutes.");
            }
        }, calculateDelayFromMinutes(4));

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 3 minutes.");
            }
        }, calculateDelayFromMinutes(3));
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 2 minutes.");
            }
        }, calculateDelayFromMinutes(2));
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 1 minute.");
            }
        }, calculateDelayFromMinutes(2));
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 30 seconds.");
            }
        }, calculateDelayFromSeconds(30));

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 20 seconds.");
            }
        }, calculateDelayFromSeconds(20));

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 10 seconds.");
            }
        }, calculateDelayFromSeconds(10));

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 9 seconds.");
            }
        }, calculateDelayFromSeconds(9));

        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 8 seconds.");
            }
        }, calculateDelayFromSeconds(8));
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 7 seconds.");
            }
        }, calculateDelayFromSeconds(7));
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 6 seconds.");
            }
        }, calculateDelayFromSeconds(6));
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 5 seconds.");
            }
        }, calculateDelayFromSeconds(5));
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 4 seconds.");
            }
        }, calculateDelayFromSeconds(4));
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 3 seconds.");
            }
        }, calculateDelayFromSeconds(3));
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 2 seconds.");
            }
        }, calculateDelayFromSeconds(2));

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Broadcasting.broadcastRedAlert("Server restarting in 1 second.");
            }
        }, calculateDelayFromSeconds(1));

    }

    private static int calculateDelayFromMinutes(int remainingMinutes) {
        return (DURATION_IN_MINUTES - remainingMinutes) * 60000;
    }

    private static int calculateDelayFromSeconds(int remainingSeconds) {
        return ((DURATION_IN_MINUTES * 60) - remainingSeconds) * 60000;
    }

}