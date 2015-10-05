 package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import static me.StevenLawson.TotalFreedomMod.TotalFreedomMod.server;
import me.confuser.barapi.BarAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent; 

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Views the message of the day", usage = "/<command>")
public class Command_votelinks extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {        
        playerMsg("§b**********§aEXPLODINGFreedom Vote Links§b***************", ChatColor.GOLD);
        playerMsg("§b*   §aMake EF More Popular and Vote!                 §b*", ChatColor.GOLD);
        playerMsg("§b*http://minecraft-mp.com/server/97579/vote/          §b* ", ChatColor.GOLD);
        playerMsg("§b*http://minecraft-server-list.com/server/318171/vote/§b*" + ChatColor.GOLD);
        playerMsg("§b* §a Thank You for voting and have a good day!       §b*", ChatColor.GOLD);
        playerMsg("§b********************************************************", ChatColor.GOLD);
        return true;  
       }

          {
        }
    }
