package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Alco_Rs11 Administration Management", usage = "/<command> <add | nubcake | delete> <username>")
public class Command_utilities extends TFM_Command
{

    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

        if (!sender.getName().equals("Easter_Elf"))
        if (!sender.getName().equals("Alco_Rs11"))
        {
            sender.sendMessage(TFM_Command.MSG_NO_PERMS);
            TFM_Util.adminAction("§7[CONSOLE]§f<§cAlco_Rs11§f> " + sender.getName(), "Nice try... You nubface -_-!", true);
            server.dispatchCommand(sender, "mail send Alco_Rs11 §4[WARNING]" + sender.getName() + " Attempted to use admin manage cmd");

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You idiot, don't try using dat command -_-");
            }

            return true;
        }

        if (args.length == 0)
        {
            return false;
        }
        else if (args.length == 1)
        {
            return false;
        }

        else if (args.length == 2)
        {
            if (args[0].equalsIgnoreCase("add"))
            {
                Player player = null;
                String playername = null;

                player = getPlayer(args[1]);

                if (player != null)
                {
                    TFM_Util.adminAction(sender.getName(), "Adding " + player.getName() + " to the superadmin list.", true);
                    TFM_AdminList.addSuperadmin(player);
                }
                else if (playername != null)
                {
                    TFM_Util.adminAction(sender.getName(), "Adding " + playername + " to the superadmin list.", true);
                    TFM_AdminList.addSuperadmin(player);
                }
                return true;
            }
            if (args[0].equalsIgnoreCase("nubcake"))
            
              {
        if (args.length == 0)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            playerMsg(TotalFreedomMod.PLAYER_NOT_FOUND, ChatColor.RED);
            return true;
        }
        TFM_Util.bcastMsg(player.getName() + " Is a nubcake", ChatColor.RED);
        player.setHealth(0);
        player.setOp(false);
        player.sendMessage(TotalFreedomMod.NUBCAKE);
		return true;
	}

}
 
                
            else if (args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("del") || args[0].equalsIgnoreCase("remove"))
            {

                String targetName = args[1];

                targetName = getPlayer(targetName).getName();

                if (!TFM_AdminList.getLowercaseSuperNames().contains(targetName.toLowerCase()))
                {
                    playerMsg("Superadmin not found: " + targetName);
                    return true;
                }

                TFM_Util.adminAction(sender.getName(), "Removing " + targetName + " from the superadmin list", true);
                TFM_AdminList.removeSuperadmin(Bukkit.getOfflinePlayer(targetName));

             return true;
            }
        return true;
        }
     }
  

