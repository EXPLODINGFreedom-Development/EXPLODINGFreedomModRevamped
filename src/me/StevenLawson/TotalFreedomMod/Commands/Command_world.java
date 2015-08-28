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
        description = "List of maps.",
        aliases = "maplist",
        usage = "/<command>")
public class Command_world extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.playerMsg(sender_p, "Avalible Maps:", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "§6- §aAdminWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aMiniGamesWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §cSeniorWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aFlatLands", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "To get to these do /adminworld for adminworld, /mgworld for minigames world, /flatlands for flatlands and /seniorworld for seniorworld.", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "Any world in §cRed§6 means the world is not avalible.", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "If you are a admin, and cant go to admin-only worlds, please contact a developer for help.", ChatColor.GOLD);
        
        return true;
       }
}