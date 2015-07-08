package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.confuser.barapi.BarAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(
        description = "Alter what is currently on the boss bar.",
        usage = "/<command> [clear | message]")
public class Command_bar extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!TFM_Util.isHighRank(sender))
        {
            return true;
        }
        if (args.length < 1)
        {
            TFM_Util.playerMsg(sender, "Invalid number of arguments.", ChatColor.RED);
            return false;
        }
        if (args[0].equalsIgnoreCase("clear"))
        {
            for (Player player : server.getOnlinePlayers())
            {
                BarAPI.removeBar(player);
            }
            TFM_Util.adminChatMessage(sender, "[BAR-API] Bar Cleared.", false);
        }
        else
        {
            String message = StringUtils.join(ArrayUtils.subarray(args, 0, args.length), " ");
            BarAPI.setMessage(message.replaceAll("&", "§"), 60);
            TFM_Util.adminChatMessage(sender, "[BAR-API] Bar message changed.", false);
        }
        return true;
    }
}