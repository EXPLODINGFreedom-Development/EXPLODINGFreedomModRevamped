package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

    @CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Enable invisibility!", usage = "/<command> <on|off>", aliases = "vanish")
public class Command_v extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
         {
                   } 
        if (args.length == 0)
        {
            return false;
        }
String mode = args[0].toLowerCase();

        if (mode.equals("on")) 
        {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
        if (p != p)
        p.hidePlayer(p);
        playerMsg("You are now invisible from other players.", ChatColor.GOLD); 
       }
        
        
        if (mode.equals("off"))
        {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
        if (p != p)
        p.showPlayer(p);
        playerMsg("You are no longer invisible from other players.", ChatColor.GOLD); 
        }
       return true;
        }
        }
    return true;
        }
    }