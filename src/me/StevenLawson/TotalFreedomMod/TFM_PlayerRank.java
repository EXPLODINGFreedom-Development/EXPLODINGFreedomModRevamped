package me.StevenLawson.TotalFreedomMod;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.FOP_DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SPECIAL_EXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYS_ADMINS;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum TFM_PlayerRank
{
    PROBIE("a " + ChatColor.LIGHT_PURPLE + "Probationary Senior Admin", ChatColor.LIGHT_PURPLE + "[SrA]"),
    DEVELOPER("a " + ChatColor.DARK_PURPLE + "Plugin Developer", ChatColor.DARK_PURPLE + "[Plugin Developer]"),
    THEOP("a " + ChatColor.DARK_RED + "Developer/System-Admin", ChatColor.DARK_RED + "[System-Admin/Dev]"),
    FLUFFY("a " + ChatColor.DARK_PURPLE + "Developer/Executive", ChatColor.DARK_PURPLE + "[Developer/Exec]"),
    FOP_DEVELOPER("a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.DARK_PURPLE + "[Developer]"),
    SPEC_EXEC("an " + ChatColor.BLUE + "Special-Executive", ChatColor.BLUE + "[Special-Executive]"),
    HELPER("an " + ChatColor.YELLOW + "Helper", ChatColor.YELLOW + "[Helper]"),
    BUILDER("a " + ChatColor.GOLD + "Master-Builder", ChatColor.GOLD + "[Master-Builder]"),
    EXEC("an " + ChatColor.BLUE + "Executive", ChatColor.BLUE + "[Executive]"),
    EXECMANAGER("a " + ChatColor.RED + "Executive Admin-Manager", ChatColor.RED + "[Executive Admin-Manager]"),
    SYS_ADMIN("a " + ChatColor.DARK_RED + "System-Admin", ChatColor.DARK_RED + "[System-Admin]"),
    SECURITY("the " + ChatColor.RED + "Chief of Security", ChatColor.RED + "[Cheif Of Security]"), 
    MULTICRAFT("a " + ChatColor.GREEN + "Telnet MultiCraft Admin", ChatColor.GREEN + "[Telnet MultiCraft Admin]"),
    DEPSECURITY("the " + ChatColor.RED + "Deputy of Security", ChatColor.RED + "[Deputy Of Security]"),
    IMPOSTOR("an " + ChatColor.YELLOW + ChatColor.UNDERLINE + "Impostor", ChatColor.YELLOW.toString() + ChatColor.UNDERLINE + "[IMP]"),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    CHIEFEXEC("the " + ChatColor.RED + "Chief Executive Officer", ChatColor.RED + "[Chief Executive Officer]"),
    OP("an " + ChatColor.RED + "OP", ChatColor.RED + "[OP]"),
    HONORARY("a " + ChatColor.YELLOW + "Honorary Senior Administrator", ChatColor.YELLOW + "[Honorary-SrA]"),
    SUPER("a " + ChatColor.GOLD + "Super Admin", ChatColor.GOLD + "[SA]"),
    WEBDEV("a " + ChatColor.RED + "Web Developer", ChatColor.RED + "[Web-Dev]"),
    LEADSYS("the " + ChatColor.DARK_RED + "Lead System-Admin", ChatColor.DARK_RED + "[Lead-SyS]"),
    TELNET("a " + ChatColor.DARK_GREEN + "Super Telnet Admin", ChatColor.DARK_GREEN + "[STA]"),
    LEADWEBDEV("the " + ChatColor.DARK_PURPLE + "Lead Forum Developer", ChatColor.DARK_PURPLE + "[Lead Forum-Dev]"),
    SENIOR("a " + ChatColor.LIGHT_PURPLE + "Senior Admin", ChatColor.LIGHT_PURPLE + "[SrA]"),
    OWNER("the " + ChatColor.DARK_RED + "System-Owner", ChatColor.DARK_RED + "[System-Owner]"),
    SYS_COOWNER("the " + ChatColor.DARK_BLUE + "System Co-Owner", ChatColor.DARK_BLUE + "[System Co-Owner]"),
    CONSOLE("the " + ChatColor.DARK_PURPLE + "Console", ChatColor.DARK_PURPLE + "[Console]");
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
        if (sender.getName().equals("PacksGamingHD"))
        {
            return EXEC;
        } 
        if (sender.getName().equals("agent_waddles"))
        {
            return SYS_ADMIN;
        }  
        if (sender.getName().equals("TaahThePenguin"))
        {
            return EXEC;
        }
        if (sender.getName().equals("Silver_D"))
        {
            return SPEC_EXEC;
        }
        if (sender.getName().equals("WaddlesThePig"))
        {
            return SYS_ADMIN;
        }
        if (sender.getName().equals("Japanese_Sushi"))
        {
            return HONORARY;
        }
        if (sender.getName().equals("Joenmb"))
        {
            return EXEC;
        }
        if (sender.getName().equals("MrPerson660"))
        {
            return EXECMANAGER;
        }  
        if (sender.getName().equals("jayscoob"))
        {
            return SYS_COOWNER;
        }    
        if (sender.getName().equals("XxNicozillaxX"))
        {
            return SYS_COOWNER;
        }
        if (sender.getName().equals("XXDidiXX"))
        {
            return DEVELOPER;
        }
        
        if (sender.getName().equals("hiram2238"))
        {
            return MULTICRAFT;
        }
        if (sender.getName().equals("LOL_BUDDES"))
        {
            return HONORARY;
        }
        if (sender.getName().equals("DarkGamingDronze"))
        {
            return THEOP;
        }
              if (sender.getName().equals("DarkHorse108"))
        {
            return SYS_COOWNER;
        }
         else if (sender.getName().equals("evanator324"))
        {
            return SYS_COOWNER;
        }
        
        else if (sender.getName().equals("robgreenwood"))
        {
            return DEPSECURITY;
        }     
        else if (sender.getName().equals("Alco_Rs11"))
        {
            return OWNER;
        }
        else if (sender.getName().equals("xfilez"))
        {
            return LEADSYS;
        }
               
        else if (sender.getName().equals("Azzieuss"))
        {
            return SECURITY;
        }
        
        else if (sender.getName().equals("brickblock12"))
        {
            return LEADWEBDEV;
        }
        
        else if (sender.getName().equals("charlie5690"))
        {
            return CHIEFEXEC;
        }
        
        else if (sender.getName().equals("fluffycq"))
        {
            return FLUFFY;
        }
        else if (sender.getName().equals("Jeremiah_v"))
        {
            return HELPER;
        }
        
        else if (sender.getName().equals("LucazDaKing"))
        {
            return SPEC_EXEC;
        }       
        else if (SYS_ADMINS.contains(sender.getName()))
        {
            return SYS_ADMIN;
        }
        
        else if (SPECIAL_EXECS.contains(sender.getName()))
        {
            return SPEC_EXEC;
        }
        
        else if (FOP_DEVELOPERS.contains(sender.getName()))
        {
            return FOP_DEVELOPER;
        }
        
        else if (DEVELOPERS.contains(sender.getName()))
        {
            return DEVELOPER;
        }
        
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);

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
