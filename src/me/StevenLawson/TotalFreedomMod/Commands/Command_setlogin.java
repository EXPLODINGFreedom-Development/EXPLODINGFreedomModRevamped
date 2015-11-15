package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EXPLODINGFreedomMod;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.SENIOR, source=SourceType.ONLY_IN_GAME)
@CommandParameters(description="Sets your login message", usage="/<command> [player] <loginmessage>")
public class Command_setlogin
  extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (args.length == 0) {
      return false;
    }
    Player player = getPlayer(args[0]);
    if (player == null)
    {
      playerMsg(TFM_Command.PLAYER_NOT_FOUND);
      return true;
    }
    boolean gument = args.length > 1;
    
    EXPLODINGFreedomMod.setLoginMessage(player, args[1]);
    TFM_AdminList.saveAll();
    sender.sendMessage(ChatColor.GREEN + "Successfully set " + player.getName() + "'s login message to the following:");
    sender.sendMessage(ChatColor.AQUA + player.getName() + " is " + ChatColor.translateAlternateColorCodes('&', args[1]));
    return true;
  }
}
