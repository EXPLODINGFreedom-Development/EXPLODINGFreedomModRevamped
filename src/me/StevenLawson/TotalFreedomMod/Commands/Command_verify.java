package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_Util;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.ALL, source=SourceType.BOTH)
@CommandParameters(description="In-Game Verify Command", usage="/<command> [PIN] [SetPIN]")
public class Command_verify
  extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (args.length == 0) {
      return false;
    }
    if (args.length == 1)
    {
      String verify = EFMR_Util.getVerifyPassword(sender);
      if (args[0].equals(verify)) {
        return true;
      }
      if (args[0].equals(verify)) {
        return false;
      }
      if (!TFM_AdminList.isAdminImpostor(sender_p))
      {
        playerMsg(TFM_Command.NOT_IMPOSTOR);
        return true;
      }
      sender_p.sendMessage(ChatColor.RED + sender_p.getName() + " - has verified via our In-Game based Verification System.");
      TFM_AdminList.addSuperadmin(sender_p);
      TFM_Util.bcastMsg(sender_p.getName() + " Has verified using their password", ChatColor.RED);
      TFM_Util.bcastMsg("CONSOLE - Adding " + sender_p.getName() + " to the superadmin list.", ChatColor.RED);
      return true;
    }
    if ((args.length == 2) && 
      (args[0].equalsIgnoreCase("SetPIN")))
    {
      EFMR_Util.setVerifyPassword(sender, args[1]);
      TFM_AdminList.saveAll();
      sender.sendMessage(ChatColor.GREEN + "You have set your PIN, which you will need when verifing, So please remember it.");
    }
    return true;
  }
}
