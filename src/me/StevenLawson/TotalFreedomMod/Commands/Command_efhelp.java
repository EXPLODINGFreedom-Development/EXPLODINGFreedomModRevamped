package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Shows information about the server", usage = "/<command>")
public class Command_efhelp extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
      playerMsg("EXPLODINGFreedom is a Creative Sandbox Free-OP server for the game 'Minecraft' that was created on July 11 2014!", ChatColor.AQUA);
      playerMsg("EXPLODINGFreedom is owned by Alco_Rs11 and it's co-owners are currently Jayscoob and KM_Galahad.", ChatColor.GOLD);
      playerMsg("The server has room for a max of 35 players.  On the server you get OP and you can have maximum freedom but you must follow some simple ground rules to ensure everyone has fun.", ChatColor.GOLD);
      playerMsg("The fourms are at " + ChatColor.AQUA + "http://explodingfreedom.boards.net/" + ChatColor.GREEN + " You can apply for admin and more at the forums, So sign up have fun!", ChatColor.AQUA);
   return false;
    }
}