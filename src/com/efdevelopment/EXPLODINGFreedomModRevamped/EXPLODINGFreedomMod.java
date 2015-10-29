package com.efdevelopment.EXPLODINGFreedomModRevamped;

import me.StevenLawson.TotalFreedomMod.TFM_Admin;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EXPLODINGFreedomMod {

    public static boolean muffledBlowup(Player player) {
        return player.getWorld().createExplosion(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 10f, false, false);
    }

    public static void killPlayer(Player player) {
        player.setHealth(0.0);
    }

    public static int fakeKillPlayer(Player player) {
        return Bukkit.broadcastMessage(player.getName() + " was killed by an admin");
    }
    
    public static String setLoginMessage(CommandSender sender, String args) {
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        return entry.setCustomLoginMessage(args);
    }
}