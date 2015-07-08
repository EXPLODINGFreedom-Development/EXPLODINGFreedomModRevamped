package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Paralyz a person from joining or five minutes!", usage = "/<command> <partialname>", aliases = "fkick")
public class Command_superfireykick extends TFM_Command
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
            playerMsg(TotalFreedomMod.PLAYER_NOT_FOUND, ChatColor.RED);
            return true;
        }


        // strike with lightning effect:
        final Location targetPos = player.getLocation();
        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(targetPos.getWorld(), targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                targetPos.getWorld().strikeLightning(strike_pos);
            }
        }

        TFM_Util.bcastMsg(sender.getName() + " is kicking " + player.getName() + " with a FIERY boot up dere arse!", ChatColor.RED);
                TFM_BanManager.addUuidBan(
                new TFM_Ban(TFM_Util.getUuid(player), player.getName(), sender.getName(), TFM_Util.parseDateOffset("5m"), ChatColor.RED + "You're temporarily paralyzed for 5 minutes while we heal up that kick mark.."));
        player.kickPlayer(ChatColor.RED + sender.getName() + "'s boot hit ya' in the face..");
       

        return true;
    }
}
