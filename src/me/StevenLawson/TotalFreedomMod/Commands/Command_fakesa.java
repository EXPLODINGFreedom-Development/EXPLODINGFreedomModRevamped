package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Manage superadmins in a fake way", usage = "/<command> [add:del] <player>")
public class Command_fakesa extends TFM_Command
{
    
	@Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
	if (args.length < 0)
        {
            return false;
        }

        if (args.length == 1)
        {
            final Player player = getPlayer(args[0]);

            if (player == null)
            {
                playerMsg(TotalFreedomMod.PLAYER_NOT_FOUND, ChatColor.RED);
                
            if (args[0].equals("add"))
            {
            	TFM_Util.bcastMsg(sender.getName() + " - Adding " + player.getName() + " to the superadmin list.", ChatColor.RED);
            	return true;
            }
           else if (args[0].equals("delete"))
            {
            	TFM_Util.bcastMsg(sender.getName() + " - Removing " + player.getName() + " from the superadmin list.", ChatColor.RED);
            	return true;
            }
		return true;

}
        {
		return true;
	}
}
		return true;
}
}
