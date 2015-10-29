package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "AdminChat - Talk privately with other admins. Using <command> itself will toggle AdminChat on and off for all messages.", 
usage = "/<command> [message...]",
aliases = "oc")
public class Command_ownerchat extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!TFM_Util.OWNERS.contains(sender.getName()) && !TFM_Util.SYS_COOWNERS.contains(sender.getName()))
        sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
        if (args.length == 0)
        {
            if (senderIsConsole)
            {
                playerMsg("Only in-game players can toggle Owner Chat.");
                return true;
            }

            TFM_PlayerData userinfo = TFM_PlayerData.getPlayerData(sender_p);

            if (userinfo.inAdminChat())
            {
                userinfo.setAdminChat(!userinfo.inAdminChat());
            }
            
            if (userinfo.inSeniorAdminChat())
            {
                userinfo.setSeniorAdminChat(!userinfo.inSeniorAdminChat());
            }
            
            if (userinfo.inExecutiveChat())
            {
                userinfo.setExecutiveChat(!userinfo.inExecutiveChat());
            }
            
            if (userinfo.inSpecialExecutiveChat())
            {
                userinfo.setSpecialExecutiveChat(!userinfo.inSpecialExecutiveChat());
            }

            if (userinfo.inSystemAdminChat())
            {
                userinfo.setSystemAdminChat(!userinfo.inSystemAdminChat());
            }
            
            if (userinfo.inOwnerChat())
            {
                userinfo.setOwnerChat(!userinfo.inOwnerChat());
            }
            userinfo.setOwnerChat(!userinfo.inOwnerChat());
            playerMsg("Toggled Owner Chat " + (userinfo.inOwnerChat() ? "on" : "off") + ".");
        }
        else
        {
            TFM_Util.OwnerChatMessage(sender, StringUtils.join(args, " "), senderIsConsole);
        }

        return true;
    }
}