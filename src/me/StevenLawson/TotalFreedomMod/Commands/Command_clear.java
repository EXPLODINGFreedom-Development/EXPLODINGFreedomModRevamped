package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Place a cage around someone.", usage = "/<command> <playername>", aliases = "ci, eci, eclean")
public class Command_clear extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if(!(sender instanceof Player))
        {
            if(args.length != 1)
            {  
                return false;
            }
        }
        if(args.length > 0)
        {
            Player player = Bukkit.getPlayer(args[0]);
            if(player == null)
            {
                sender.sendMessage("The player selected is not online.");
                return true;
            }
            player.getInventory().clear();
            sender.sendMessage(ChatColor.GOLD + "Inventory cleared.");
            player.sendMessage(ChatColor.GOLD + sender.getName() + " cleared your inventory.");
            return true;
        }
        ((Player) sender).getInventory().clear();
        sender.sendMessage(ChatColor.GOLD + "Inventory cleared.");
        return true;
    }
    
}