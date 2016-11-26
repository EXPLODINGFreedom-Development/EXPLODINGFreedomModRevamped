package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.World.TFM_SeniorWorld;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Go to the SeniorAdminWorld.", usage = "/<command> [guest < list | purge | add <player> | remove <player> > | time <morning | noon | evening | night> | weather <off | on | storm>]")
public class Command_seniorworld extends TFM_Command
{
    private enum CommandMode
    {
        TELEPORT, GUEST, TIME, WEATHER;
    }

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        CommandMode commandMode = null;

        if (args.length == 0)
        {
            commandMode = CommandMode.TELEPORT;
        }
        else if (args.length >= 2)
        {
            if ("guest".equalsIgnoreCase(args[0]))
            {
                commandMode = CommandMode.GUEST;
            }
            else if ("time".equalsIgnoreCase(args[0]))
            {
                commandMode = CommandMode.TIME;
            }
            else if ("weather".equalsIgnoreCase(args[0]))
            {
                commandMode = CommandMode.WEATHER;
            }
        }

        if (commandMode == null)
        {
            return false;
        }

        try
        {
            switch (commandMode)
            {
                case TELEPORT:
                {
                    if (!(sender instanceof Player) || sender_p == null)
                    {
                        return true;
                    }

                    World seniorWorld = null;
                    try
                    {
                        seniorWorld = TFM_SeniorWorld.getInstance().getWorld();
                    }
                    catch (Exception ex)
                    {
                    }

                    if (seniorWorld == null || sender_p.getWorld() == seniorWorld)
                    {
                        playerMsg("Going to the main world.");
                        sender_p.teleport(server.getWorlds().get(0).getSpawnLocation());
                    }
                    else
                    {
                        if (TFM_SeniorWorld.getInstance().canAccessWorld(sender_p))
                        {
                            playerMsg("Going to the SeniorWorld.");
                            TFM_SeniorWorld.getInstance().sendToWorld(sender_p);
                        }
                        else
                        {
                            playerMsg("You don't have permission to access the SeniorWorld.");
                        }
                    }

                    break;
                }
                case GUEST:
                {
                    if (args.length == 2)
                    {
                        if ("list".equalsIgnoreCase(args[1]))
                        {
                            playerMsg("SeniorWorld guest list: " + TFM_SeniorWorld.getInstance().guestListToString());
                        }
                        else if ("purge".equalsIgnoreCase(args[1]))
                        {
                            assertCommandPerms(sender, sender_p);
                            TFM_SeniorWorld.getInstance().purgeGuestList();
                            TFM_Util.adminAction(sender.getName(), "SeniorWorld guest list purged.", false);
                        }
                        else
                        {
                            return false;
                        }
                    }
                    else if (args.length == 3)
                    {
                        assertCommandPerms(sender, sender_p);

                        if ("add".equalsIgnoreCase(args[1]))
                        {
                            final Player player = getPlayer(args[2]);

                            if (player == null)
                            {
                                sender.sendMessage(TFM_Command.PLAYER_NOT_FOUND);
                                return true;
                            }

                            if (TFM_SeniorWorld.getInstance().addGuest(player, sender_p))
                            {
                                TFM_Util.adminAction(sender.getName(), "SeniorWorld guest added: " + player.getName(), false);
                            }
                            else
                            {
                                playerMsg("Could not add player to guest list.");
                            }
                        }
                        else if ("remove".equals(args[1]))
                        {
                            final Player player = TFM_SeniorWorld.getInstance().removeGuest(args[2]);
                            if (player != null)
                            {
                                TFM_Util.adminAction(sender.getName(), "SeniorWorld guest removed: " + player.getName(), false);
                            }
                            else
                            {
                                playerMsg("Can't find guest entry for: " + args[2]);
                            }
                        }
                        else
                        {
                            return false;
                        }
                    }

                    break;
                }
                case TIME:
                {
                    assertCommandPerms(sender, sender_p);

                    if (args.length == 2)
                    {
                        TFM_SeniorWorld.TimeOfDay timeOfDay = TFM_SeniorWorld.TimeOfDay.getByAlias(args[1]);
                        if (timeOfDay != null)
                        {
                            TFM_SeniorWorld.getInstance().setTimeOfDay(timeOfDay);
                            playerMsg("SeniorWorld time set to: " + timeOfDay.name());
                        }
                        else
                        {
                            playerMsg("Invalid time of day. Can be: sunrise, noon, sunset, midnight");
                        }
                    }
                    else
                    {
                        return false;
                    }

                    break;
                }
                case WEATHER:
                {
                    assertCommandPerms(sender, sender_p);

                    if (args.length == 2)
                    {
                        TFM_SeniorWorld.WeatherMode weatherMode = TFM_SeniorWorld.WeatherMode.getByAlias(args[1]);
                        if (weatherMode != null)
                        {
                            TFM_SeniorWorld.getInstance().setWeatherMode(weatherMode);
                            playerMsg("SeniorWorld weather set to: " + weatherMode.name());
                        }
                        else
                        {
                            playerMsg("Invalid weather mode. Can be: off, rain, storm");
                        }
                    }
                    else
                    {
                        return false;
                    }

                    break;
                }
                default:
                {
                    return false;
                }
            }
        }
        catch (PermissionDeniedException ex)
        {
            sender.sendMessage(ex.getMessage());
        }

        return true;
    }

    private void assertCommandPerms(CommandSender sender, Player sender_p) throws PermissionDeniedException
    {
        if (!(sender instanceof Player) || sender_p == null || !TFM_AdminList.isSeniorAdmin(sender))
        {
            throw new PermissionDeniedException(TFM_Command.MSG_NO_PERMS);
        }
    }

    private class PermissionDeniedException extends Exception
    {
        private static final long serialVersionUID = 1L;

        private PermissionDeniedException(String string)
        {
            super(string);
        }
    }
}
