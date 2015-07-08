package me.StevenLawson.TotalFreedomMod.Commands;

import static java.lang.Double.parseDouble;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Launch yourself!", usage = "/<command> [player] <strength>")
public class Command_launch extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player player;
        Double strength;
        if (args.length != 1)
        {
            if (args.length != 2)
            {
                return false;
            }
            if (!TFM_AdminList.isSuperAdmin(sender))
            {
                TFM_Util.playerMsg(sender, "You don't have permission to do this.", ChatColor.RED);
            }
            player = Bukkit.getPlayer(args[0]);
            strength = parseDouble(args[1]);
        }
        else
        {
            player = Bukkit.getPlayer(sender.getName());
            strength = parseDouble(args[0]);
        }
        if (strength > 10)
        {
            TFM_Util.playerMsg(sender, "Please use a strength value below 10!");
            return true;
        }
        player.setVelocity(new Vector(0, strength, 0));
        return true;
    }
}
