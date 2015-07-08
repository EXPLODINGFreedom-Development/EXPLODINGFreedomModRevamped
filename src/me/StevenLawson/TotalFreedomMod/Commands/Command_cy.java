package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Clear your chat", usage = "/<command>", aliases = "cm")
public class Command_cy extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (senderIsConsole)
        {
            playerMsg("You must be in-game to use this command.");
        }

        Player player = sender_p;
        for(int i = 0; i <= 20; i++)
        {
            playerMsg("");
        }
        playerMsg("Chat cleared!", ChatColor.RED);
        
        return true;
    }
}