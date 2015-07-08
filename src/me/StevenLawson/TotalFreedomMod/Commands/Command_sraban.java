package me.StevenLawson.TotalFreedomMod.Commands;

//import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_UuidResolver;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Senior Admin banning comand", usage = "/<command> <playername>")
public class Command_sraban extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
   
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }
         TFM_Util.adminAction(player.getName(), "decided to annoy " + sender.getName(), true);
//         TFM_Util.adminAction(sender.getName(), " And will be destroyed!", true);
         TFM_Util.bcastMsg((sender.getName() + "is going HAM on " + player.getName()), ChatColor.BLUE);
/*         player.chat("GOD WHAT DID I DO TO RobinGall2910!");
         player.chat("NONONONO PLEASE NO!!!");
         player.chat("I beg you!!!!");
         player.chat("Dont get rid of me!");
         sender_p.chat("Well too bad for you!");
*/         // im awesome aint i?
/*         sender.sendMessage(player.getName() + " is now gone.");
          player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
          player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
          player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
          player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
          player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
          player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
          player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
          player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
          player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
          player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
          player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().createExplosion(player.getLocation(), 4F);
          player.getWorld().createExplosion(player.getLocation(), 4F);
          player.getWorld().createExplosion(player.getLocation(), 4F);
          player.getWorld().createExplosion(player.getLocation(), 4F);
          player.getWorld().createExplosion(player.getLocation(), 4F);
          player.getWorld().createExplosion(player.getLocation(), 4F);
          player.getWorld().createExplosion(player.getLocation(), 4F);
          player.getWorld().createExplosion(player.getLocation(), 4F);
          player.getWorld().createExplosion(player.getLocation(), 4F);
          player.getWorld().createExplosion(player.getLocation(), 4F);
*/          server.dispatchCommand(sender, "orbit " + player.getName());
          
        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        // remove from superadmin
/*        if (TFM_AdminList.isSuperAdmin(player))
        {
            TFM_Util.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list.", true);
            TFM_AdminList.removeSuperadmin(player);
        }
*/
        // remove from whitelist
        player.setWhitelisted(false);

        // deop
        player.setOp(false);

        // ban IPs
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }

        // ban uuid
        TFM_BanManager.addUuidBan(player);
        
         // set gamemode to survival
         player.setGameMode(GameMode.SURVIVAL);
 
         // clear inventory
         player.closeInventory();
         player.getInventory().clear();
 
         // ignite player
         player.setFireTicks(10000);
 
/*         // generate explosion
         player.getWorld().createExplosion(player.getLocation(), 4F);
*/ 
         // Shoot the player in the sky
         player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
 
         new BukkitRunnable()
         {
            @Override
             public void run()
             {
                 // strike lightning
                 player.getWorld().strikeLightning(player.getLocation());
 
                 // kill (if not done already)
                 player.setHealth(0.0);
                 
/*                 //Broadcast player is gone
                 TFM_Util.bcastMsg("Aaaaaaaaaaaaaaaaaaand hes out of here!!", ChatColor.BLUE);
*/                 
                 //says im dead
                 player.chat("Welp, I shoudln't have annoyed " + sender.getName() + "!");
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
                 player.kickPlayer(ChatColor.RED + "This is what happens when you fuck with a senior!");
//                 TFM_Util.bcastMsg(player.getName() + " is now gone thanks to " + sender.GetName(), ChatColor.DARK_GREEN);
                 server.dispatchCommand(sender, "co rb u:" + player.getName() + " t:24h r:#global");
            }
        }.runTaskLater(plugin, 3L * 20L);
         return true;
    }
}


// Thanks @Robin, I basicially just stole all of your code!
