 package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Administrator Rules.", usage = "/<command>")
public class Command_adminrules extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {        
        sender.sendMessage(ChatColor.RED + "§4§lEXPLODINGFreedom §1§lAdmin §e§lRules: ");
        sender.sendMessage(ChatColor.RED + "§4§l[1]§7 Respect players and admins");
        sender.sendMessage(ChatColor.RED + "§4§l[2]§7 Don't smite admin just for the lulz or because you feel like it.");
        sender.sendMessage(ChatColor.RED + "§4§l[3]§7 Admins can TP to any player they wish.");
        sender.sendMessage(ChatColor.RED + "§4§l[4]§7 Dont brag about your rank or your perks. It makes the lower admins feel bad.");
        sender.sendMessage(ChatColor.RED + "§4§l[5]§7 Be nice to fellow admins and players!");
        sender.sendMessage(ChatColor.RED + "§4§l[6]§7 Don't say negative or mean things to other admins or players.");
        sender.sendMessage(ChatColor.RED + "§4§l[7]§7 Don't try to act like the leader to higher ranked staff.");
        sender.sendMessage(ChatColor.RED + "§4§l[8]§4 Don't grief or troll. It just feeds the trolls more encouragement.");
        sender.sendMessage(ChatColor.DARK_RED + "§4§l[9]§4 Don't try and attempt to threat or DDoS any other admins or players. The law can get involved. ");
        sender.sendMessage(ChatColor.RED + "§4§l[10]§7 A senior admin cannot boss anyone higher than them.");
        sender.sendMessage(ChatColor.DARK_RED + "§4§l[11]§7 The Owner does not have to follow the rules. He owns the server.");
        sender.sendMessage(ChatColor.DARK_RED + "§4§l[12]§c If someone makes a build dont try and copy it and call it your own.");
        sender.sendMessage(ChatColor.DARK_RED + "§c§lNot following these rules can result in suspension or a hardcore punishment.");
        return true;  
       }

          {
        }
    }
