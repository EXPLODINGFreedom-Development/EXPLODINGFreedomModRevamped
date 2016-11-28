package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "How to become administrator status", usage = "/<command>")
public class Command_apply extends TFM_Command {
      @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        sender.sendMessage(ChatColor.GOLD+ "§b=========§8[&bAdmin Application Instructions§8]§b=======");
        sender.sendMessage(ChatColor.GREEN + "§e- §c Go to '§bhttp://explodingfreedom.boards.net/§e' and make an account. 'Admin Applications' and remember to follow the template!");
        sender.sendMessage(ChatColor.GOLD + "§e- §c Don't beg to look at the application, it'll shorten the percentage on if it can get accepted.");
        sender.sendMessage(ChatColor.GOLD + "§e- §c How to apply for admin");
        sender.sendMessage(ChatColor.GOLD + "§e- §c To apply for admin you need to meet the requirements found at '§bhttp://explodingfreedom.boards.net/thread/294/admin-application-requirements-policy'");
        sender.sendMessage(ChatColor.GOLD + "§e- §cOnce you meet the requirements, go to a section titled 'Super Admin Applications'.");
        sender.sendMessage(ChatColor.GOLD + "§e- §cFill out the template in the new thread.");
        sender.sendMessage(ChatColor.RED + "§e- §c Please dont nag admins for recommendations or vouches, this will weaken your chances for Super Admin.");
        sender.sendMessage(ChatColor.GOLD + "That's all to it! Good luck!");
             return true;

    }
}
