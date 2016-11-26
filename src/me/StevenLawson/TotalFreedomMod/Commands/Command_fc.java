package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_CommandBlocker;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static sun.audio.AudioPlayer.player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Send a chat message as someone else.", usage = "/<command> <fromname> <message>", aliases="fchat, forcechat")
public class Command_fc extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!(TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName())) && !TFM_Util.SYS_COOWNERS.contains(player.getName()) && !TFM_Util.SPECIAL_EXECS.contains(player.getName()) && !TFM_Util.EXECS.contains(player.getName()) && !TFM_Util.LEADSYSS.contains(player.getName()) && !TFM_Util.SYS_ADMINS.contains(player.getName()))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
            

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You are not an Executive and may NOT use this command. If you feel this in error please contact a Developer.");
            }

            return true;
        }
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
