package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "To fuck with the stupid ones.", usage = "/<command> [-f]", aliases = "boom")
public class Command_pex extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.bcastMsg(sender.getName() +  String.format(" should know he will never get admin.", args.length == 1 ? " fiery" : ""), ChatColor.RED);
        sender_p.setGameMode(GameMode.SURVIVAL);
        sender_p.getWorld().createExplosion(sender_p.getLocation().getBlockX(), sender_p.getLocation().getBlockY(), sender_p.getLocation().getBlockZ(), 0, false, false);
        if(args.length == 1 && TFM_Util.isHighRank(sender_p))
        {
            Bukkit.dispatchCommand(sender_p, "fireball");
        }
        sender_p.setHealth(0);
        return true;
    }
}
