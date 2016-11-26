package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Player.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(
        description = "Senior AdminChat - Talk privately with other senior admins.",
        usage = "/<command> [message...]",
        aliases = "schat")
public class Command_p extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
            if (args.length == 0)
        {
            if (senderIsConsole)
            {
                playerMsg("Only in-game players can toggle SeniorAdminChat.");
                return true;
            }

            TFM_PlayerData userinfo = TFM_PlayerData.getPlayerData(sender_p);
            userinfo.setSeniorAdminChat(!userinfo.inSeniorAdminChat());
            playerMsg("Toggled Senior Admin Chat " + (userinfo.inSeniorAdminChat() ? "on" : "off") + ".");
        }
        else
        {
            TFM_Util.seniorChatMessage(sender, org.apache.commons.lang3.StringUtils.join(args, " "), senderIsConsole);
        }

        return true;
    }
}