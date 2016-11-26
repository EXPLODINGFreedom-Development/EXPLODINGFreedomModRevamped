package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.Config.TFM_MainConfig;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.Banning.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_CommandBlocker;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.Banning.TFM_PermbanList;
import me.StevenLawson.TotalFreedomMod.Player.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.spigotmc.SpigotConfig.config;

/* Copying this command's code is strongly discouraged and not allowed.  
 * This command was NOT made by anyone BUT me.
 * So if I see ANY custom /tfm commands for your mod that use this command's playerMsg text, you copied my code.
/
 
/*
 * See https://github.com/TotalFreedom/License - This file may not be edited or removed.
 */
@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Shows information about EXPLODINGFreedomMod or reloads it", usage = "/<command> [reload]")
public class Command_efm extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 1)
        {
            if (!args[0].equals("reload"))
            {
                return false;
            }

            if (!TFM_AdminList.isSuperAdmin(sender))
            {
                playerMsg(TFM_Command.MSG_NO_PERMS);
                return true;
            }

            TFM_MainConfig.load();
            TFM_AdminList.load();
            TFM_PermbanList.load();
            TFM_PlayerList.load();
            TFM_BanManager.load();
            TFM_CommandBlocker.load();

            final String message = String.format("%s v%s.%s reloaded.",
                    TotalFreedomMod.pluginName,
                    TotalFreedomMod.pluginVersion,
                    TotalFreedomMod.buildNumber);

            playerMsg(message);
            TFM_Log.info(message);
            return true;
        }

       TFM_Util.playerMsg(sender_p, "§c§lEXPLODINGFreedomModRevamped:", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "EFM:R - The Feature-Packed New Form of All-OP Server Management By§a Alco_Rs11 §7and §ajayscoob", ChatColor.GRAY);
        TFM_Util.playerMsg(sender_p, "§5Made in the image of the §9TotalFreedomMod §5but with more §6features §5and §eflexibility.", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "§9This plugin is version §a8.0 §7'§aSempron§7'", ChatColor.GOLD);
        
        

        return true;
    }
}
