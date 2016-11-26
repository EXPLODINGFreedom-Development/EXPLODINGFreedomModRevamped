package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static sun.audio.AudioPlayer.player;

@CommandPermissions(level=AdminLevel.SENIOR, source=SourceType.BOTH)
@CommandParameters(description="Clears the Chat", usage="/<command>", aliases="clearchat")
public class Command_cc
  extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
      if (!(TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName())) && !TFM_Util.SYS_COOWNERS.contains(player.getName()) && !TFM_Util.LEADSYSS.contains(player.getName()) && !TFM_Util.SYS_ADMINS.contains(player.getName()))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
            TFM_Util.adminAction("WARNING: " + sender.getName(), "Has attempted to use a system admin only command. System administration team has been alerted.", true);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You are not a System Admin and may NOT use this command. If you feel this in error please contact a Developer.");
            }

            return true;
        }
    for (int i = 0; i <= 85; i++) {
      TFM_Util.bcastMsg("");
    }
    TFM_Util.bcastMsg(ChatColor.DARK_RED + "Chat has been Cleared By - " + sender.getName());
    return true;
  }
}
