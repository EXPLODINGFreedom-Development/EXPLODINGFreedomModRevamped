package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_BuilderList;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "System Administration Management", usage = "/<command> [add | delete] <username>", aliases = "builder")
public class Command_builder extends TFM_Command
{
    private Object reason;

    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

        if (!TFM_Util.LEADSYSS.contains(sender.getName()) && TFM_Util.SPECIAL_EXECS.contains(sender.getName()) && !TFM_Util.SYS_ADMINS.contains(sender.getName()) && !TFM_Util.CHIEFEXECS.contains(sender.getName()) && !TFM_Util.OWNERS.contains(sender.getName()) && !TFM_Util.SYS_COOWNERS.contains(sender.getName()))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
            TFM_Util.adminAction("WARNING: " + sender.getName(), "Really wants to be a builder, but builds like shit.", true);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You are not a System Admin and may NOT use this command. If you feel this in error please contact a Developer.");
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
                    TFM_Util.adminAction(sender.getName(), "Adding " + player.getName() + " to the Builder list.", true);
                    TFM_BuilderList.addBuilder(player);
                }
                else if (playername != null)
                {
                    TFM_Util.adminAction(sender.getName(), "Adding " + playername + " to the Builder list.", true);
                    TFM_BuilderList.addBuilder(player);
                }
                return true;
            }

            else if (args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("del") || args[0].equalsIgnoreCase("remove"))
            {

                String targetName = args[1];

                targetName = getPlayer(targetName).getName();

                if (!TFM_BuilderList.getLowerBuilderNames().contains(targetName.toLowerCase()))
                {
                    playerMsg("Superadmin not found: " + targetName);
                    return true;
                }

                TFM_Util.adminAction(sender.getName(), "Removing " + targetName + " from the Builder list", true);
                TFM_BuilderList.removeBuilder(Bukkit.getOfflinePlayer(targetName));

                return true;
            }
            return true;
        }
        return true;
    }
}
