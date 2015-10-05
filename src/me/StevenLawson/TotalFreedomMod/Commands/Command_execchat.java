package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "AdminChat - Talk privately with other admins. Using <command> itself will toggle AdminChat on and off for all messages.", usage = "/<command> [message...]", aliases = "e")
public class Command_execchat extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!TFM_Util.DEVELOPERS.contains(sender.getName()) && TFM_Util.EXECS.contains(sender.getName()) && TFM_Util.SPECIAL_EXECS.contains(sender.getName()) && TFM_Util.LEAD_DEVELOPERS.contains(sender.getName()) && TFM_Util.LEADSYSS.contains(sender.getName()) && !TFM_Util.SYS_ADMINS.contains(sender.getName()) && !TFM_Util.OWNERS.contains(sender.getName()) && !TFM_Util.SYS_COOWNERS.contains(sender.getName()))
        sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
        if (args.length == 0)
        {
            if (senderIsConsole)
            {
                playerMsg("Only in-game players can toggle Senior Admin Chat.");
                return true;
            }

            TFM_PlayerData userinfo = TFM_PlayerData.getPlayerData(sender_p);

             if (userinfo.inAdminChat())
            {
                userinfo.setAdminChat(!userinfo.inAdminChat());
            }
            
            if (userinfo.inExecutiveChat())
            {
                userinfo.setExecutiveChat(!userinfo.inExecutiveChat());
            }

            userinfo.setExecutiveChat(!userinfo.inExecutiveChat());
            playerMsg("Toggled Executive Chat " + (userinfo.inExecutiveChat() ? "on" : "off") + ".");
        }
        else
        {
            TFM_Util.ExecutiveChatMessage(sender, StringUtils.join(args, " "), senderIsConsole);
        }

        return true;
    }
}