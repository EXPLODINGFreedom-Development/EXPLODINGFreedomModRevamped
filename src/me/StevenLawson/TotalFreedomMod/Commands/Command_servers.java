package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_ServiceChecker;
import me.StevenLawson.TotalFreedomMod.TFM_ServiceChecker.ServiceStatus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Shows the status of all related servers", usage = "/<command>")
public class Command_servers extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        playerMsg("Related Server Statuses" + ChatColor.WHITE + ":", ChatColor.BLUE);

        for (ServiceStatus service : TFM_ServiceChecker.getAllStatuses())
        {
            playerMsg(service.getFormattedStatus());
        }
        playerMsg("Version" + ChatColor.WHITE + ": " + TFM_ServiceChecker.getVersion(), ChatColor.DARK_PURPLE);
        playerMsg("Last Check" + ChatColor.WHITE + ": " + TFM_ServiceChecker.getLastCheck(), ChatColor.DARK_PURPLE);

        return true;
    }
}
