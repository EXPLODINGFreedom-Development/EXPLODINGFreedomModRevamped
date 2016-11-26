package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.ALL, source=SourceType.BOTH)
@CommandParameters(description="display a nazi symbol in chat... may be spammy.", usage="/<command>")
public class Command_swastika
  extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    sender_p.chat("|              |-------------");
    sender_p.chat("|              |             ");
    sender_p.chat("|              |             ");
    sender_p.chat("|              |             ");
    sender_p.chat("|              |             ");
    sender_p.chat("|              |             ");
    sender_p.chat("---------------|------------|");
    sender_p.chat("               |            |");
    sender_p.chat("               |            |");
    sender_p.chat("               |            |");
    sender_p.chat("               |            |");
    sender_p.chat("               |            |");
    sender_p.chat("               |            |");
    sender_p.chat("---------------|            |");
    return true;
  }
}
