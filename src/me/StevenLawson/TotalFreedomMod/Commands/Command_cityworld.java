package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Commands.*;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.World.TFM_CityWorld;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Goto the Minigameworld!.", usage = "/<command>")
public class Command_cityworld extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (TFM_ConfigEntry.FLATLANDS_GENERATE.getBoolean())
        {
            TFM_CityWorld.getInstance().sendToWorld(sender_p);
            sender.setOp(true);
            sender_p.setGameMode(GameMode.CREATIVE);
        }
        else
        {
            playerMsg("The world is currently disabled.");
        }
        return true;
    }
}
