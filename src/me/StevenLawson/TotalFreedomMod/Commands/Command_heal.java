package me.StevenLawson.TotalFreedomMod.Commands;

import static com.earth2me.essentials.I18n.tl;
import com.earth2me.essentials.User;
import com.earth2me.essentials.commands.PlayerExemptException;
import com.earth2me.essentials.commands.QuietAbortException;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import me.confuser.barapi.BarAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.potion.PotionEffect;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Heal Yourself", usage = "/<command>")
public class Command_heal extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
       if (args.length != 1) {
      return false;
    }
    final Player player = getPlayer(args[0]);
      if (player == null)
    {
               
                server.dispatchCommand(sender, "potion add heal 999 999");
                server.dispatchCommand(sender, "potion add saturation 999 999");
                server.dispatchCommand(sender, "potion clear" + sender.getName());	
                player.setFoodLevel(20);
		player.setFireTicks(0);
		sender.sendMessage(tl("heal"));
		for (PotionEffect effect : player.getActivePotionEffects())
        playerMsg("§6You have been healed by §c" + sender.getName() +"§6.");    
        return true;  
       }
        return false;
       }
}
