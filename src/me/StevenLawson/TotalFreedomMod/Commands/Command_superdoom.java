package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.Banning.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.Banning.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.Player.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "For the bad Superadmins", aliases="suuperduum", usage = "/<command> <playername>")
public class Command_superdoom extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
          if (!sender.getName().equalsIgnoreCase("Alco_Rs11"))        
          if (!sender.getName().equalsIgnoreCase("Easter_Elf"))
          if (!sender.getName().equalsIgnoreCase("TheTrueCanadian"))
        {
            playerMsg(TotalFreedomMod.MSG_NO_PERMS);
            TFM_Util.adminAction("[Risk]: " + sender.getName(), "You're now at risk of suspension from Alco_rS11. :/", true);
            sender.setOp(false);
            return true;
        } 
        if (args.length == 0)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }

        TFM_Util.bcastMsg(player.getName() + " You're a bad Super Admin and will never be one again bye :)", ChatColor.RED);
        TFM_Util.adminAction(sender.getName(), " Now Ripping up " + player.getName() +  "'s Super Admin apllication!", true);
        TFM_Util.bcastMsg(player.getName() + "'s Application will now BE FUCKED", ChatColor.RED);
        TFM_Util.bcastMsg(player.getName() + "Fuck with Alkopoo bout a week ago.. Fuck with us and we tweaking whoe tweaking whoe!", ChatColor.RED);

        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        // remove from superadmin
        if (TFM_AdminList.isSuperAdmin(player))
        {
            TFM_Util.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list.", true);
            TFM_AdminList.removeSuperadmin(player);
        }

        // remove from whitelist
        player.setWhitelisted(false);

        // deop
        player.setOp(false);

        // ban IPs
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }

        // ban name
        TFM_BanManager.addUuidBan(new TFM_Ban(player.getUniqueId(), player.getName()));

        // set gamemode to survival
        player.setGameMode(GameMode.SURVIVAL);

        // clear inventory
        player.closeInventory();
        player.getInventory().clear();

        // ignite player
        player.setFireTicks(10000);

        // generate explosion
        player.getWorld().createExplosion(player.getLocation(), 4F);

        // Shoot the player in the sky
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
                //strike lightning
                player.getWorld().strikeLightning(player.getLocation());

                // kill (if not done already)
                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 2L * 20L);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // message
                TFM_Util.adminAction(sender.getName(), "Banning " + player.getName() + ", IP: " + ip, true);

                // generate explosion
                player.getWorld().createExplosion(player.getLocation(), 4F);

                // kick player
                player.kickPlayer(ChatColor.RED + "Bith messed with me...bout week agooo... Fuck with Spameypoo and we tweeking whoe tweeking whoe");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
}