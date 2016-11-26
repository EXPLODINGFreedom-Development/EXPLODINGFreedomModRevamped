package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.SUPER, source=SourceType.BOTH)
@CommandParameters(description="Displays a text unicorn is everyone's chat!", usage="/<command>")
public class Command_unicorn
  extends TFM_Command
{
  @Override
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    for (Player player : this.server.getOnlinePlayers()) {
      player.playSound(player.getLocation(), Sound.FIREWORK_TWINKLE, 1.0F, 1.0F);
    }
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                                                         ,/");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                                                        //");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                                                      ,//");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                                          ___   /|   |//");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                                      `__/\\_ --(/|___/-/");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                                   \\|\\_-\\___ __-_`- /-/ \\.");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                                  |\\_-___,-\\_____--/_)' ) \\");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                                   \\ -_ /     __ \\( `( __`\\|");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                                   `\\__|      |\\)\\ ) /(/|");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "           ,._____.,            ',--//-|      \\  |  '   /");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "          /     __. \\,          / /,---|       \\       /");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "        |  | ( (  \\   |      ,/\\'__/'/          |     |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "        |  \\  \\`--, `_/_------______/           \\(   )/");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "        | | \\  \\_. \\,                            \\___/\\");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "        | |  \\_   \\  \\                                 \\");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "        \\ \\    \\_ \\   \\   /                             \\");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "         \\ \\  \\._  \\__ \\_|       |                       \\");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "          \\ \\___  \\      \\       |                        \\");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "           \\__ \\__ \\  \\_ |       \\                         |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "           |  \\_____ \\  ____      |                           |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "           | \\  \\__ ---' .__\\     |        |                 |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "           \\  \\__ ---   /   )     |        \\                /");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "            \\   \\____/ / ()(      \\          `---_         /|");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "             \\__________/(,--__    \\_________.    |       ./ |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "               |     \\ \\  `---_\\--,           \\   \\_,./   |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "               |      \\  \\_ ` \\    /`---_______-\\   \\\\    /");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                \\      \\.___,`|   /              \\   \\\\   \\");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                 \\     |  \\_ \\|   \\              (   |:    |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                  \\    \\      \\    |             /  / |    ;");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                   \\    \\      \\    \\          ( `_'   \\  |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                    \\.   \\      \\.   \\          `__/   |  |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                      \\   \\       \\.  \\                |  |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                       \\   \\        \\  \\               (  )");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                        \\   |        \\  |                |  |");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                         |  \\         \\ \\               I  `");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                         ( __;        ( _;                ('-_';");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "                         |___\\       \\___:              \\___:");
    
    TFM_Util.bcastMsg("   ");
    TFM_Util.bcastMsg("   ");
    TFM_Util.bcastMsg(TFM_Util.randomChatColor() + "You have been unicorned by - " + sender.getName());
    
    return false;
  }
}
