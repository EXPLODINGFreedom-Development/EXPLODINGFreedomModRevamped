package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "You whore.", usage = "/<command>")
public class Command_whore extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {

            playerMsg(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }
        sender_p.chat("Hey " + player.getName() + ", guess what?");
        player.chat("What?");
        sender_p.chat("You whore.");
        sender_p.chat("C:");
        player.setHealth(0.0);
        player.chat("You whore.");
        sender_p.chat("C:");
        return true;
    }
}
