package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import me.confuser.barapi.BarAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH) // Defines permissions
@CommandParameters(
        description = "Chat Levels", //Description
        aliases = "cl",
        usage = "/<command> [op|survival|tools|weapons|pvp|god|list]") //Usage
public class Command_kit extends TFM_Command
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

        if (mode.equals("list")) 
        {
        sender.sendMessage(ChatColor.GOLD + "Avalible Kits:" );
        sender.sendMessage(ChatColor.WHITE + "survival, pvp, god, food, admin, tools, weapons " );
        }
        
        if (mode.equals("survival"))
        {
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:iron_sword 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:iron_shovel 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:iron_hoe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:iron_axe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:iron_pickaxe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:iron_helmet 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:iron_leggings 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:iron_boots 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:iron_chestplate 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:cooked_beef 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:cooked_beef 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:arrow 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:arrow 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:bow 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " 17 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " 17 64");
        }
        
        if (mode.equals("pvp"))
        {
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_sword 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_shovel 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_hoe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_axe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_pickaxe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_helmet 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_leggings 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_boots 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_chestplate 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:cooked_beef 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:cooked_beef 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:arrow 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:arrow 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:bow 1");
        }
        
        if (mode.equals("god"))
        {	
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_sword 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_shovel 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_hoe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_axe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_pickaxe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_helmet 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_leggings 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_boots 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_chestplate 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:cooked_beef 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:cooked_beef 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:arrow 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:arrow 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:bow 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " 57 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " 57 64");
        }
          if (mode.equals("food"))
        {
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:cooked_beef 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:cooked_beef 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:milk_bucket 2");
        }
          if (mode.equals("admin"))
        {
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:stick 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " 1 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:potion:8270 5");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:milk_bucket 2");
        }
          if (mode.equals("tools"))     
         {  
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:clock 1");     
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:compass 1");     
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:fishing_rod 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_shovel 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_hoe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_axe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_pickaxe 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:shears 1");
         }
           if (mode.equals("weapons"))     
         {      
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_sword 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_helmet 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_leggings 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_boots 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:diamond_chestplate 1");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:arrow 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:arrow 64");
        Bukkit.dispatchCommand(sender, "give " + sender.getName() + " minecraft:bow 1");
        
         return true;
        }
    return true;
        }
}