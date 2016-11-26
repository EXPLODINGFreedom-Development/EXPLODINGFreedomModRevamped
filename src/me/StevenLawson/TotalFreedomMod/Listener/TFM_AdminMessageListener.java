package me.StevenLawson.TotalFreedomMod.Listener;

import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.Player.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.Rank.TFM_PlayerRank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TFM_AdminMessageListener
{
    public static void adminMessageListener(CommandSender sender, String message, boolean senderIsConsole)
    {
        String name = sender.getName() + " " + TFM_PlayerRank.fromSender(sender).getPrefix() + ChatColor.WHITE;
        TFM_Log.info("[ADMIN NOTIFIER] " + name + ": " + message);

        for (Player player : Bukkit.getOnlinePlayers())
        {
            final TFM_PlayerData playerdata = TFM_PlayerData.getPlayerData(player);
            player.sendMessage("§e[" + ChatColor.YELLOW + "NOTICE" + ChatColor.YELLOW + "§e] " + ChatColor.DARK_GRAY+ name + ": " + ChatColor.YELLOW + message);
        }
    }
}