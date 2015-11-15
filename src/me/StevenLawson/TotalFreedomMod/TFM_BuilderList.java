package me.StevenLawson.TotalFreedomMod;

import com.google.common.base.Function;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import me.StevenLawson.TotalFreedomMod.Config.TFM_Config;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.Config.TFM_MainConfig;
import me.StevenLawson.TotalFreedomMod.World.TFM_BuilderWorld;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class TFM_BuilderList
{
  private static int cleanThreshold = 168;
  
  static
  {
    builderList = new HashMap();
    builderUUIDs = new HashSet();
    builderpUUIDs = new HashSet();
    seniorConsoleNames = new HashSet();
    builderIps = new HashSet();
  }
  
  public static final Function<Player, Boolean> BUILDER_SERVICE = new Function()
  {
    public Boolean apply(Player f)
    {
      return Boolean.valueOf(TFM_BuilderList.isBuilder(f));
    }

      @Override
      public Object apply(Object f)
      {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
  };
  
  private static final Map<UUID, TFM_Builder> builderList;
  private static final Set<UUID> builderUUIDs;
  private static final Set<UUID> builderpUUIDs;
  private static final Set<String> seniorConsoleNames;
  private static final Set<String> builderIps;
  
  private TFM_BuilderList()
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
    Set<String> names = new HashSet();
    for (TFM_Builder admin : builderList.values()) {
      if (admin.isActivated()) {
        names.add(admin.getLastLoginName());
      }
    }
    return Collections.unmodifiableSet(names);
  }
  
  public static Set<String> getLowerBuilderNames()
  {
    Set<String> names = new HashSet();
    for (TFM_Builder admin : builderList.values()) {
      if (admin.isActivated()) {
        names.add(admin.getLastLoginName().toLowerCase());
      }
    }
    return Collections.unmodifiableSet(names);
  }
  
  public static Set<TFM_Builder> getAllbuilders()
  {
    return Sets.newHashSet(builderList.values());
  }
  
  public static void setUuid(TFM_Builder builder, UUID oldUuid, UUID newUuid)
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
    TFM_Builder newBuilder = new TFM_Builder(newUuid, builder.getLastLoginName(), builder.getLastLogin(), builder.getCustomLoginMessage(), builder.isBuilderPlus(), builder.isActivated());
    
    newBuilder.addIps(builder.getIps());
    
    builderList.remove(oldUuid);
    builderList.put(newUuid, newBuilder);
    
    TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, "builder.yml", true);
    
    config.load();
    config.set("builder." + oldUuid.toString(), null);
    config.save();
    
    save(newBuilder);
  }
  
  public static void load()
  {
    builderList.clear();
    
    TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, "builder.yml", true);
    config.load();
    
    cleanThreshold = config.getInt("clean_threshold_hours", cleanThreshold);
    if (!config.isConfigurationSection("builders"))
    {
      TFM_Log.warning("Missing builder section in donators.yml.");
      return;
    }
    ConfigurationSection section = config.getConfigurationSection("builders");
    for (String uuidString : section.getKeys(false)) {
      if (!TFM_Util.isUniqueId(uuidString))
      {
        TFM_Log.warning("Invalid Unique ID: " + uuidString + " in superadmin.yml, ignoring");
      }
      else
      {
        UUID uuid = UUID.fromString(uuidString);
        
        TFM_Builder superadmin = new TFM_Builder(uuid, section.getConfigurationSection(uuidString));
        builderList.put(uuid, superadmin);
      }
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
    for (TFM_Builder admin : builderList.values()) {
      if (admin.isActivated())
      {
        UUID uuid = admin.getUniqueId();
        
        builderUUIDs.add(uuid);
        for (String ip : admin.getIps()) {
          builderIps.add(ip);
        }
        if (admin.isBuilderPlus())
        {
          builderpUUIDs.add(uuid);
          
          seniorConsoleNames.add(admin.getLastLoginName());
          for (String alias : admin.getConsoleAliases()) {
            seniorConsoleNames.add(alias.toLowerCase());
          }
        }
      }
    }
    TFM_BuilderWorld.getInstance().wipeAccessCache();
  }
  
  public static void saveAll()
  {
    TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, "builder.yml", true);
    config.load();
    
    config.set("clean_threshold_hours", Integer.valueOf(cleanThreshold));
    
    Iterator<Map.Entry<UUID, TFM_Builder>> it = builderList.entrySet().iterator();
    while (it.hasNext())
    {
      Map.Entry<UUID, TFM_Builder> pair = (Map.Entry)it.next();
      
      UUID uuid = (UUID)pair.getKey();
      TFM_Builder builder = (TFM_Builder)pair.getValue();
      
      config.set("builders." + uuid + ".last_login_name", builder.getLastLoginName());
      config.set("builders." + uuid + ".is_activated", Boolean.valueOf(builder.isActivated()));
      config.set("builders." + uuid + ".is_donator_plus", Boolean.valueOf(builder.isBuilderPlus()));
      config.set("builders." + uuid + ".last_login", TFM_Util.dateToString(builder.getLastLogin()));
      config.set("builders." + uuid + ".custom_login_message", builder.getCustomLoginMessage());
      config.set("builders." + uuid + ".console_aliases", TFM_Util.removeDuplicates(builder.getConsoleAliases()));
      config.set("builders." + uuid + ".ips", TFM_Util.removeDuplicates(builder.getIps()));
    }
    config.save();
  }
  
  public static void save(TFM_Builder builder)
  {
    if (!builderList.containsValue(builder))
    {
      TFM_Log.warning("Could not save admin " + builder.getLastLoginName() + ", admin is not loaded!");
      return;
    }
    TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, "builder.yml", true);
    config.load();
    
    UUID uuid = builder.getUniqueId();
    
    config.set("builder." + uuid + ".last_login_name", builder.getLastLoginName());
    config.set("builder." + uuid + ".is_activated", Boolean.valueOf(builder.isActivated()));
    config.set("builder." + uuid + ".is_builder_plus", Boolean.valueOf(builder.isBuilderPlus()));
    config.set("builder." + uuid + ".last_login", TFM_Util.dateToString(builder.getLastLogin()));
    config.set("builder." + uuid + ".custom_login_message", builder.getCustomLoginMessage());
    config.set("builder." + uuid + ".console_aliases", TFM_Util.removeDuplicates(builder.getConsoleAliases()));
    config.set("builder." + uuid + ".ips", TFM_Util.removeDuplicates(builder.getIps()));
    
    config.save();
  }
  
  public static TFM_Builder getEntry(Player player)
  {
    return getEntry(TFM_UuidManager.getUniqueId(player));
  }
  
  public static TFM_Builder getEntry(UUID uuid)
  {
    return (TFM_Builder)builderList.get(uuid);
  }
  
  public static TFM_Builder getEntry(String name)
  {
    for (UUID uuid : builderList.keySet()) {
      if (((TFM_Builder)builderList.get(uuid)).getLastLoginName().equalsIgnoreCase(name)) {
        return (TFM_Builder)builderList.get(uuid);
      }
    }
    return null;
  }
  
  public static TFM_Builder getEntryByIp(String ip)
  {
    return getEntryByIp(ip, false);
  }
  
  public static TFM_Builder getEntryByIp(String needleIp, boolean fuzzy)
  {
    Iterator<Map.Entry<UUID, TFM_Builder>> it = builderList.entrySet().iterator();
    while (it.hasNext())
    {
      Map.Entry<UUID, TFM_Builder> pair = (Map.Entry)it.next();
      TFM_Builder superadmin = (TFM_Builder)pair.getValue();
      if (fuzzy) {
        for (String haystackIp : superadmin.getIps()) {
          if (TFM_Util.fuzzyIpMatch(needleIp, haystackIp, 3)) {
            return superadmin;
          }
        }
      } else if (superadmin.getIps().contains(needleIp)) {
        return superadmin;
      }
    }
    return null;
  }
  
  public static void updateLastLogin(Player player)
  {
    TFM_Builder admin = getEntry(player);
    if (admin == null) {
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
    if (verifySuperadmin) {
      if (!isBuilderPlus(sender)) {
        return false;
      }
    }
    if (!(sender instanceof Player)) {
      return (seniorConsoleNames.contains(sender.getName())) || ((TFM_MainConfig.getBoolean(TFM_ConfigEntry.CONSOLE_IS_SENIOR).booleanValue()) && (sender.getName().equals("CONSOLE")));
    }
    TFM_Builder entry = getEntry((Player)sender);
    if (entry != null) {
      return entry.isBuilderPlus();
    }
    return false;
  }
  
  public static boolean isBuilder(CommandSender sender)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player player = (Player)sender;
    if (builderIps.contains(TFM_Util.getIp(player))) {
      return true;
    }
    if ((Bukkit.getOnlineMode()) && (builderUUIDs.contains(TFM_UuidManager.getUniqueId(player)))) {
      return true;
    }
    return false;
  }
  
  public static boolean isIdentityMatched(Player player)
  {
    if (!isBuilder(player)) {
      return false;
    }
    if (Bukkit.getOnlineMode()) {
      return true;
    }
    TFM_Builder entry = getEntry(player);
    if (entry == null) {
      return false;
    }
    return entry.getUniqueId().equals(TFM_UuidManager.getUniqueId(player));
  }
  
  @Deprecated
  public static boolean checkPartialSuperadminIp(String ip, String name)
  {
    ip = ip.trim();
    if (builderIps.contains(ip)) {
      return true;
    }
    try
    {
      String matchIp = null;
      for (String testIp : builderIps) {
        if (TFM_Util.fuzzyIpMatch(ip, testIp, 3))
        {
          matchIp = testIp;
          break;
        }
      }
      if (matchIp != null)
      {
        TFM_Builder entry = getEntryByIp(matchIp);
        if (entry == null) {
          return true;
        }
        if (entry.getLastLoginName().equalsIgnoreCase(name))
        {
          if (!entry.getIps().contains(ip)) {
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
    if (builderUUIDs.contains(TFM_UuidManager.getUniqueId(player))) {
      return !isBuilder(player);
    }
    return false;
  }
  
  public static void addBuilder(OfflinePlayer player)
  {
    UUID uuid = TFM_UuidManager.getUniqueId(player);
    String ip = TFM_Util.getIp(player);
    boolean canSuperIp = !TFM_MainConfig.getList(TFM_ConfigEntry.NOADMIN_IPS).contains(ip);
    if (builderList.containsKey(uuid))
    {
      TFM_Builder superadmin = (TFM_Builder)builderList.get(uuid);
      superadmin.setActivated(true);
      if (player.isOnline())
      {
        superadmin.setLastLogin(new Date());
        if ((ip != null) && (canSuperIp)) {
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
    TFM_Builder builder = new TFM_Builder(uuid, player.getName(), new Date(), "", false, true);
    
    builder.addIp(ip);
    
    builderList.put(uuid, builder);
    
    saveAll();
    updateIndexLists();
  }
  
  public static void removeBuilder(OfflinePlayer player)
  {
    UUID uuid = TFM_UuidManager.getUniqueId(player);
    if (!builderList.containsKey(uuid))
    {
      TFM_Log.warning("Could not remove builder: " + TFM_Util.formatPlayer(player));
      TFM_Log.warning("Player is not an builder!");
      return;
    }
    TFM_Builder donator = (TFM_Builder)builderList.get(uuid);
    donator.setActivated(false);
    
    saveAll();
    updateIndexLists();
  }
  
  public static void cleanBuilderList(boolean verbose)
  {
    Iterator<Map.Entry<UUID, TFM_Builder>> it = builderList.entrySet().iterator();
    while (it.hasNext())
    {
      Map.Entry<UUID, TFM_Builder> pair = (Map.Entry)it.next();
      TFM_Builder superadmin = (TFM_Builder)pair.getValue();
      if ((superadmin.isActivated()) && (!superadmin.isBuilderPlus()))
      {
        Date lastLogin = superadmin.getLastLogin();
        long lastLoginHours = TimeUnit.HOURS.convert(new Date().getTime() - lastLogin.getTime(), TimeUnit.MILLISECONDS);
        if (lastLoginHours > cleanThreshold)
        {
          if (verbose) {
            TFM_Util.adminAction("TotalFreedomMod", "Deactivating Builder " + superadmin.getLastLoginName() + ", inactive for " + lastLoginHours + " hours.", true);
          }
          superadmin.setActivated(false);
          TFM_TwitterHandler.delTwitter(superadmin.getLastLoginName());
        }
      }
    }
    saveAll();
    updateIndexLists();
  }
}
