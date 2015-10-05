package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Get a head.", usage = "/<command> <player>")
public class Command_skull extends TFM_Command {

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        if (args.length != 1) {
            return false;
        } else {
            server.dispatchCommand(sender_p, "i head:3 64 owner:" + args[0]);
        }
        return true;
    }
}