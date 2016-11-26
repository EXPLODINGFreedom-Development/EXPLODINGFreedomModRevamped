package me.StevenLawson.TotalFreedomMod.Rank;

import me.StevenLawson.TotalFreedomMod.Admin.TFM_Admin;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.BUILDERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.CHIEFEXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.HELPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.EXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.LEADSYSS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.MULTICRAFTS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SPECIAL_EXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYS_ADMINS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYS_COOWNERS;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum TFM_PlayerRank
{
    DEVELOPER("a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.DARK_PURPLE + "[Developer]"),
    CONSOLE("the " + ChatColor.DARK_PURPLE + "Console", ChatColor.DARK_PURPLE + "[Console]"),
    OWNER("the " + ChatColor.DARK_RED + "System-Owner", ChatColor.DARK_RED + "[System-Owner]"),
    SYS_COOWNER("the " + ChatColor.DARK_BLUE + "System Co-Owner", ChatColor.DARK_BLUE + "[System Co-Owner]"),
    LEADSYS("the " + ChatColor.DARK_RED + "Lead System-Admin", ChatColor.DARK_RED + "[Lead System-Admin]"),
    SYS_ADMIN("a " + ChatColor.DARK_RED + "System-Admin", ChatColor.DARK_RED + "[System-Admin]"),
    CHIEFEXEC("the " + ChatColor.RED + "Chief Executive Officer", ChatColor.RED + "[Chief Executive Officer]"),
    SENIOR("a " + ChatColor.LIGHT_PURPLE + "Senior Admin", ChatColor.LIGHT_PURPLE + "[SrA]"),
    MULTICRAFT("a " + ChatColor.GREEN + "Telnet MultiCraft Admin", ChatColor.GREEN + "[Telnet Multi-Admin]"),
    TELNET("a " + ChatColor.DARK_GREEN + "Super Telnet Admin", ChatColor.DARK_GREEN + "[STA]"),
    EXEC("a " + ChatColor.BLUE + "Executive", ChatColor.BLUE + "[Executive]"),
    SPECEXEC("a " + ChatColor.GREEN + "Specialist", ChatColor.GREEN + "[Specialist]"),
    HELPER("a " + ChatColor.YELLOW + "Helper", ChatColor.YELLOW + "[Helper]"),
    SUPER("a " + ChatColor.GOLD + "Super Admin", ChatColor.GOLD + "[SA]"),
    OP("an " + ChatColor.RED + "OP", ChatColor.RED + "[OP]"),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    IMPOSTOR("an " + ChatColor.YELLOW + ChatColor.UNDERLINE + "Impostor", ChatColor.YELLOW.toString() + ChatColor.UNDERLINE + "[IMP]");
    private String loginMessage;
    private String prefix;

    private TFM_PlayerRank(String loginMessage, String prefix)
    {
        this.loginMessage = loginMessage;
        this.prefix = prefix;
    }

    public static String getLoginMessage(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            return fromSender(sender).getLoginMessage();
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (entry == null)
        {
            // Player is not an admin
            return fromSender(sender).getLoginMessage();
        }

        // Custom login message
        final String loginMessage = entry.getCustomLoginMessage();

        if (loginMessage == null || loginMessage.isEmpty())
        {
            return fromSender(sender).getLoginMessage();
        }

        return ChatColor.translateAlternateColorCodes('&', loginMessage);
    }

    public static TFM_PlayerRank fromSender(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return CONSOLE;
        }

        if (TFM_AdminList.isAdminImpostor((Player) sender))
        {
            return IMPOSTOR;
        }
        if (DEVELOPERS.contains(sender.getName()))
        {
            return DEVELOPER;
            }
            if (SYS_COOWNERS.contains(sender.getName()))
            {
                return SYS_COOWNER;
            }
            if (LEADSYSS.contains(sender.getName()))
            {
                return LEADSYS;
            }
            if (SYS_ADMINS.contains(sender.getName()))
            {
                return SYS_ADMIN;
            }
            if (SPECIAL_EXECS.contains(sender.getName()))
            {
                return SPECEXEC;
            }
            if (EXECS.contains(sender.getName()))
            {
                return EXEC;
            }
            if (CHIEFEXECS.contains(sender.getName()))
            {
                return CHIEFEXEC;
            }
            if (HELPERS.contains(sender.getName()))
            {
                return HELPER;
            }
            if (MULTICRAFTS.contains(sender.getName()))
            {
                return MULTICRAFT;
            }
            
        final TFM_Admin entry = TFM_AdminList.getEntryByIp(TFM_Util.getIp((Player) sender));

        final TFM_PlayerRank rank;

        if (entry != null && entry.isActivated())
        {
            if (TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()))
            {
                return OWNER;
            }
                        
            if (entry.isSeniorAdmin())
            {
                rank = SENIOR;
            }
            else if (entry.isTelnetAdmin())
            {
                rank = TELNET;
            }
            else
            {
            
                rank = SUPER;
            }
        }
        else
        {
            if (sender.isOp())
            {
                rank = OP;
            }
            else
            {
                rank = NON_OP;
            }

        }
        return rank;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getLoginMessage()
    {
        return loginMessage;
    }
}
