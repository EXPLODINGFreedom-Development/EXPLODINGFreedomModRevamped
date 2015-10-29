package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.ArrayList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH, blockHostConsole = false)
@CommandParameters(description = "Request OP!", usage = "/<command>")
public class Command_requestop extends TFM_Command 
    {	
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {        
      Bukkit.broadcastMessage(ChatColor.AQUA + sender.getName() + " Requests that someone OPs them.");
        return true;
    }
  } 