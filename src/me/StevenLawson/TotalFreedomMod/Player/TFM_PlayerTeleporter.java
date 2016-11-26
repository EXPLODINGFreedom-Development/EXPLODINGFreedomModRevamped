package me.StevenLawson.TotalFreedomMod.Player;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class TFM_PlayerTeleporter
{
  public static void teleportPlayer(Player player, Location loc)
  {
    Entity passenger = player.getPassenger();
    for (Entity e : player.getNearbyEntities(1.0D, 1.0D, 1.0D)) {
      if ((e.getPassenger() instanceof Player))
      {
        e.setPassenger(null);
        e.teleport(loc);
        player.teleport(loc);
        player.setPassenger(passenger);
        return;
      }
    }
    if (passenger == null)
    {
      player.teleport(loc);
      
      return;
    }
  }
}
