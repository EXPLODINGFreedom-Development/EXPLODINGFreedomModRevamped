package me.StevenLawson.TotalFreedomMod;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_Util;
import me.StevenLawson.TotalFreedomMod.TFM_BuilderList;
import com.google.common.base.Function;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import me.StevenLawson.TotalFreedomMod.Bridge.TFM_WorldEditListener;
import me.StevenLawson.TotalFreedomMod.Commands.TFM_Command;
import me.StevenLawson.TotalFreedomMod.Commands.TFM_CommandHandler;
import me.StevenLawson.TotalFreedomMod.Commands.TFM_CommandLoader;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.HTTPD.TFM_HTTPD_Manager;
import me.StevenLawson.TotalFreedomMod.Listener.TFM_BlockListener;
import me.StevenLawson.TotalFreedomMod.Listener.TFM_EntityListener;
import me.StevenLawson.TotalFreedomMod.Listener.TFM_PlayerListener;
import me.StevenLawson.TotalFreedomMod.Listener.TFM_ServerListener;
import me.StevenLawson.TotalFreedomMod.Listener.TFM_WeatherListener;
import me.StevenLawson.TotalFreedomMod.World.TFM_AdminWorld;
import me.StevenLawson.TotalFreedomMod.World.TFM_Flatlands;
import net.camtech.verification.SocketServer;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.mcstats.Metrics;

