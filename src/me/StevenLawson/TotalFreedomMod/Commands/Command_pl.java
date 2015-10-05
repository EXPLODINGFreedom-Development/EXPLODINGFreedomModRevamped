package me.StevenLawson.TotalFreedomMod.Commands;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "List plugins", usage = "/<command>", aliases = "pl")
public class Command_pl extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        server.dispatchCommand(sender, "pl list");
        
        if (args.length == 0 || args.length > 2)
        {
            return false;
        }

        final PluginManager pm = server.getPluginManager();

        if (args.length == 1)
        {
                        {
                for (Plugin serverPlugin : pm.getPlugins())
                {
                    final String version = serverPlugin.getDescription().getVersion();
                    playerMsg(ChatColor.GOLD + "Plugins: ");
                    playerMsg(ChatColor.GRAY + "- " + (serverPlugin.isEnabled() ? ChatColor.GREEN : ChatColor.RED) + serverPlugin.getName()
                            + ChatColor.GOLD + (version != null && !version.isEmpty() ? " v" + version : "") + " by "
                            + StringUtils.join(serverPlugin.getDescription().getAuthors(), ", "));
                }

                return true;
            }

                }
        return false;
    }
}
   

