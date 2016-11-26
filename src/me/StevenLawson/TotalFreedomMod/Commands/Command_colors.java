package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.ALL, source=SourceType.BOTH)
@CommandParameters(description="List of color codes. Made by jayscoob.", aliases="", usage="/<command>")
public class Command_colors
  extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    TFM_Util.playerMsg(sender_p, "All Minecraft Color Codes", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§0Black = &0", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§1Dark Blue = &1", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§2Dark Green = &2", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§3Dark Aqua = &3", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§4Dark Red = &4", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§5Purple = &5", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§6Gold = &6", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§7Gray = &7", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§8Dark Gray = &8", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§9Blue = &9", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§aGreen = &a", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§bAqua = &b", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§cRed = &c", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§dLight Pink = &d", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§eYellow = &e", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§fWhite = &f", ChatColor.GOLD);
    TFM_Util.playerMsg(sender_p, "§lBold = §r&l", ChatColor.WHITE);
    TFM_Util.playerMsg(sender_p, "§nUnderline = �r&n", ChatColor.WHITE);
    TFM_Util.playerMsg(sender_p, "§oItalic = �r&o", ChatColor.WHITE);
    TFM_Util.playerMsg(sender_p, "§kObfuscated §r = §r&k", ChatColor.WHITE);
    
    return true;
  }
}
