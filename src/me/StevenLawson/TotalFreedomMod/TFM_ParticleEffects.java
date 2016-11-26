package me.StevenLawson.TotalFreedomMod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

 public enum TFM_ParticleEffects
 {
     HUGE_EXPLODE("hugeexplosion", 0), 
     LARGE_EXPLODE("largeexplode", 1), 
     FIREWORK_SPARK("fireworksSpark", 2), 
     AIR_BUBBLE("bubble", 3), 
     SUSPEND("suspend", 4), 
     DEPTH_SUSPEND("depthSuspend", 5), 
     TOWN_AURA("townaura", 6), 
     CRITICAL_HIT("crit", 7), 
     MAGIC_CRITICAL_HIT("magicCrit", 8), 
     MOB_SPELL("mobSpell", 9), 
     MOB_SPELL_AMBIENT("mobSpellAmbient", 10),
     SPELL("spell", 11), 
     INSTANT_SPELL("instantSpell", 12), 
     BLUE_SPARKLE("witchMagic", 13), 
     NOTE_BLOCK("note", 14), 
     ENDER("portal", 15), 
     ENCHANTMENT_TABLE("enchantmenttable", 16), 
     EXPLODE("explode", 17), 
     FIRE("flame", 18), 
     LAVA_SPARK("lava", 19), 
     FOOTSTEP("footstep", 20), 
     SPLASH("splash", 21), 
     LARGE_SMOKE("largesmoke", 22), 
     CLOUD("cloud", 23), 
     REDSTONE_DUST("reddust", 24), 
     SNOWBALL_HIT("snowballpoof", 25), 
     DRIP_WATER("dripWater", 26), 
     DRIP_LAVA("dripLava", 27), 
     SNOW_DIG("snowshovel", 28), 
     SLIME("slime", 29), 
     HEART("heart", 30), 
     ANGRY_VILLAGER("angryVillager", 31), 
     GREEN_SPARKLE("happyVillager", 32), 
     ICONCRACK("iconcrack", 33), 
     TILECRACK("tilecrack", 34);
   
     private String name;
     private int id;
     private TFM_ParticleEffects(String name, int id)
     {
     this.name = name;
     this.id = id;
     }
    
     String getName()
     {
     return this.name;
         }
   
     int getId()
      {
     return this.id;
         }
     public static void sendToPlayer(TFM_ParticleEffects effect, Player player, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count)
      {
     try
         {
        Object packet = createPacket(effect, location, offsetX, offsetY, offsetZ, speed, count);
          sendPacket(player, packet);
                 }
        catch (Exception e)
        {
             e.printStackTrace();
                   }
        }
   
     public static void sendToLocation(TFM_ParticleEffects effect, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count)
        {
        try
         {
            Object packet = createPacket(effect, location, offsetX, offsetY, offsetZ, speed, count);
             for (Player player : Bukkit.getOnlinePlayers())
            {
                 sendPacket(player, packet);
                          }
                }
         catch (Exception e)
        {
            e.printStackTrace();
                   }
          }
    
     private static Object createPacket(TFM_ParticleEffects effect, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count)
     throws Exception
          {
         if (count <= 0)
        {
             count = 1;
                   }
        Class<?> packetClass = getCraftClass("PacketPlayOutWorldParticles");
        
        Object packet = packetClass.getConstructor(new Class[]
        {
            String.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Integer.TYPE
        }).newInstance(new Object[]
        {
            effect.name, Float.valueOf((float) location.getX()),
             Float.valueOf((float) location.getY()), Float.valueOf((float) location.getZ()), Float.valueOf(offsetX), Float.valueOf(offsetY), Float.valueOf(offsetZ), Float.valueOf(speed), Integer.valueOf(count)
        });
         return packet;
          }
    
     private static void sendPacket(Player p, Object packet)
             throws Exception
         {
        Object eplayer = getHandle(p);
        Field playerConnectionField = eplayer.getClass().getField("playerConnection");
        Object playerConnection = playerConnectionField.get(eplayer);
        for (Method m : playerConnection.getClass().getMethods())
        {
             if (m.getName().equalsIgnoreCase("sendPacket"))
            {
                m.invoke(playerConnection, new Object[]
                {
                    packet
                });
                 return;
                         }
                    }
         }
    
      private static Object getHandle(Entity entity)
    {
         try
         {
             Method entity_getHandle = entity.getClass().getMethod("getHandle", new Class[0]);
             return entity_getHandle.invoke(entity, new Object[0]);
                 }
     catch (Exception ex)
        {
           ex.printStackTrace();
                 }
        return null;
          }
    
   private static Class<?> getCraftClass(String name)
    {
         String version = getVersion() + ".";
         String className = "net.minecraft.server." + version + name;
         Class<?> clazz = null;
        try
        {
            clazz = Class.forName(className);
                   }
         catch (ClassNotFoundException e)
        {
             e.printStackTrace();
                   }
        return clazz;
            }
 
        private static String getVersion()
    {
        return Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
       }
    }
