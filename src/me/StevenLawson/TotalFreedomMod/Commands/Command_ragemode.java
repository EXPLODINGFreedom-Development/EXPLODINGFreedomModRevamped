package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.Arrays;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Stupid people need to shut the fuck up", usage = "/<command>")
public class Command_ragemode extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
                 for(Player player : Bukkit.getOnlinePlayers())
                {
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    world.strikeLightningEffect(loc);
                    TFM_Util.adminAction(sender.getName(), "STOP THE MESSAGE AND SPAM AND SHUT THE FUCK UP!!", true);
                    
                    player.setHealth(0.0);
                }
                 return true;
    }
}