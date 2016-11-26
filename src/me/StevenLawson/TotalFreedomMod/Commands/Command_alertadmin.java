package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Listener.TFM_AdminMessageListener;
import me.StevenLawson.TotalFreedomMod.Player.TFM_PlayerData;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Message online admins", usage = "/<command> <message>", aliases = "helpop")
public class Command_alertadmin extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            return false;
        }
        if (args.length == 1)
        {
            final TFM_PlayerData playerdata = TFM_PlayerData.getPlayerData(sender_p);
            TFM_AdminMessageListener.adminMessageListener(sender, StringUtils.join(args, " "), senderIsConsole);
        }
        return true;
    }
}