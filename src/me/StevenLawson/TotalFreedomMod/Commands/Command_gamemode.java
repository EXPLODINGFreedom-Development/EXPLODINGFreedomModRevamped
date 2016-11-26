package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH) // Defines permissions
@CommandParameters(
        description = "Change your Gamemode", //Description
        aliases = "gm",
        usage = "/<command> [0|1|2|3]") //Usage
public class Command_gamemode extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole){
   {
                   } 
        if (args.length == 0)
        {
            return false;
        }
        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }
        String mode = args[0].toLowerCase();

        if (mode.equals("0")) 
        {
        server.dispatchCommand(sender, "gms");
        }
        
        if (mode.equals("s")) 
        {
        server.dispatchCommand(sender, "gms");
        }
        
        if (mode.equals("1"))
        {
       server.dispatchCommand(sender, "gmc");
        }
        
        if (mode.equals("c"))
        {
        server.dispatchCommand(sender, "gmc");
               }
        
        if (mode.equals("2"))
        {
        server.dispatchCommand(sender, "gma");
        }
        
        if (mode.equals("a"))
        {
        server.dispatchCommand(sender, "gma");
        }
        
        if (mode.equals("3"))
        {
        server.dispatchCommand(sender, "gmsp");
        }
        {
         return true;
        }
    
        }
}