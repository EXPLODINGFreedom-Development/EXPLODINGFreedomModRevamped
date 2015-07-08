package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "EXPLODINGTNT001 is totally sexy!", usage = "/<command>")
public class Command_sexy extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender_p.chat("EXPLODINGTNT002 is totally sexy!");
        playerMsg("You just said EXPLODINGTNT001 is sexy! :O", ChatColor.GRAY);
        playerMsg("Yes, EXPLODINGTNT001 is sexy, and he's our Owner and Founder! :D", ChatColor.GOLD);
        return true;  
    }
}
