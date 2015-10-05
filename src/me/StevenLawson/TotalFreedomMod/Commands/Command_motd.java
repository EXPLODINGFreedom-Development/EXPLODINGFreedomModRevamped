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
public class Command_motd extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {        
        server.dispatchCommand(sender, "motd");
        playerMsg("§1§l-=-§4§k§liii§7§l-=-§e§lWelcome,§b " + sender.getName() + " §e§lto EXPLODINGFreedom!§7§l-=-§4§k§liii§7§l-=-", ChatColor.GOLD);
        playerMsg("§2§lThe Founder and §4§lOwner §2§lis §1§lEXPLODINGTNT001!", ChatColor.GOLD);
        playerMsg("§2§lThe Co-Founders are §6§lzthehorsekid and §e§lXxNicozillaxX", ChatColor.GOLD);
        playerMsg("§2§lRemember to read the rules in /rules and listen to staff or admins!" + ChatColor.GOLD);
        playerMsg("§1§lHave fun at EXPLODINGFreedom All-Op!", ChatColor.GOLD);
        return true;  
       }

          {
        }
    }
