package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Player.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.TELNET, source = SourceType.BOTH)
@CommandParameters(
        description = "TelnetChat - Talk privately with other telnet admins. Using <command> itself will toggle TelnetChat on and off for all messages.",
        usage = "/<command> [message...]",
        aliases = "tc")
public class Command_telnetchat extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            if (senderIsConsole)
            {
                playerMsg("Only in-game players can toggle TelnetChat.");
                return true;
            }

            TFM_PlayerData userinfo = TFM_PlayerData.getPlayerData(sender_p);
            userinfo.setTelnetAdminChat(!userinfo.inTelnetAdminChat());
            playerMsg("Toggled Telnet Chat " + (userinfo.inTelnetAdminChat() ? "on" : "off") + ".");
        }
        else
        {
            TFM_Util.telnetChatMessage(sender, StringUtils.join(args, " "), senderIsConsole);
        }

        return true;
    }
}
