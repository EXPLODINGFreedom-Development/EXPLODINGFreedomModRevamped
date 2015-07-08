package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_CONSOLE)
@CommandParameters(description = "Run's the system cleanup", usage = "/<command>")
public class Command_cleanup extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.bcastMsg(ChatColor.RED + "Starting nightly cleanup - expect lag!");
        if (senderIsConsole)
        {
            server.dispatchCommand(sender, "tfipbanlist purge");
            server.dispatchCommand(sender, "tfbanlist purge");
            server.dispatchCommand(sender, "ops purge");
            server.dispatchCommand(sender, "setl");
            server.dispatchCommand(sender, "ro 119");
            server.dispatchCommand(sender, "ro 52");
            server.dispatchCommand(sender, "rd");
            server.dispatchCommand(sender, "opall -c");
            server.dispatchCommand(sender, "saconfig clean");
            server.dispatchCommand(sender, "purgeall");
            server.dispatchCommand(sender, "wipeuserdata");
            server.dispatchCommand(sender, "cc");
            TFM_Util.bcastMsg(ChatColor.GREEN + "Nighly clean up Completed. Reloading the server.");
            server.dispatchCommand(sender, "efm reload");
        }
        else
        {
            TFM_Util.bcastMsg(ChatColor.RED + "Nightly Cleanup failed, please report this error at http://explodingfreedom.boards.net");
        }

        return true;
    }
}