public class TotalFreedomMod
  extends JavaPlugin
{
  public static String DHAMMER_MODE;
  public static String MSG_NO_PERMS;
  public static String PLAYER_NOT_FOUND;
  public static String NUBCAKE;
  public static String YOU_ARE_OP;
  public static int nukeMonitorCountBreak;
  public static boolean nukeMonitor;
  public static double nukeMonitorRange;
  private SocketServer socketServer = new SocketServer();
  private Thread thread;
  public static final long HEARTBEAT_RATE = 5L;
  public static final long SERVICE_CHECKER_RATE = 120L;
  public static final int MAX_USERNAME_LENGTH = 20;
  public static final String CONFIG_FILENAME = "config.yml";
  public static final String RULES_FILENAME = "rules.yml";
  public static final String SUPERADMIN_FILENAME = "superadmin.yml";
  public static final String BUILDER_FILENAME = "builder.yml";
  public static final String PERMBAN_FILENAME = "permban.yml";
  public static final String UUID_FILENAME = "uuids.db";
  public static final String PROTECTED_AREA_FILENAME = "protectedareas.dat";
  public static final String SAVED_FLAGS_FILENAME = "savedflags.dat";
  public static List<String> exploded = new ArrayList();
  @Deprecated
  public static final String YOU_ARE_NOT_OP = TFM_Command.YOU_ARE_NOT_OP;
  public static String buildNumber = "1";
  public static String buildDate = buildDate = TFM_Util.dateToString(new Date());
  public static String buildCreator = "DarkGamingDronze";
  public static Server server;
  public static TotalFreedomMod plugin;
  public static String pluginName;
  public static String pluginVersion;
  public static boolean lockdownEnabled = false;
  public static Map<Player, Double> fuckoffEnabledFor = new HashMap();
    public EFMR_Util util;
  
  public void onLoad()
  {
    plugin = this;
    server = plugin.getServer();
    pluginName = plugin.getDescription().getName();
    pluginVersion = plugin.getDescription().getVersion();
    
    TFM_Log.setPluginLogger(plugin.getLogger());
    TFM_Log.setServerLogger(server.getLogger());
    
    setAppProperties();
  }
  
  public void onEnable()
  {
    TFM_Log.info("TotalFreedomMod by Madgeek1450 and Prozza");
    TFM_Log.info("Compiled " + buildDate + " by " + buildCreator);
    TFM_Log.info("EXPLODINGFreedomMod:Revamped by Alco_Rs11");
    
    TFM_Util.MethodTimer timer = new TFM_Util.MethodTimer();
    timer.start();
    if (!"v1_8_R3".equals(TFM_Util.getNmsVersion()))
    {
      TFM_Log.warning(
        pluginName + " is compiled for " + "v1_8_R3" + " but the server is running " + "version " + TFM_Util.getNmsVersion() + "!");
      TFM_Log.warning("This might result in unexpected behaviour!");
    }
    TFM_Util.deleteCoreDumps();
    TFM_Util.deleteFolder(new File("./_deleteme"));
    
    TFM_Util.createBackups("config.yml", true);
    TFM_Util.createBackups("superadmin.yml");
    TFM_Util.createBackups("permban.yml");
    TFM_Util.createBackups("builder.yml");
    
    TFM_UuidManager.load();
    TFM_AdminList.load();
    TFM_PermbanList.load();
    TFM_PlayerList.load();
    TFM_BanManager.load();
    TFM_Announcer.load();
    TFM_ProtectedArea.load();
    
    server.getServicesManager().register(Function.class, TFM_AdminList.SUPERADMIN_SERVICE, plugin, ServicePriority.Normal);
    server.getServicesManager().register(Function.class, TFM_BuilderList.BUILDER_SERVICE, plugin, ServicePriority.Normal);
    
     PluginManager pm = server.getPluginManager();
    pm.registerEvents(new TFM_EntityListener(), plugin);
    pm.registerEvents(new TFM_BlockListener(), plugin);
    pm.registerEvents(new TFM_PlayerListener(), plugin);
    pm.registerEvents(new TFM_WeatherListener(), plugin);
    pm.registerEvents(new TFM_ServerListener(), plugin);
    
    pm.registerEvents(new TFM_WorldEditListener(), plugin);
    try
    {
      TFM_Flatlands.getInstance().getWorld();
    }
    catch (Exception ex)
    {
      TFM_Log.warning("Could not load world: Flatlands");
    }
    try
    {
      TFM_AdminWorld.getInstance().getWorld();
    }
    catch (Exception ex)
    {
      TFM_Log.warning("Could not load world: AdminWorld");
    }
    TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.DO_DAYLIGHT_CYCLE, !TFM_ConfigEntry.DISABLE_NIGHT.getBoolean().booleanValue(), false);
    TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.DO_FIRE_TICK, TFM_ConfigEntry.ALLOW_FIRE_SPREAD.getBoolean().booleanValue(), false);
    TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.DO_MOB_LOOT, false, false);
    TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.DO_MOB_SPAWNING, !TFM_ConfigEntry.MOB_LIMITER_ENABLED.getBoolean().booleanValue(), false);
    TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.DO_TILE_DROPS, false, false);
    TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.MOB_GRIEFING, false, false);
    TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.NATURAL_REGENERATION, true, false);
    TFM_GameRuleHandler.commitGameRules();
    if (TFM_ConfigEntry.DISABLE_WEATHER.getBoolean().booleanValue()) {
      for (World world : server.getWorlds())
      {
        world.setThundering(false);
        world.setStorm(false);
        world.setThunderDuration(0);
        world.setWeatherDuration(0);
      }
    }
    new TFM_Heartbeat(plugin).runTaskTimer(plugin, 100L, 100L);
    
    TFM_ServiceChecker.start();
    TFM_HTTPD_Manager.start();
    TFM_CommandBlocker.load();
    
    timer.update();
    
    TFM_Log.info("Version " + pluginVersion + " for " + "v1_8_R3" + " enabled in " + timer.getTotal() + "ms");
    try
    {
      Metrics metrics = new Metrics(plugin);
      metrics.start();
    }
    catch (IOException ex)
    {
      TFM_Log.warning("Failed to submit metrics data: " + ex.getMessage());
    }
    new BukkitRunnable()
    {
      public void run()
      {
        TFM_CommandLoader.scan();
        
        TFM_ProtectedArea.autoAddSpawnpoints();
      }
    }
    
      .runTaskLater(plugin, 20L);
    this.thread = new Thread(this.socketServer);
    this.thread.start();
  }
  
  public void onDisable()
  {
    TFM_HTTPD_Manager.stop();
    TFM_BanManager.save();
    TFM_UuidManager.close();
    try
    {
      this.socketServer.sock.close();
    }
    catch (IOException ex)
    {
      TFM_Log.severe(ex.getMessage());
    }
    server.getScheduler().cancelTasks(plugin);
    
    TFM_Log.info("Plugin disabled");
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    return TFM_CommandHandler.handleCommand(sender, cmd, commandLabel, args);
  }
  
  private static void setAppProperties()
  {
    try
    {
      InputStream in = plugin.getResource("appinfo.properties");
      Properties props = new Properties();
      
      props.load(in);
      in.close();
      
      buildNumber = props.getProperty("program.buildnumber");
      buildDate = props.getProperty("program.builddate");
      buildCreator = props.getProperty("program.buildcreator");
    }
    catch (Exception ex)
    {
      TFM_Log.severe("Could not load App properties!");
      TFM_Log.severe(ex);
    }
  }
}
