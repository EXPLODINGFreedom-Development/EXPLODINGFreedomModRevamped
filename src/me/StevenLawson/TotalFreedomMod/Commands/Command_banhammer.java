package me.StevenLawson.TotalFreedomMod.Commands;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_UuidManager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Gain a banhammer!", usage = "/<command>")
public class Command_banhammer extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
    if (!TFM_Util.LEADSYSS.contains(sender.getName()) && !TFM_Util.SYS_ADMINS.contains(sender.getName()) && !TFM_Util.SPECIAL_EXECS .contains(sender.getName()) && !TFM_Util.CHIEFEXECS.contains(sender.getName()) && !TFM_Util.OWNERS.contains(sender.getName()) && !TFM_Util.SYS_COOWNERS.contains(sender.getName()));
        
        PlayerInventory inventory = sender_p.getInventory();
        
        if (args.length != 0) {
            return false;
        }

        if (TFM_ConfigEntry.DHAMMER_MODE.getBoolean() == false) {
            TFM_Util.adminAction(sender.getName(), "Has unleased the Ban Hammer!", true);
            TFM_ConfigEntry.DHAMMER_MODE.setBoolean(true);
            inventory.addItem(getDoomHammer());
            for (Player player : server.getOnlinePlayers()) {
                if (!TFM_AdminList.isSeniorAdmin(player)) {
                    player.setGameMode(GameMode.SURVIVAL);
                    TFM_PlayerData playerData = TFM_PlayerData.getPlayerData(player);
                    playerData.setFrozen(true);
                }
            }
            return true;
        }

        if (TFM_ConfigEntry.DHAMMER_MODE.getBoolean() == true) {
            TFM_Util.adminAction(sender.getName(), "Placing the ban hammer back into its sheath, YOU ARE SAFE... FOR NOW!!!!", true);
            TFM_ConfigEntry.DHAMMER_MODE.setBoolean(false);
            inventory.removeItem(getDoomHammer());
            for (Player player : server.getOnlinePlayers()) {
                if (!TFM_AdminList.isSeniorAdmin(player)) {
                    player.setGameMode(GameMode.CREATIVE);
                    TFM_PlayerData playerData = TFM_PlayerData.getPlayerData(player);
                    playerData.setFrozen(false);
                }
            }
            return true;
        }

        return true;
    }

    public static ItemStack getDoomHammer() {
        ItemStack dhammer = new ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta dhammermeta = dhammer.getItemMeta();
        List<String> lores = new ArrayList<String>();
        lores.add(ChatColor.RED + "The all powerful Ban Hammer!");
        dhammermeta.setDisplayName(ChatColor.DARK_RED + "Ban Hammer");
        dhammermeta.setLore(lores);
        dhammer.setItemMeta(dhammermeta);
        return dhammer;
    }
}