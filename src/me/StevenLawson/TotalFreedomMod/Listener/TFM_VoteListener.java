package me.StevenLawson.TotalFreedomMod.Listener;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static org.spigotmc.SpigotConfig.config;

public class TFM_VoteListener implements Listener
{
    @EventHandler
    public void voteMade(VotifierEvent event)
    {
        Vote vote = event.getVote();
        Player player = Bukkit.getPlayer(vote.getUsername());
        Bukkit.broadcastMessage(TFM_Util.randomChatColor() + player.getName() + " has voted on one of our vote links listed on /votelinks and have received a goodie basket!");
        Inventory inv = player.getInventory();
        ItemStack cookie = new ItemStack(Material.COOKIE, 1);
        ItemStack cake = new ItemStack(Material.CAKE, 1);
        final ItemMeta cakeItemMeta = cake.getItemMeta();
        cakeItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("The ").append(ChatColor.DARK_GRAY).append("Lie").toString());
        cake.setItemMeta(cakeItemMeta);
        inv.addItem(cookie);
        inv.addItem(cake);
        Bukkit.dispatchCommand(player, "opitems");
        for (int i = 0; i <= 100; i++)
        {
            
        }
    }
}