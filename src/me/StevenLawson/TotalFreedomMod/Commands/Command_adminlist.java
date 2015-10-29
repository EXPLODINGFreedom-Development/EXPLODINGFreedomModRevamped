package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Commands.AdminLevel;
import me.StevenLawson.TotalFreedomMod.Commands.CommandParameters;
import me.StevenLawson.TotalFreedomMod.Commands.CommandPermissions;
import me.StevenLawson.TotalFreedomMod.Commands.SourceType;
import me.StevenLawson.TotalFreedomMod.Commands.TFM_Command;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(
        description = "Admin List.",
        aliases = "alist",
        usage = "/<command>")
public class Command_adminlist extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.RED + "§e---- §6Admins §e----");
        sender.sendMessage(ChatColor.GRAY + "§b- Former Admins:");
        sender.sendMessage(ChatColor.RED + "§6Jayscoob§f,§6 evanator324");
        sender.sendMessage(ChatColor.AQUA + "§b- Super Admins:");
        sender.sendMessage(ChatColor.GOLD + StringUtils.join(TFM_AdminList.getSuperAdminNames(), "§f,§6 ")); 
        sender.sendMessage(ChatColor.DARK_GREEN + "§2- Telnet Admins:");
        sender.sendMessage(ChatColor.GOLD + StringUtils.join(TFM_AdminList.getTelnetAdminNames(), "§f,§6 "));
        sender.sendMessage(ChatColor.GREEN + "§a- Telnet MultiCraft Admins:");
        sender.sendMessage(ChatColor.RED + "§6hiram2238§f,§6 Malembo");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "§d- Senior Admins:");
        sender.sendMessage(ChatColor.GOLD + StringUtils.join(TFM_AdminList.getSuperAdminNames(), "§f,§6 "));
        sender.sendMessage(ChatColor.BLUE + "§9- Executives:");
        sender.sendMessage(ChatColor.RED + "§6");
        sender.sendMessage(ChatColor.DARK_PURPLE + "§5- Developers:");
        sender.sendMessage(ChatColor.GOLD + "§6Alco_Rs11§f,§6 Jayscoob§f, §6OxLemonxO");
        sender.sendMessage(ChatColor.BLUE + "§9- Special-Executives:");
        sender.sendMessage(ChatColor.RED + "§6LucazDaKing§f,§6 Silver_D§f,§6 TaahThePenguin");
        sender.sendMessage(ChatColor.DARK_RED + "§4- System-Admins:");
        sender.sendMessage(ChatColor.RED + "§6Agent_Waddles§f,§6 DarkGamingDronez§f,§6 xfilez");
        sender.sendMessage(ChatColor.DARK_BLUE + "§1- Co-Owners:");
        sender.sendMessage(ChatColor.RED + "§6DarkHorse108§f,§6 Jayscoob");
        sender.sendMessage(ChatColor.DARK_RED + "§4- Owners:");
        sender.sendMessage(ChatColor.RED + "§6Alco_Rs11");
       
        return true;
       }
}