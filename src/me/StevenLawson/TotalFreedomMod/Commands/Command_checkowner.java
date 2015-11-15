package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Check whether or not Alco_Rs11(The Owner) is online!", usage = "/<command>", aliases = "check")
public class Command_checkowner extends TFM_Command
{

@Override
public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
{

Player Alco_Rs11 = Bukkit.getServer().getPlayer("Alco_Rs11");

if (Alco_Rs11 != null && !TFM_AdminList.isAdminImpostor(Alco_Rs11))
{
playerMsg(ChatColor.GRAY + "The owner is " + ChatColor.GREEN + "online" + ChatColor.GRAY + "!");
return true;

}
else if (Alco_Rs11 == null || TFM_AdminList.isAdminImpostor(Alco_Rs11))
{
playerMsg(ChatColor.GRAY + "The owner is " + ChatColor.RED + "offline" + ChatColor.GRAY + "!");
return true;
}

else
{

}

return false;
}
}