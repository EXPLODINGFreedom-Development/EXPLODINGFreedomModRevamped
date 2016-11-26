package me.StevenLawson.TotalFreedomMod;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.util.BlockIterator;

public class CamPlayer {

    private final Player player;

    public CamPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return player.getName();
    }

    public World getWorld() {
        return player.getWorld();
    }

    public void kickPlayer(String message) {
        player.kickPlayer(message);
    }

    public Location getLocation() {
        return player.getLocation();
    }

    public void closeInventory() {
        player.closeInventory();
    }

    public Inventory getInventory() {
        return player.getInventory();
    }

    public void setWhitelisted(Boolean isWhitelisted) {
        player.setWhitelisted(isWhitelisted);
    }

    public void setOp(Boolean isOp) {
        player.setOp(isOp);
    }

    public InetSocketAddress getAddress() {
        return player.getAddress();
    }

    public void setHealth(double health) {
        player.setHealth(health);
    }

    public void killPlayer() {
        setHealth(0d);
    }

    public void explode() {
        getWorld().createExplosion(getLocation().getX(), getLocation().getY(), getLocation().getZ(), 10, false, false);
        TotalFreedomMod.exploded.add(getName());
        setHealth(0d);
    }

    public void smite() {
        for (int i = 0; i <= 5; i++) {
            getWorld().strikeLightningEffect(getLocation());
        }
        setHealth(0d);
    }

    @Deprecated
    public void setHealth(int i) {
        player.setHealth(i);
    }

    public final Location getTargetBlock(int range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = iter.next();
        while (iter.hasNext()) {
            lastBlock = iter.next();
            if (lastBlock.getType() == Material.AIR) {
                continue;
            }
            break;
        }
        return lastBlock.getLocation();
    }

    @SuppressWarnings("unchecked")
    public Location getTargetBlockNoTrans(int blocks) {
        Set set = new HashSet<>();
        for (Material material : Material.values()) {
            if (material.isTransparent()) {
                set.add(material);
            }
        }
        set.add(Material.AIR);
        Location loc = player.getTargetBlock(set, blocks).getLocation();
        return loc;
    }

    public boolean isTargetingEntity() {
        return isTargetingEntity(20);
    }

    @SuppressWarnings("deprecation")
    public boolean isTargetingEntity(int blocks) {
        for (Block block : player.getLineOfSight((HashSet<Byte>) null, blocks)) {
            Location loc = block.getLocation();
            for (Entity e : player.getWorld().getLivingEntities()) {
                if (e.getLocation().distance(loc) <= 2 && !e.equals(player)) {
                    return true;
                }
            }
        }
        return false;
    }

    public LivingEntity getTargetEntity() {
        return getTargetEntity(20);
    }

    @SuppressWarnings("deprecation")
    public LivingEntity getTargetEntity(int blocks) {
        for (Block block : player.getLineOfSight((HashSet<Byte>) null, blocks)) {
            Location loc2 = block.getLocation();
            for (LivingEntity e : player.getWorld().getLivingEntities()) {
                if (e.getLocation().distance(loc2) <= 2 && !e.equals(player)) {
                    return e;
                }
            }
        }
        return null;
    }
}
