package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.ALL, source=SourceType.BOTH)
@CommandParameters(description="say the owners are sexy", usage="/<command>")
public class Command_sexy
  extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    sender_p.chat("Alco_Rs11 and jayscoob are totally sexy!");
    playerMsg("You just said that the owners are sexy! :O", ChatColor.GRAY);
    playerMsg("Yes, both Alco_Rs11 and jayscoob are sexy, and they are our Owners and Founders! :D", ChatColor.GOLD);
    return true;
  }
}
