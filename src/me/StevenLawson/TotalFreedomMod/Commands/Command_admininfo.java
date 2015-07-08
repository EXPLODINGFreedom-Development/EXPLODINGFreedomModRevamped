package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Commands.AdminLevel;
import me.StevenLawson.TotalFreedomMod.Commands.CommandParameters;
import me.StevenLawson.TotalFreedomMod.Commands.CommandPermissions;
import me.StevenLawson.TotalFreedomMod.Commands.SourceType;
import me.StevenLawson.TotalFreedomMod.Commands.TFM_Command;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(
        description = "See how to become admin.",
        aliases = "ai",
        usage = "/<command>")
public class Command_admininfo extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.playerMsg(sender_p, "So you wish to apply for admin do you?", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "Well, apply at http://explodingfreedom.boards.net/ and look for something that sais super admin apps and follow the template! !", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "Don't beg to look at the application, it'll shorten the percentage on if it can get accepted.", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "How to apply for admin", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "To apply for admin you need to go to the forums at http://explodingfreedom.boards.net", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "Then if you feel you are ready, make a new thread in the 'admin applications' board.", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "And fill out the template in the new thread.", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "Please dont nag admins for recs, this will weaken your chances for Super Admin.", ChatColor.RED);
        TFM_Util.playerMsg(sender_p,"Good Luck And Have A GREAT Day At EXPLODINGFreedom!", ChatColor.GOLD);
       
        return true;
       }
}