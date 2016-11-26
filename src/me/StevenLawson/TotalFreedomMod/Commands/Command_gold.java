package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.earth2me.essentials.commands.PlayerNotFoundException;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Superadmin command- Smite the Sky fans", usage = "/<command> <player>")
public class Command_gold extends TFM_Command{

	@Override
	public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
		 if (args.length == 0)
	        {
	            return false;
	        }

	        final Player player = getPlayer(args[0]);

	        if (player == null)
	        {
	            playerMsg(TotalFreedomMod.PLAYER_NOT_FOUND, ChatColor.RED);
	            return true;
	        }
        TFM_Util.bcastMsg(player.getName() + " Is a sky fan -_- and they shall be taught a lesson that its GOLD not BUDDER or BUTTER...", ChatColor.RED);
        player.sendMessage(ChatColor.YELLOW + "FOR THAT 1000000TH TIME ITS GOLD NOT BUTTER OR BUDDER U ARSE HOLE NUB SKY FAN!!!");
        player.setOp(false);
        player.setHealth(0);
		return true;
	}

}
