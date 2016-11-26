package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Gives admins the admin goodies.", usage = "/<command>")
public class Command_admintools extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        PlayerInventory inv = sender_p.getInventory();
        ItemStack LongShaft = new ItemStack(Material.STICK, 1);
        for (Enchantment ench : Enchantment.values())
        {
            if (ench.equals(Enchantment.LOOT_BONUS_MOBS) || ench.equals(Enchantment.LOOT_BONUS_BLOCKS))
            {
                continue;
            }
            LongShaft.addUnsafeEnchantment(ench, 32767);
        }
        ItemMeta shaftmeta = LongShaft.getItemMeta();
        shaftmeta.setDisplayName(ChatColor.YELLOW + "Logstick");
        LongShaft.setItemMeta(shaftmeta);
        inv.addItem(LongShaft);
        ItemStack logblock = new ItemStack(Material.STONE, 1);
        inv.addItem(logblock);
        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        inv.addItem(compass);
        ItemStack wand = new ItemStack(Material.WOOD_AXE, 1);
        ItemMeta wandmeta = wand.getItemMeta();
        wandmeta.setDisplayName(ChatColor.YELLOW + "WorldEdit Wand");
        wand.setItemMeta(wandmeta);
        inv.addItem(wand);
        ItemStack invispot = new ItemStack(Material.POTION, 1, (short) 8270);
        ItemMeta invismeta = invispot.getItemMeta();
        invismeta.setDisplayName(ChatColor.YELLOW + "Invis Potion");
        invispot.setItemMeta(invismeta);
        inv.addItem(invispot);
        sender_p.sendMessage(ChatColor.GOLD + "Admin tools have been added into your inventory, go get them c:.");
//Im the best ~Dark
        return true;
    }
}