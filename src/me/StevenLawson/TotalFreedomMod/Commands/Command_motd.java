 package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Views the message of the day", usage = "/<command>")
public class Command_motd extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {        
        playerMsg("§1§l-=-§4§k§liii§7§l-=-§e§lWelcome,§b " + sender.getName() + " §e§lto EXPLODINGFreedom!§7§l-=-§4§k§liii§7§l-=-", ChatColor.GOLD);
        playerMsg("§2§lThe Founder and §4§lOwner §2§lis §1§lAlco_Rs11!", ChatColor.GOLD);
        playerMsg("§2§lThe Co-Founders are §6§lJayscoob and §e§lKM_Galahad", ChatColor.GOLD);
        playerMsg("§2§lRemember to read the rules in /rules and listen to staff or admins!" + ChatColor.GOLD);
        playerMsg("§1§lHave fun at EXPLODINGFreedom All-Op!", ChatColor.GOLD);
        return true;  
       }

          {
        }
    }
