package me.StevenLawson.TotalFreedomMod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.Config.TFM_MainConfig;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.configuration.ConfigurationSection;

public class TFM_Admin
{
  private final UUID uuid;
  private String lastLoginName;
  private String loginMessage;
  private String verifyPassword;
  private final boolean isSeniorAdmin;
  private final boolean isTelnetAdmin;
  private final List<String> consoleAliases;
  private final List<String> ips;
  private Date lastLogin;
  private boolean isActivated;
  
  public TFM_Admin(UUID uuid, String lastLoginName, Date lastLogin, String loginMessage, String verifyPassword, boolean isTelnetAdmin, boolean isSeniorAdmin, boolean isActivated)
  {
    this.uuid = uuid;
    this.lastLoginName = lastLoginName;
    this.ips = new ArrayList();
    this.lastLogin = lastLogin;
    this.loginMessage = loginMessage;
    this.isTelnetAdmin = isTelnetAdmin;
    this.isSeniorAdmin = isSeniorAdmin;
    this.consoleAliases = new ArrayList();
    this.isActivated = isActivated;
  }
  
  public TFM_Admin(UUID uuid, ConfigurationSection section)
  {
    this.uuid = uuid;
    this.lastLoginName = section.getString("last_login_name");
    this.ips = section.getStringList("ips");
    this.lastLogin = TFM_Util.stringToDate(section.getString("last_login", TFM_Util.dateToString(new Date(0L))));
    this.loginMessage = section.getString("custom_login_message", "");
    this.isSeniorAdmin = section.getBoolean("is_senior_admin", false);
    this.isTelnetAdmin = section.getBoolean("is_telnet_admin", false);
    this.consoleAliases = section.getStringList("console_aliases");
    this.isActivated = section.getBoolean("is_activated", true);
    for (Iterator<?> it = TFM_MainConfig.getList(TFM_ConfigEntry.NOADMIN_IPS).iterator(); it.hasNext();) {
      this.ips.remove((String)it.next());
    }
  }
  
  public String toString()
  {
    StringBuilder output = new StringBuilder();
    
    output.append("UUID: ").append(this.uuid.toString()).append("\n");
    output.append("- Last Login Name: ").append(this.lastLoginName).append("\n");
    output.append("- IPs: ").append(StringUtils.join(this.ips, ", ")).append("\n");
    output.append("- Last Login: ").append(TFM_Util.dateToString(this.lastLogin)).append("\n");
    output.append("- Custom Login Message: ").append(this.loginMessage).append("\n");
    output.append("- Is Senior Admin: ").append(this.isSeniorAdmin).append("\n");
    output.append("- Is Telnet Admin: ").append(this.isTelnetAdmin).append("\n");
    output.append("- Console Aliases: ").append(StringUtils.join(this.consoleAliases, ", ")).append("\n");
    output.append("- Is Activated: ").append(this.isActivated);
    
    return output.toString();
  }
  
  public UUID getUniqueId()
  {
    return this.uuid;
  }
  
  public void setLastLoginName(String lastLoginName)
  {
    this.lastLoginName = lastLoginName;
  }
  
  public String getLastLoginName()
  {
    return this.lastLoginName;
  }
  
  public List<String> getIps()
  {
    return Collections.unmodifiableList(this.ips);
  }
  
  public void addIp(String ip)
  {
    if (!this.ips.contains(ip)) {
      this.ips.add(ip);
    }
  }
  
  public void addIps(List<String> ips)
  {
    for (String ip : ips) {
      addIp(ip);
    }
  }
  
  public void removeIp(String ip)
  {
    if (this.ips.contains(ip)) {
      this.ips.remove(ip);
    }
  }
  
  public void clearIPs()
  {
    this.ips.clear();
  }
  
  public Date getLastLogin()
  {
    return this.lastLogin;
  }
  
  public String getVerifyPassword() {
        return verifyPassword;
    }
    
    public String setVerifyPassword(String verifyPassword) {
        return this.verifyPassword = verifyPassword;
    }
  
  public String getCustomLoginMessage()
  {
    return this.loginMessage;
  }
  public String setCustomLoginMessage(String loginMessage)
  {
    return this.loginMessage;
  }
  
  public boolean isSeniorAdmin()
  {
    return this.isSeniorAdmin;
  }
  
  public boolean isTelnetAdmin()
  {
    return this.isTelnetAdmin;
  }
  
  public List<String> getConsoleAliases()
  {
    return Collections.unmodifiableList(this.consoleAliases);
  }
  
  public void setLastLogin(Date lastLogin)
  {
    this.lastLogin = lastLogin;
  }
  
  public boolean isActivated()
  {
    return this.isActivated;
  }
  
  public void setActivated(boolean isActivated)
  {
    this.isActivated = isActivated;
  }

        }
