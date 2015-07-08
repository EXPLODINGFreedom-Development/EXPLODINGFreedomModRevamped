package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(
        description = "Purge the ban lists and IP ban lists",
        usage = "/<command>")
public class Command_purgeban extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

    	   sender_p.performCommand("tfbanlist purge");
           sender_p.performCommand("tfipbanlist purge");
        return false;
    }
}