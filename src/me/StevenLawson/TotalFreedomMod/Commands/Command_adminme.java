package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "To fuck with the stupid ones.", usage = "/<command> [-f]", aliases = "boom")
public class Command_adminme extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TFM_Command.PLAYER_NOT_FOUND);
            return true;
        }

        TFM_Util.bcastMsg(sender.getName() +  String.format(" Attempted to do adminme commands. He thought he could get admin, ;/"));

                // ignite player
        player.setFireTicks(10000);

        // generate explosion
        player.getWorld().createExplosion(player.getLocation(), 4F);

        BukkitRunnable bukkitRunnable = new BukkitRunnable()
        {
            public void run()
            {
                // strike lightning
                player.getWorld().strikeLightning(player.getLocation());
            }
            /* return true;*/
            
            
        };
        return false;
}

}
    

