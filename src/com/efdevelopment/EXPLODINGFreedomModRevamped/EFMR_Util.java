package com.efdevelopment.EXPLODINGFreedomModRevamped;

import me.StevenLawson.TotalFreedomMod.TFM_BuilderList;
import me.StevenLawson.TotalFreedomMod.TFM_Admin;
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
import org.bukkit.scheduler.BukkitScheduler;

public class EFMR_Util
{
  public static TotalFreedomMod plugin;
  private final Server server;
  
  public EFMR_Util(TotalFreedomMod plugin)
  {
    plugin = plugin;
    this.server = plugin.getServer();
  }
  
  public void sendSyncMessage(final CommandSender sendTo, final String message)
  {
    Bukkit.getScheduler().runTask(plugin, new Runnable()
    {
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
    for (Player player : Bukkit.getOnlinePlayers()) {
      if ((TFM_BuilderList.isBuilderPlus(player)) || 
        (TFM_BuilderList.isBuilder(player)) || 
        (TFM_AdminList.isSeniorAdmin(player))) {
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
    this.server.broadcastMessage(color + admin + " - " + action);
  }
  
  public void adminAction(CommandSender sender, String action)
  {
    adminAction(sender.getName(), action, ChatColor.RED);
  }
  
  public static String getVerifyPassword(CommandSender sender)
  {
    TFM_Admin entry = TFM_AdminList.getEntry((Player)sender);
    String password = entry.getVerifyPassword();
    if ("".equals(password))
    {
      sender.sendMessage(ChatColor.RED + "No password has been set!");
      return "Error.";
    }
    return password;
  }
  
  public static String setVerifyPassword(CommandSender sender, String args)
  {
    TFM_Admin entry = TFM_AdminList.getEntry((Player)sender);
    if (!"".equals(entry.getVerifyPassword()))
    {
      sender.sendMessage("Verify password must be not set to be set!");
      return null;
    }
    return entry.setVerifyPassword(args);
  }
}
