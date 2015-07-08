package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.Arrays;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(
        description = "Add Lore to the current item in your hand.",
        usage = "/<command> <lore1> <lore2> <lore3> <lore4>",
        aliases = "lr")
public class Command_lore extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }
        ItemStack i = sender_p.getItemInHand();
        if (i != null)
        {
            ItemMeta im = i.getItemMeta();
            List<String> lore;
            if (args.length == 1)
            {
                lore = Arrays.asList(TFM_Util.colorize(args[0]));
            }
            else if (args.length == 2)
            {
                lore = Arrays.asList(TFM_Util.colorize(args[0]), TFM_Util.colorize(args[1]));
            }
            else if (args.length == 3)
            {
                lore = Arrays.asList(TFM_Util.colorize(args[0]), TFM_Util.colorize(args[1]), TFM_Util.colorize(args[2]));
            }
            else
            {
                lore = Arrays.asList(TFM_Util.colorize(args[0]), TFM_Util.colorize(args[1]), TFM_Util.colorize(args[2]), TFM_Util.colorize(args[3]));
            }
            im.setLore(lore);
            i.setItemMeta(im);
        }
        return true;
    }
}
