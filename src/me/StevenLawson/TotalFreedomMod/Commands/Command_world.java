package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import me.confuser.barapi.BarAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
This is the ExplodingManage command. if you obtain the source code DO NOT remove this class or modify it.
Its here for the bad people that decide to rename the plugin and pass it as there own. Similar to the TFM_FrontDoor
This requires BarAPI for the project to compile
If you're wondering what this class exactly does I've noted it with the '//'s
The your wondering what (mode.equals("")) does it defines what you have to say for the command to go through.
*/

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH) // Defines permissions
@CommandParameters(
        description = "Chat Levels", //Description
        aliases = "maps",
        usage = "/<command> [world|nether|end|flatlands|adminworld|minigamesworld|seniorworld|builderworld|list]") //Usage
public class Command_world extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole){
   {
                   } 
        if (args.length == 0)
        {
            return false;
        }

        String mode = args[0].toLowerCase();

        if (mode.equals("world")) 
        {
        server.dispatchCommand(sender, "warp mainworld");	
        }
        
        if (mode.equals("nether"))
        {
        server.dispatchCommand(sender, "nether");	
        }
        
        if (mode.equals("end"))
        {
        server.dispatchCommand(sender, "ender");	
        }
        
        if (mode.equals("flatlands"))
        {
        server.dispatchCommand(sender, "flatlands");	
        }
          if (mode.equals("adminworld"))
        {
        server.dispatchCommand(sender, "minigameworld");	
        }
          if (mode.equals("mgworld"))
        {
         server.dispatchCommand(sender, "mgworld");
        }
          if (mode.equals("seniorworld"))     
         {      
         server.dispatchCommand(sender, "seniorworld");
         }
            if (mode.equals("list"))
        {
        TFM_Util.playerMsg(sender_p, "Avalible Maps:", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "§6- §aMainWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aNether", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aEnd", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aAdminWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aMiniGamesWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aSeniorWorld", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§6- §aFlatLands", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "To get to these do /adminworld for adminworld, /mgworld for minigames world, /flatlands for flatlands and /seniorworld for seniorworld.", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "Any world in §cRed§6 means the world is not avalible.", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "If you are a admin, and cant go to admin-only worlds, please contact a developer for help.", ChatColor.GOLD);
        
         return true;
        }
    return true;
        }
}