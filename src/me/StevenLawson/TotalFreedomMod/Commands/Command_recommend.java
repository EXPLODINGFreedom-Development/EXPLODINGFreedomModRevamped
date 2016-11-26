package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.ONLY_IN_GAME, blockHostConsole = true)
@CommandParameters(description = "Recommend an Admin Applicant", usage = "/<command> <player>")
public class Command_recommend extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 2)
        {
            return false;
        }

        Player player = getPlayer(args[0]);

        if (player == null)
        {
            playerMsg(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }

        if (sender instanceof Player)
        {
            if (player == (Player) sender)
            {
                playerMsg(ChatColor.RED + "Please, don't try to recommend yourself -_-");
                return true;
            }
        }

        if (TFM_AdminList.isSuperAdmin(player))
        {
            playerMsg(ChatColor.RED + "You can't recommend an admin " + player.getName() + ", idiot -_-");
            return true;
        }

        String reported = player.getName();
        String reporter = sender.getName();
        String report = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");

        sender.sendMessage(ChatColor.GREEN + "You just recommended an Admin Applicant!");

        for (Player p : Bukkit.getOnlinePlayers())
        {
            if (TFM_AdminList.isSuperAdmin(p))
            {
                p.sendMessage("§8[§4Recommendations§8] "  + ChatColor.DARK_PURPLE+ player.getName() + " has recommended " + ChatColor.YELLOW + player.getName() + " on his Application! ");
            }
        }

        return true;
    }
}