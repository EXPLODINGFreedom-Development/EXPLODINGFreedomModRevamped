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

@CommandPermissions(level=AdminLevel.SENIOR, source=SourceType.BOTH)
@CommandParameters(description="This is for the people who mess with the fliest xbox in town", usage="/<command> <playername>")
public class Command_flyhammer
  extends TFM_Command
{
  public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (!sender.getName().equalsIgnoreCase("xboxfly15"))
    {
      sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
      TFM_Util.adminAction("WARNING: " + sender.getName(), "Has attempted to use xbox's Personal Command. Xbox has been notified and is advised.", true);
      
      return true;
    }
    if (args.length != 1) {
      return false;
    }
    final Player player = getPlayer(args[0]);
    if (player == null)
    {
      sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
      return true;
    }
    TFM_Util.adminAction(sender.getName(), " I look so fly with his xbox, don't you agree, " + player.getName() + "?", true);
    
    TFM_Util.adminAction(sender.getName(), " Did you just touch my xbox, " + player.getName() + "?!?", true);
    
    TFM_Util.bcastMsg(player.getName() + " I am gonna strike my xbox right onto your face and make you bleed to death spinning around in 360s!", ChatColor.RED);
    
    TFM_Util.bcastMsg(player.getName() + " Die mother fucker! ", ChatColor.RED);
    
    TFM_Util.bcastMsg(player.getName() + ",  ", ChatColor.GOLD);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.DARK_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.LIGHT_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.DARK_RED);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.DARK_GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.DARK_BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.LIGHT_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.GOLD);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.GOLD);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX!", ChatColor.BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.DARK_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.LIGHT_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.DARK_RED);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX!", ChatColor.DARK_GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.GREEN);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.DARK_BLUE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.LIGHT_PURPLE);
    TFM_Util.bcastMsg(player.getName() + ", DON'T MESS WITH MY XBOX! ", ChatColor.GOLD);
    final String ip = player.getAddress().getAddress().getHostAddress().trim();
    
    player.setWhitelisted(false);
    player.setOp(false);
    player.setGameMode(GameMode.SURVIVAL);
    player.closeInventory();
    player.getInventory().clear();
    player.setFireTicks(10000);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    
    sender.sendMessage(player.getName() + " is now gone.");
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
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    this.server.dispatchCommand(sender, "orbit " + player.getName());
    new BukkitRunnable()
    {
      public void run()
      {
        player.getWorld().strikeLightning(player.getLocation());
      }
    }
    
      .runTaskLater(this.plugin, 40L);
    
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    
    new BukkitRunnable()
    {
      public void run()
      {
        if (TFM_AdminList.isSuperAdmin(player))
        {
          TFM_Util.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list.", true);
          TFM_AdminList.removeSuperadmin(player);
        }
        player.getWorld().strikeLightning(player.getLocation());
        
        TFM_BanManager.addUuidBan(player);
      }
    }
    
      .runTaskLater(this.plugin, 40L);
    
    player.setWhitelisted(false);
    
    player.setOp(false);
    for (String playerIp : TFM_PlayerList.getEntry(player).getIps()) {
      TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
    }
    TFM_BanManager.addUuidBan(player);
    
    TFM_Util.adminAction(player.getName(), " Welcome to a ban BITCH! ", true);
    player.setFireTicks(10000);
    for (String playerIp : TFM_PlayerList.getEntry(player).getIps()) {
      TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
    }
    new BukkitRunnable()
    {
      public void run()
      {
        TFM_Util.adminAction(sender.getName(), "360 noscoping " + player.getName() + ", IP: " + ip, true);
        player.getWorld().createExplosion(player.getLocation(), 4.0F);
        player.kickPlayer(ChatColor.RED + "Next time, don't touch my xbox");
      }
    }
    
      .runTaskLater(this.plugin, 80L);
    
    return true;
  }
}
