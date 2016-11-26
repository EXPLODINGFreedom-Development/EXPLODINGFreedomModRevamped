package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Change your tabname", usage = "/<command> <message>")
public class Command_tabname extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
         if (args.length == 0)
        {
            return false;
        }
        if (args.length > 0)
        {
            String name = StringUtils.join(ArrayUtils.subarray(args, 0, args.length), " ");
            sender_p.setPlayerListName(name.replaceAll("&", "§"));
        }
        return true;
  }
}