package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Player.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(
        description = "Executive AdminChat - Chat for discussions among Executives",
        usage = "/<command> [message...]",
        aliases = "execchat,e")
public class Command_ec extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
            if (args.length == 0)
        {
            if (senderIsConsole)
            {
                playerMsg("Only in-game players can toggle ExecutiveChat.");
                return true;
            }

            TFM_PlayerData userinfo = TFM_PlayerData.getPlayerData(sender_p);
            userinfo.setExecutiveChat(!userinfo.inExecutiveChat());
            playerMsg("Toggled Executive Admin Chat " + (userinfo.inExecutiveChat() ? "on" : "off") + ".");
        }
        else
        {
            TFM_Util.executiveChatMessage(sender, org.apache.commons.lang3.StringUtils.join(args, " "), senderIsConsole);
        }

        return true;
    }
}