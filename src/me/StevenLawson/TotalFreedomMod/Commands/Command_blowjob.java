package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_GameRuleHandler;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import me.confuser.barapi.BarAPI;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(
        description = "Give someone a blowjob.",
        usage = "/<command>")
public class Command_blowjob extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (sender.getName().equalsIgnoreCase("Hoe"))
        
        {
           sender.sendMessage(TFM_Command.MSG_NO_PERMS);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You cannot give others blowjobs u fuck.");
            }

            return true;
        }
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }

        TFM_Util.adminAction(sender.getName(), "Giving " + player.getName() + " a blowjob.", true);
        server.dispatchCommand(sender, "tp " + player.getName() + " " + sender.getName());
        TFM_PlayerData playerdata = TFM_PlayerData.getPlayerData(player);
        playerdata.setFrozen(!playerdata.isFrozen());
        player.chat("Ohhhh yeahhhhh.");
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
        TFM_Util.bcastMsg(player.getName() + " got fucked too hard, and fell asleep whilst the fuck happened.", ChatColor.RED);
        player.setHealth(0.0);
        TFM_PlayerData playerdata = TFM_PlayerData.getPlayerData(player);
        playerdata.setFrozen(!playerdata.isFrozen());
            }
        }.runTaskLater(plugin, 4L * 40L);
       return true;
    }
}