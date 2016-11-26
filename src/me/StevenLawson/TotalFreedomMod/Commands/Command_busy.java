package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.ArrayList;

import me.StevenLawson.TotalFreedomMod.TFM_Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Notifys players you are busy", usage = "/<command>")
public class Command_busy extends TFM_Command {
	public static final ArrayList<String> busy = new ArrayList<String>();
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        if (!busy.contains(sender.getName())){
        	busy.add(sender.getName());
        	TFM_Util.adminAction(sender.getName(), "I'm now busy", true);
        }else {
        	busy.remove(sender.getName());
        	TFM_Util.adminAction(sender.getName(), "I'm not busy now", false);
        }
    	return true;
    }
}
