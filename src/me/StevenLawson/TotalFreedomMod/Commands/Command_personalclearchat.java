package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.ALL, source=SourceType.BOTH)
@CommandParameters(description="Clears the Chat", usage="/<command>", aliases="pcc")
public class Command_personalclearchat
  extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    for (int i = 0; i <= 85; i++) {
    TFM_Util.playerMsg(sender, "");
    }
    TFM_Util.playerMsg(sender, "You have cleared the chat.", ChatColor.GREEN);
    return true;
  }
}
