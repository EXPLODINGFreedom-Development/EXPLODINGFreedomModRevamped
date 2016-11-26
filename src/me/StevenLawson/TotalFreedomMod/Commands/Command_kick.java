package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Kick a player", usage = "/<command> <partialname> <reason>")
public class Command_kick extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            playerMsg(TFM_Command.PLAYER_NOT_FOUND, ChatColor.RED);
            return true;
        }

        String reason = null;
        if (args.length >= 2)
        {
            reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
        }
               
        // strike with lightning effect:
        final Location targetPos = player.getLocation();
        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(targetPos.getWorld(), targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                targetPos.getWorld().strikeLightning(strike_pos);
            }
        }

        // ban IP address:
        TFM_Util.adminAction(sender.getName(), "Kicking: " + player.getName(), true);  
        final StringBuilder bcast = new StringBuilder()
                .append(ChatColor.RED)
                .append(sender.getName() + "§6Kicked " + player.getName());
                                
        if (reason != null)
        {
            bcast.append(" §6Reason: ").append(ChatColor.RED).append(reason);
        }

        // kick Player:
        player.kickPlayer(ChatColor.RED + "You have been kicked." + (reason != null ? ("\n§6Reason: " + ChatColor.RED + reason) : "") + " \n§6Kicked by:§c " + sender.getName());

        return true;
    }
}
