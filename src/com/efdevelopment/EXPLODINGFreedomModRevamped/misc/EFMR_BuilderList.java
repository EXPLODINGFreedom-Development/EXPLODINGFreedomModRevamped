package com.efdevelopment.EXPLODINGFreedomModRevamped.misc;

import com.google.common.base.Function;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import me.StevenLawson.TotalFreedomMod.Config.TFM_Config;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.Config.TFM_MainConfig;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_TwitterHandler;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_UuidManager;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import me.StevenLawson.TotalFreedomMod.World.TFM_BuilderWorld;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class EFMR_BuilderList
{
    public static final Function<Player, Boolean> BUILDER_SERVICE;
    public static final Function<Player, Boolean> BUILDERPLUS_SERVICE;
    private static final Map<UUID, EFMR_Builder> builderList;
    private static final Set<UUID> builderUUIDs;
    private static final Set<UUID> builderpUUIDs;
    private static final Set<String> seniorConsoleNames;
    private static final Set<String> builderIps;
    private static int cleanThreshold = 24 * 7; // 1 Week in hours

    static
    {
        builderList = new HashMap<UUID, EFMR_Builder>();
        builderUUIDs = new HashSet<UUID>();
        builderpUUIDs = new HashSet<UUID>();
        seniorConsoleNames = new HashSet<String>();
        builderIps = new HashSet<String>();
        BUILDER_SERVICE = new Function<Player, Boolean>()
        {

            @Override
            public Boolean apply(Player f)
            {
                return isBuilder(f);
            }
        };
        BUILDERPLUS_SERVICE = new Function<Player, Boolean>()
        {

            @Override
            public Boolean apply(Player f)
            {
                return isBuilderPlus(f);
            }
        };
    }

    private EFMR_BuilderList()
    {
        throw new AssertionError();
    }

    public static Set<UUID> getBuilderUUIDs()
    {
        return Collections.unmodifiableSet(builderUUIDs);
    }

    public static Set<UUID> getBuilderPlusUUIDs()
    {
        return Collections.unmodifiableSet(builderpUUIDs);
    }

    public static Set<String> getSeniorConsoleNames()
    {
        return Collections.unmodifiableSet(seniorConsoleNames);
    }

    public static Set<String> getBuilderIps()
    {
        return Collections.unmodifiableSet(builderIps);
    }

    public static Set<String> getBuilderNames()
    {
        final Set<String> names = new HashSet<String>();

        for (EFMR_Builder admin : builderList.values())
        {
            if (!admin.isActivated())
            {
                continue;
            }

            names.add(admin.getLastLoginName());
        }

        return Collections.unmodifiableSet(names);
    }

    public static Set<String> getLowerBuilderNames()
    {
        final Set<String> names = new HashSet<String>();

        for (EFMR_Builder admin : builderList.values())
        {
            if (!admin.isActivated())
            {
                continue;
            }

            names.add(admin.getLastLoginName().toLowerCase());
        }

        return Collections.unmodifiableSet(names);
    }

    public static Set<EFMR_Builder> getAllbuilders()
    {
        return Sets.newHashSet(builderList.values());
    }

    public static void setUuid(EFMR_Builder builder, UUID oldUuid, UUID newUuid)
    {
        if (!builderList.containsKey(oldUuid))
        {
            TFM_Log.warning("Could not set new UUID for builder " + builder.getLastLoginName() + ", admin is not loaded!");
            return;
        }

        if (oldUuid.equals(newUuid))
        {
            TFM_Log.warning("could not set new UUID for builder " + builder.getLastLoginName() + ", UUIDs match.");
            return;
        }

        final EFMR_Builder newBuilder = new EFMR_Builder(
                newUuid,
                builder.getLastLoginName(),
                builder.getLastLogin(),
                builder.getCustomLoginMessage(),
                builder.isBuilderPlus(),
                builder.isActivated());

        newBuilder.addIps(builder.getIps());

        builderList.remove(oldUuid);
        builderList.put(newUuid, newBuilder);

        final TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, TotalFreedomMod.BUILDER_FILENAME, true);

        config.load();
        config.set("builder." + oldUuid.toString(), null);
        config.save();

        save(newBuilder);
    }

    public static void load()
    {
        builderList.clear();

        final TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, TotalFreedomMod.BUILDER_FILENAME, true);
        config.load();

        cleanThreshold = config.getInt("clean_threshold_hours", cleanThreshold);

        if (!config.isConfigurationSection("builders"))
        {
            TFM_Log.warning("Missing builder section in donators.yml.");
            return;
        }

        final ConfigurationSection section = config.getConfigurationSection("builders");

        for (String uuidString : section.getKeys(false))
        {
            if (!TFM_Util.isUniqueId(uuidString))
            {
                TFM_Log.warning("Invalid Unique ID: " + uuidString + " in superadmin.yml, ignoring");
                continue;
            }

            final UUID uuid = UUID.fromString(uuidString);

            final EFMR_Builder superadmin = new EFMR_Builder(uuid, section.getConfigurationSection(uuidString));
            builderList.put(uuid, superadmin);
        }

        updateIndexLists();

        TFM_Log.info("Loaded " + builderList.size() + " builders (" + builderUUIDs.size() + " active) and " + builderIps.size() + " IPs.");
    }

    public static void updateIndexLists()
    {
        builderUUIDs.clear();
        builderpUUIDs.clear();
        seniorConsoleNames.clear();
        builderIps.clear();

        for (EFMR_Builder admin : builderList.values())
        {
            if (!admin.isActivated())
            {
                continue;
            }

            final UUID uuid = admin.getUniqueId();

            builderUUIDs.add(uuid);

            for (String ip : admin.getIps())
            {
                builderIps.add(ip);
            }

            if (admin.isBuilderPlus())
            {
                builderpUUIDs.add(uuid);

                seniorConsoleNames.add(admin.getLastLoginName());
                for (String alias : admin.getConsoleAliases())
                {
                    seniorConsoleNames.add(alias.toLowerCase());
                }
            }
        }

        TFM_BuilderWorld.getInstance().wipeAccessCache();
    }

    public static void saveAll()
    {
        final TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, TotalFreedomMod.BUILDER_FILENAME, true);
        config.load();

        config.set("clean_threshold_hours", cleanThreshold);

        final Iterator<Entry<UUID, EFMR_Builder>> it = builderList.entrySet().iterator();
        while (it.hasNext())
        {
            final Entry<UUID, EFMR_Builder> pair = it.next();

            final UUID uuid = pair.getKey();
            final EFMR_Builder builder = pair.getValue();

            config.set("builders." + uuid + ".last_login_name", builder.getLastLoginName());
            config.set("builders." + uuid + ".is_activated", builder.isActivated());
            config.set("builders." + uuid + ".is_donator_plus",builder.isBuilderPlus());
            config.set("builders." + uuid + ".last_login", TFM_Util.dateToString(builder.getLastLogin()));
            config.set("builders." + uuid + ".custom_login_message", builder.getCustomLoginMessage());
            config.set("builders." + uuid + ".console_aliases", TFM_Util.removeDuplicates(builder.getConsoleAliases()));
            config.set("builders." + uuid + ".ips", TFM_Util.removeDuplicates(builder.getIps()));
        }

        config.save();
    }

    public static void save(EFMR_Builder builder)
    {
        if (!builderList.containsValue(builder))
        {
            TFM_Log.warning("Could not save admin " + builder.getLastLoginName() + ", admin is not loaded!");
            return;
        }

        final TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, TotalFreedomMod.BUILDER_FILENAME, true);
        config.load();

        final UUID uuid = builder.getUniqueId();

        config.set("builder." + uuid + ".last_login_name", builder.getLastLoginName());
        config.set("builder." + uuid + ".is_activated", builder.isActivated());
        config.set("builder." + uuid + ".is_builder_plus", builder.isBuilderPlus());
        config.set("builder." + uuid + ".last_login", TFM_Util.dateToString(builder.getLastLogin()));
        config.set("builder." + uuid + ".custom_login_message", builder.getCustomLoginMessage());
        config.set("builder." + uuid + ".console_aliases", TFM_Util.removeDuplicates(builder.getConsoleAliases()));
        config.set("builder." + uuid + ".ips", TFM_Util.removeDuplicates(builder.getIps()));

        config.save();
    }

    public static EFMR_Builder getEntry(Player player)
    {
        return getEntry(TFM_UuidManager.getUniqueId(player));
    }

    public static EFMR_Builder getEntry(UUID uuid)
    {
        return builderList.get(uuid);
    }

    public static EFMR_Builder getEntry(String name)
    {
        for (UUID uuid : builderList.keySet())
        {
            if (builderList.get(uuid).getLastLoginName().equalsIgnoreCase(name))
            {
                return builderList.get(uuid);
            }
        }
        return null;
    }

    public static EFMR_Builder getEntryByIp(String ip)
    {
        return getEntryByIp(ip, false);
    }

    public static EFMR_Builder getEntryByIp(String needleIp, boolean fuzzy)
    {
        Iterator<Entry<UUID, EFMR_Builder>> it = builderList.entrySet().iterator();
        while (it.hasNext())
        {
            final Entry<UUID, EFMR_Builder> pair = it.next();
            final EFMR_Builder superadmin = pair.getValue();

            if (fuzzy)
            {
                for (String haystackIp : superadmin.getIps())
                {
                    if (TFM_Util.fuzzyIpMatch(needleIp, haystackIp, 3))
                    {
                        return superadmin;
                    }
                }
            }
            else
            {
                if (superadmin.getIps().contains(needleIp))
                {
                    return superadmin;
                }
            }
        }
        return null;
    }

    public static void updateLastLogin(Player player)
    {
        final EFMR_Builder admin = getEntry(player);
        if (admin == null)
        {
            return;
        }
        admin.setLastLogin(new Date());
        admin.setLastLoginName(player.getName());
        saveAll();
    }

    public static boolean isBuilderPlus(CommandSender sender)
    {
        return isBuilderPlus(sender, false);
    }

    public static boolean isBuilderPlus(CommandSender sender, boolean verifySuperadmin)
    {
        if (verifySuperadmin)
        {
            if (!isBuilderPlus(sender))
            {
                return false;
            }
        }

        if (!(sender instanceof Player))
        {
            return seniorConsoleNames.contains(sender.getName())
                    || (TFM_MainConfig.getBoolean(TFM_ConfigEntry.CONSOLE_IS_SENIOR) && sender.getName().equals("CONSOLE"));
        }

        final EFMR_Builder entry = getEntry((Player) sender);
        if (entry != null)
        {
            return entry.isBuilderPlus();
        }

        return false;
    }

    public static boolean isBuilder(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return true;
        }

        final Player player = (Player) sender;

        if (builderIps.contains(TFM_Util.getIp(player)))
        {
            return true;
        }

        if (Bukkit.getOnlineMode() && builderUUIDs.contains(TFM_UuidManager.getUniqueId(player)))
        {
            return true;
        }

        return false;
    }

    public static boolean isIdentityMatched(Player player)
    {
        if (!isBuilder(player))
        {
            return false;
        }

        if (Bukkit.getOnlineMode())
        {
            return true;
        }

        final EFMR_Builder entry = getEntry(player);
        if (entry == null)
        {
            return false;
        }

        return entry.getUniqueId().equals(TFM_UuidManager.getUniqueId(player));
    }

    @Deprecated
    public static boolean checkPartialSuperadminIp(String ip, String name)
    {
        ip = ip.trim();

        if (builderIps.contains(ip))
        {
            return true;
        }

        try
        {
            String matchIp = null;
            for (String testIp : builderIps)
            {
                if (TFM_Util.fuzzyIpMatch(ip, testIp, 3))
                {
                    matchIp = testIp;
                    break;
                }
            }

            if (matchIp != null)
            {
                final EFMR_Builder entry = getEntryByIp(matchIp);

                if (entry == null)
                {
                    return true;
                }

                if (entry.getLastLoginName().equalsIgnoreCase(name))
                {
                    if (!entry.getIps().contains(ip))
                    {
                        entry.addIp(ip);
                    }
                    saveAll();
                }
                return true;

            }
        }
        catch (Exception ex)
        {
            TFM_Log.severe(ex);
        }

        return false;
    }

    public static boolean isBuilderImpostor(Player player)
    {
        if (builderUUIDs.contains(TFM_UuidManager.getUniqueId(player)))
        {
            return !isBuilder(player);
        }

        return false;
    }

    public static void addBuilder(OfflinePlayer player)
    {
        final UUID uuid = TFM_UuidManager.getUniqueId(player);
        final String ip = TFM_Util.getIp(player);
        final boolean canSuperIp = !TFM_MainConfig.getList(TFM_ConfigEntry.NOADMIN_IPS).contains(ip);

        if (builderList.containsKey(uuid))
        {
            final EFMR_Builder superadmin = builderList.get(uuid);
            superadmin.setActivated(true);

            if (player.isOnline())
            {
                superadmin.setLastLogin(new Date());

                if (ip != null && canSuperIp)
                {
                    superadmin.addIp(ip);
                }
            }

            saveAll();
            updateIndexLists();
            return;
        }

        if (ip == null)
        {
            TFM_Log.severe("Could not add builder: " + TFM_Util.formatPlayer(player));
            TFM_Log.severe("Could not retrieve IP!");
            return;
        }

        if (!canSuperIp)
        {
            TFM_Log.warning("Could not add builder: " + TFM_Util.formatPlayer(player));
            TFM_Log.warning("IP " + ip + " may not be supered.");
            return;
        }

        final EFMR_Builder builder = new EFMR_Builder(
                uuid,
                player.getName(),
                new Date(),
                "",
                false,
                true);
        builder.addIp(ip);

        builderList.put(uuid, builder);

        saveAll();
        updateIndexLists();
    }

    public static void removeBuilder(OfflinePlayer player)
    {
        final UUID uuid = TFM_UuidManager.getUniqueId(player);

        if (!builderList.containsKey(uuid))
        {
            TFM_Log.warning("Could not remove builder: " + TFM_Util.formatPlayer(player));
            TFM_Log.warning("Player is not an builder!");
            return;
        }

        final EFMR_Builder donator = builderList.get(uuid);
        donator.setActivated(false);

        saveAll();
        updateIndexLists();
    }

    public static void cleanBuilderList(boolean verbose)
    {
        Iterator<Entry<UUID, EFMR_Builder>> it = builderList.entrySet().iterator();
        while (it.hasNext())
        {
            final Entry<UUID, EFMR_Builder> pair = it.next();
            final EFMR_Builder superadmin = pair.getValue();

            if (!superadmin.isActivated() || superadmin.isBuilderPlus())
            {
                continue;
            }

            final Date lastLogin = superadmin.getLastLogin();
            final long lastLoginHours = TimeUnit.HOURS.convert(new Date().getTime() - lastLogin.getTime(), TimeUnit.MILLISECONDS);

            if (lastLoginHours > cleanThreshold)
            {
                if (verbose)
                {
                    TFM_Util.adminAction("EXPLODINGFreedomMod", "Deactivating Builder " + superadmin.getLastLoginName() + ", inactive for " + lastLoginHours + " hours.", true);
                }

                superadmin.setActivated(false);
                TFM_TwitterHandler.delTwitter(superadmin.getLastLoginName());
            }
        }

        saveAll();
        updateIndexLists();
    }
}