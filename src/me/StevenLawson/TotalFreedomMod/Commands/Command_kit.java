package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH) // Defines permissions
@CommandParameters(
        description = "Kits", //Description
        aliases = "kits",
        usage = "/<command> ") //Usage
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
        sender.sendMessage(ChatColor.WHITE + "archer, survival, pvp, god, food, admin, tools, weapons, knight " );
        }
        if (mode.equals("archer"))
        {
                    PlayerInventory inv = sender_p.getInventory();
        ItemStack arrow = new ItemStack(Material.ARROW, 1);
        ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
        ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 10, (short) 1);
        ItemStack meat = new ItemStack(Material.COOKED_BEEF, 1);
        ItemStack bow = new ItemStack(Material.BOW, 1);
  
        for (Enchantment ench : Enchantment.values())
            {
                bow.addUnsafeEnchantment(ench, 10);
            }
                inv.addItem(bow);
               
        for (Enchantment ench : Enchantment.values())
            {
                chestplate.addUnsafeEnchantment(ench, 10);
            }
        for (Enchantment ench : Enchantment.values())
            {
                leggings.addUnsafeEnchantment(ench, 10);
            }
        for (Enchantment ench : Enchantment.values())
            {
                boots.addUnsafeEnchantment(ench, 10);
            }
        for (Enchantment ench : Enchantment.values())
            {
                helmet.addUnsafeEnchantment(ench, 10);
            }
                inv.setHelmet(helmet);
                inv.setBoots(boots);
                inv.setLeggings(leggings);
                inv.setChestplate(chestplate);
        }
            {
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
         }
        if (mode.equals("knight"))     
         {
        PlayerInventory inv = sender_p.getInventory();
        ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
        ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
        ItemStack axe = new ItemStack(Material.IRON_AXE, 1);
        ItemStack bow = new ItemStack(Material.BOW, 1);
        for (Enchantment ench : Enchantment.values())
            {
                sword.addUnsafeEnchantment(ench, 10);
            }
         for (Enchantment ench : Enchantment.values())
            {
                pickaxe.addUnsafeEnchantment(ench, 10);
            }
        for (Enchantment ench : Enchantment.values())
            {
                axe.addUnsafeEnchantment(ench, 10);
            }
        for (Enchantment ench : Enchantment.values())
            {
                bow.addUnsafeEnchantment(ench, 10);
            }
                inv.addItem(bow);
                inv.addItem(sword);
                inv.setHelmet(helmet);
                inv.setBoots(boots);
                inv.setLeggings(leggings);
                inv.setChestplate(chestplate);
                return true;
            }
        return true;
    }
}