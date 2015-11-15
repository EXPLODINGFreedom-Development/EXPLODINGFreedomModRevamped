package me.StevenLawson.TotalFreedomMod.Commands;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_Util;
import me.StevenLawson.TotalFreedomMod.TFM_BuilderList;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.ALL, source=SourceType.BOTH)
@CommandParameters(description="Builder Chat - Chat With other Builders", usage="/<command> [message...]", aliases="bc")
public class Command_builderchat
  extends TFM_Command
{
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (args.length == 0) {
      return false;
    }
    if ((TFM_AdminList.isSeniorAdmin(sender)) || (TFM_BuilderList.isBuilder(sender)) || (TFM_BuilderList.isBuilderPlus(sender)))
    {
      EFMR_Util.builderChatMessage(sender, StringUtils.join(args, " "), senderIsConsole);
      return true;
    }
    TFM_Util.playerMsg(sender, "You do not have permission to access Builder Chat!", ChatColor.RED);
    return true;
  }
}
