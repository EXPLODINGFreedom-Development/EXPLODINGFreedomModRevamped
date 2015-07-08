package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Warn people but with a little more power", usage = "/<command> <playername>")
public class Command_superwarn extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        playerMsg("Can you stop being such a douche!!??", ChatColor.RED);
        playerMsg("STOP BEING A ROGUE OP!", ChatColor.GREEN);
        playerMsg("Next time you be such a dick, you're going to be permbanned!", ChatColor.DARK_RED);
        playerMsg("You were warned by" + sender.getName() + ", okay? Now stop!", ChatColor.AQUA);
        return true;  
    }
}