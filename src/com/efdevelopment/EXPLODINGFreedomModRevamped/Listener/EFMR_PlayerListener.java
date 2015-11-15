package com.efdevelopment.EXPLODINGFreedomModRevamped.Listener;

import me.StevenLawson.TotalFreedomMod.TFM_BuilderList;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EFMR_PlayerListener
  implements Listener
{
  private static final int MIN_WORD_LENGTH = 4;
  
  @EventHandler(priority=EventPriority.HIGH)
  public static void onPlayerJoinEvent(PlayerJoinEvent event)
  {
    Player player = event.getPlayer();
    if (TFM_BuilderList.isBuilder(player))
    {
      player.setPlayerListName(ChatColor.YELLOW + player.getName());
      TFM_PlayerData.getPlayerData(player).setTag("&8[&6Master-Builder&8]");
    }
    else if (TFM_BuilderList.isBuilderPlus(player))
    {
      player.setPlayerListName(ChatColor.YELLOW + player.getName());
      TFM_PlayerData.getPlayerData(player).setTag("&8[&6Master-Builder+&8]");
    }
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
  {
    Player player = event.getPlayer();
    String command = event.getMessage().toLowerCase().trim();
    if (TFM_AdminList.isSuperAdmin(player)) {
      for (Player pl : Bukkit.getOnlinePlayers()) {
        if ((TFM_AdminList.isSeniorAdmin(pl)) && (pl != player) && (TFM_PlayerData.getPlayerData(pl).cmdspyEnabled())) {
          TFM_Util.playerMsg(pl, player.getName() + ": " + command);
        }
      }
    }
    if ((command.contains("175:4")) || (command.contains("anvil:")))
    {
      event.setCancelled(true);
      TFM_Util.bcastMsg(player.getName() + " just attempted to use the crash item! Deal with them appropriately please!", ChatColor.DARK_RED);
    }
    if ((command.contains("&k")) && (!TFM_AdminList.isSuperAdmin(player)))
    {
      event.setCancelled(true);
      TFM_Util.playerMsg(player, ChatColor.RED + "You are not permitted to use &k!");
    }
  }
}