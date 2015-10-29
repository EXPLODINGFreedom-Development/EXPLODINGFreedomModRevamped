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
        aliases = "cl",
        usage = "/<command> [1|2|3|4|5|6|7|list] <message>") //Usage
public class Command_chatlevel extends TFM_Command
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

        if (mode.equals("1")) 
        {
        server.dispatchCommand(sender, "adminchat");	
        }
        
        if (mode.equals("2"))
        {
        server.dispatchCommand(sender, "telnetchat");	
        }
        
        if (mode.equals("3"))
        {
        server.dispatchCommand(sender, "p");	
        }
        
        if (mode.equals("4"))
        {
        server.dispatchCommand(sender, "execchat");	
        }
          if (mode.equals("5"))
        {
        server.dispatchCommand(sender, "specexecchat");	
        }
          if (mode.equals("6"))
        {
         server.dispatchCommand(sender, "syschat");
        }
          if (mode.equals("7"))     
         {      
         server.dispatchCommand(sender, "ownerchat");
         }
            if (mode.equals("list"))
        {
         playerMsg("§e----§aAdmin Chat Levels§e----");
         playerMsg("§bChatLevel 1: Regular Admin Chat");
         playerMsg("§2chatLevel 2: Telnet Admin Chat");
         playerMsg("§dChatLevel 3: Senior Admin Chat");
         playerMsg("§9ChatLevel 4: Executive Chat");
         playerMsg("§aChatLevel 5: Special-Executive Chat");
         playerMsg("§4ChatLevel 6: System-Admin Chat");
         playerMsg("§3ChatLevel 7: Owner/Co-Owner Chat");
         return true;
        }
    return true;
        }
}