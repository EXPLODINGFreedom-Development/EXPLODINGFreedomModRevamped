package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level=AdminLevel.ALL, source=SourceType.BOTH)
@CommandParameters(description="LOLOLOL", usage="/<command> <playername>")
public class Command_rekt
  extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole){
    	
    
        if (!sender.getName().equalsIgnoreCase("Alco_Rs11"))
        if (!sender.getName().equalsIgnoreCase("Jayscoob"))
        if (!sender.getName().equalsIgnoreCase("agent_waddles"))
        if (!sender.getName().equalsIgnoreCase("Joenmb"))
        {
            
            TFM_Util.adminAction("WARNING: " + sender.getName(), "Has attempted to use /rekt. EXPLODINGTNT001 and _xXTheOPXx_ have been notified.", true);
          
         
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
        TFM_Util.adminAction(sender.getName(), "This Player is a skrub and needs to die: " + player.getName(), true);
        TFM_Util.bcastMsg(player.getName() + ": Will be rekt and killed. ", ChatColor.RED);
        player.chat("/nick &b&lImASkrub");
        player.chat("/tag set &8[&b&lSkrubMe&8]");
        TFM_Util.bcastMsg(player.getName() + " Your gonna be rekt soo hard, you wish you fucked yourself instead.");
        player.chat("hehe");
        TFM_Util.bcastMsg("OH YOU THINK THIS IS FUNNY FUCKER! Lets see what happens next!");
        player.chat("Ooh lets see!");
        player.chat("NOO WHY NOT ME WHYYY!");
        TFM_Util.bcastMsg(player.getName() + " - got rekt ", ChatColor.BLUE);
        TFM_Util.bcastMsg(player.getName() + " - got rekt ", ChatColor.GREEN);
        TFM_Util.bcastMsg(player.getName() + " - got rekt ", ChatColor.DARK_PURPLE);
        TFM_Util.bcastMsg(player.getName() + " - got rekt ", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg(player.getName() + " - got rekt ", ChatColor.DARK_RED);
        TFM_Util.bcastMsg(player.getName() + " - got rekt ", ChatColor.DARK_GREEN);
        TFM_Util.bcastMsg(player.getName() + " - got rekt ", ChatColor.BLUE);
        TFM_Util.bcastMsg(player.getName() + " - got rekt ", ChatColor.GREEN);
        TFM_Util.bcastMsg(player.getName() + " - got rekt ", ChatColor.DARK_BLUE);
        TFM_Util.bcastMsg(player.getName() + " - got rekt ", ChatColor.LIGHT_PURPLE);
        TFM_Util.bcastMsg(player.getName() + " - got rekt ", ChatColor.GOLD);
        TFM_Util.adminAction(sender.getName(), " - Has Rekt: " + player.getName(), true);
        final String ip = player.getAddress().getAddress().getHostAddress().trim();
    // kill (if not done already)
    player.setHealth(0.0);
    player.setWhitelisted(false);
    player.setOp(false);
    player.setGameMode(GameMode.SURVIVAL);
    player.closeInventory();
    player.getInventory().clear();
    player.setFireTicks(10000);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    // im awesome aint i?
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
          new BukkitRunnable()
                  
        {
      public void run()
      {
        player.getWorld().strikeLightning(player.getLocation());
      }
    };
      return false;
  } 
}
  