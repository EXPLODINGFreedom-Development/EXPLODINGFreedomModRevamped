package com.efdevelopment.EXPLODINGFreedomModRevamped;

import java.util.Arrays;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.TFM_Admin;
import com.efdevelopment.EXPLODINGFreedomModRevamped.misc.EFMR_BuilderList;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerRank;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EFMR_Util
{

    public static TotalFreedomMod plugin;

        private final Server server;

    public EFMR_Util(TotalFreedomMod plugin)
    {
        this.plugin = plugin;
        this.server = plugin.getServer();
    }

    public void sendSyncMessage(final CommandSender sendTo, final String message)
    {
        Bukkit.getScheduler().runTask(plugin, new Runnable()
        {
            @Override
            public void run()
            {
                sendTo.sendMessage(message);
            }
        });
    }    
    public static void builderChatMessage(CommandSender sender, String message, boolean senderisConsole)
    {
        String name = sender.getName() + " " + TFM_PlayerRank.fromSender(sender).getPrefix() + ChatColor.WHITE;
        TFM_Log.info("[BuilderChat]" + name + ":" + message);

        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (EFMR_BuilderList.isBuilderPlus(player)
                   || EFMR_BuilderList.isBuilder(player)
                    || TFM_AdminList.isSeniorAdmin(player))
            {
                player.sendMessage("[" + ChatColor.GOLD + "Builder Chat" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + name + ": " + ChatColor.YELLOW + message);
            }
        }
    }

    public static boolean inGod(Player player)
    {
        return TFM_PlayerData.getPlayerData(player).inGod();
    }

    public static void setGod(Player player, boolean enabled)
    {
        TFM_PlayerData.getPlayerData(player).setGod(enabled);
    }

    public void msg(CommandSender sender, String message)
    {
        sender.sendMessage(ChatColor.YELLOW + message);

    }

    public void adminAction(String admin, String action, ChatColor color)
    {
        server.broadcastMessage(color + admin + " - " + action);
    }

    public void adminAction(CommandSender sender, String action)
    {
        adminAction(sender.getName(), action, ChatColor.RED);
    }

public static String getVerifyPassword(CommandSender sender) {
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        final String password = entry.getVerifyPassword();
        if ("".equals(password)) {
            sender.sendMessage(ChatColor.RED + "No password has been set!");
            return "fuck";
        }
        
        return password;
    }
    
    public static String setVerifyPassword(CommandSender sender, String args) {
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (!"".equals(entry.getVerifyPassword())) {
            sender.sendMessage("Verify password must be not set to be set!");
            return null;
        }
        
        return entry.setVerifyPassword(args);
    }
}
