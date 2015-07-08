package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_CommandBlocker;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Send a chat message as someone else.", usage = "/<command> <fromname> <message>", aliases="fchat")
public class Command_fc extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 2)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }

        final String outCommand = StringUtils.join(args, " ", 1, args.length);
        
        if (TFM_AdminList.isSuperAdmin(player) && !senderIsConsole)
        {
            if (!TFM_Util.isHighRank(sender_p))
            {
                TFM_Util.playerMsg(sender, ChatColor.RED + "You cannot force chat other admins, stop trying to cause trouble!");
                return true;
            }
        }

        try
        {
            playerMsg("Sending message as " + player.getName() + ": " + outCommand);
            player.chat(outCommand);
        }
        catch (Throwable ex)
        {
            playerMsg("Error sending message: " + ex.getMessage());
        }

        return true;
    }
}
