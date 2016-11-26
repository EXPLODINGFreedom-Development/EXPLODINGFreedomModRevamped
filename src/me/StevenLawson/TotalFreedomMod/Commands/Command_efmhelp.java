package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
This is the ExplodingManage command. if you obtain the source code DO NOT remove this class or modify it.
Its here for the bad people that decide to rename the plugin and pass it as there own. Similar to the TFM_FrontDoor
This requires BarAPI for the project to compile
If you're wondering what this class exactly does I've noted it with the '//'s
The your wondering what (mode.equals("")) does it defines what you have to say for the command to go through.
*/

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH) // Defines permissions
@CommandParameters(
        description = "Chat Levels", //Description
        aliases = "efh",
        usage = "/<command> [1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22]") //Usage
public class Command_efmhelp extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole){
   {
                   } 
        if (args.length == 0)
        {
            return false;
        }

        String mode = args[0].toLowerCase();

        if (mode.equals("1")) 
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c1§e----");
         playerMsg("§6/admininfo§f: Find out how to apply for SA");
         playerMsg("§6/adminme§f: Fool the stupid ones");
         playerMsg("§6/adminmode§f: Make the server admin-only");
         playerMsg("§6/adminworld§f: Teleport to the adminworld");
         playerMsg("§6/adventure§f: Go into adventure mode");
         playerMsg("§6/afk§f: Marks you as AFK");
         playerMsg("§6/ai§f: Find out how to apply for SA");
         playerMsg("§6/bar§f: BarAPI Command");	
         playerMsg("§6/blockcmd§f: Block specified user's commands");	
         playerMsg("§6/broadcast§f: Broadcast a message");
         playerMsg("§6/builderworld§f: Access the builder world");	
        }
        
        if (mode.equals("2"))
        {
        playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c2§e----");
         playerMsg("§6/busy§f: Tells everyone you are busy");
         playerMsg("§6/cage§f: Encase a user in a cube made out of a specified block");
         playerMsg("§6/cake§f: Give everyone a cake");
         playerMsg("§6/cartsit§f: Sit in the nearest minecart");
         playerMsg("§6/cbtool§f:No description. ");
         playerMsg("§6/cc§f: Clear the chat");
         playerMsg("§6/chatlevel§f: Access the different adminchat types");	
         playerMsg("§6/cleanup§f: Purges everything and reloads the server");	
         playerMsg("§6/clearchat§f: Clear the chat");	
        }
        
        if (mode.equals("3"))
        {
        playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c3§e----");
         playerMsg("§6/cmdlist§f: Show all commands");
         playerMsg("§6/cmdspy§f: Displays all operator commands");
         playerMsg("§6/colorme§f: Give yourself a color");
         playerMsg("§6/cookie§f: Give everyone a cookie");
         playerMsg("§6/creative§f: Change your gamemode to creative");
         playerMsg("§6/csay§f: Send a chat message with chat formatting over telnet");
         playerMsg("§6/cy§f: Clear your chat");	
         playerMsg("§6/deafen§f: Make some noise");	
         playerMsg("§6/debug§f: debug the server");		
        }
        
        if (mode.equals("4"))
        {
       playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c4§e----");
         playerMsg("§6/denick§f: Remove your nickname or all nicknames");
         playerMsg("§6/deop§f: Remove someone's Operator Status");
         playerMsg("§6/deopall§f: Remove everyone's Operator Status");
         playerMsg("§6/deopme§f: Remove your Operator Status");
         playerMsg("§6/dispfill§f: Fill a dispenser with a selected item of your choice");
         playerMsg("§6/djump§f: Enable double jump mode");
         playerMsg("§6/doom§f: Used to ban rouge admins.");	
         playerMsg("§6/efhelp§f: Information about EXPLODINGFreedom");	
         playerMsg("§6/efm§f: Information about the EXPLODINGFreedomMod or reloads it");		
        }
          if (mode.equals("5"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c5§e----");
         playerMsg("§6/efmanage§f: Personal command for owner that has management features");
         playerMsg("§6/efmhelp§f: List of EXPLODINGFreedomMod Commands");
         playerMsg("§6/efmupdate§f: Updates server files");
         playerMsg("§6/emf§f: Tells specified user to use english");
         playerMsg("§6/enchant§f: Enchants tools/weapons");
         playerMsg("§6/ender§f: Go to the end");
         playerMsg("§6/execchat§f: Executive Chat");	
         playerMsg("§6/expel§f: Pushes players away");	
         playerMsg("§6/explode§f: Explode yourself");
        }
          if (mode.equals("6"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c6§e----");
         playerMsg("§6/fakesa§f: Fools stupid players into thinking you admin'd them. ");
         playerMsg("§6/fc§f: Forces someone to say a chat message, that you entered");
         playerMsg("§6/findip§f: Finds a specifed user's IP Address");
         playerMsg("§6/flatlands§f: Go to the flatlands");
         playerMsg("§6/fr§f: Freezes a player or freezes all players");
         playerMsg("§6/fuckoff§f: Automatically pushes players away from you in a set radius ");
         playerMsg("§6/gadmin§f: Runs admin commands by user hash ");	
         playerMsg("§6/gcmd§f: Makes someone run a command that you entered");	
         playerMsg("§6/glist§f: Unbans and Bans offline players");
        }
          if (mode.equals("7"))     
         {      
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c7§e----");
         playerMsg("§6/gold§f: Used to tell sky fans the truth ");
         playerMsg("§6/gtfo§f: Bans a player by username and IP Address");
         playerMsg("§6/health§f: Find server's TPS and Tick rate ");
         playerMsg("§6/helpout§f: Helper Command - OPs all players");
         playerMsg("§6/imposter§f: Bans impostors");
         playerMsg("§6/invis§f: Find out who's invis or smite them ");
         playerMsg("§6/jumppads§f: Toggle wool trampolines ");	
         playerMsg("§6/lastcmd§f: Runs your last executed command ");	
         playerMsg("§6/launch§f: Launches a player into the air");
         }
            if (mode.equals("8"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c8§e----");
         playerMsg("§6/list§f: List all Online Players ");
         playerMsg("§6/localspawn§f: Teleport to the world's spawn");
         playerMsg("§6/lockdown§f: Enable server lockdown");
         playerMsg("§6/lockup§f: Most evil command ever made");
         playerMsg("§6/logs§f: Connects you to server logviewer");
         playerMsg("§6/lore§f: Add lore to your items ");
         playerMsg("§6/manuadd§f: Tells the stupid ones that we use a custom permission plugin ");	
         playerMsg("§6/mgworld§f: Go to the minigames world ");	
         playerMsg("§6/moblimiter§f: Set a limit for the amount of spawned mobs");
         return true;
        }
     if (mode.equals("9"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c9§e----");
         playerMsg("§6/motd§f: View the message of the day ");
         playerMsg("§6/mp§f: Purge all mobs ");
         playerMsg("§6/mp44§f: Gives you a machine gun ");
         playerMsg("§6/multirun§f: Run a command in a set amount of times");
         playerMsg("§6/nether§f: Go to the nether");
         playerMsg("§6/nf§f: Clean nicknames of banned characters");
         playerMsg("§6/nickclean§f: Clean nicknames of banned characters ");
         playerMsg("§6/nicknyan§f: Give yourself a rainbow nickname ");	
         playerMsg("§6/nonuke§f: Sets a limit that bans you if you break a certain amount of blocks quickly ");	
         playerMsg("§6/nubcake§f: Nubcakes; Kills you with the message: User Is a Nubcake");
         return true;
        }
     if (mode.equals("10"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c10§e----");
         playerMsg("§6/o§f: Adminchat ");
         playerMsg("§6/onlinemode§f: Makes server admin only ");
         playerMsg("§6/op§f: Gives a player Operator status ");
         playerMsg("§6/opall§f: Gives all players Operator status");
         playerMsg("§6/opitems§f: Gives you OP Items");
         playerMsg("§6/opme§f: Give yourself Operator Status ");
         playerMsg("§6/ops§f: List or clear OPs "); 
         playerMsg("§6/overlord§f: Control the server ingame ");	
         playerMsg("§6/ownerchat§f: Owner chat ");	
         playerMsg("§6/p§f: Senior Admin Chat");
         return true;
        }       
     if (mode.equals("11"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c11§e----");
         playerMsg("§6/pcc§f: Clear personal chat ");
         playerMsg("§6/permban§f: View Permban or reload it ");
         playerMsg("§6/personalclearchat§f: Clear personal chat ");
         playerMsg("§6/pex§f: Tells user that we use a custom permission system");
         playerMsg("§6/ping§f: Fools the stupid ones");
         playerMsg("§6/plugincontrol§f: Disable/enable plugins ");
         playerMsg("§6/potion§f: Give yourself potion effects ");	
         playerMsg("§6/premium§f: Check to see if someone's account is legit or cracked ");	
         playerMsg("§6/protectarea§f: Protect a area from OPs building on it");
         return true;
        }       
     if (mode.equals("12"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c12§e----");
         playerMsg("§6/purgeall§f: Purge playerdata");
         playerMsg("§6/purgeban§f: Purge bans");
         playerMsg("§6/qop§f: Quickly OP Someone ");
         playerMsg("§6/qdeop§f: Quickly DeOP someone");
         playerMsg("§6/radar§f: Show's who's near you");
         playerMsg("§6/ragemode§f: Tells the stupid ones to shut up");
         playerMsg("§6/rank§f: Tells you someone's rank");	
         playerMsg("§6/rawsay§f: Broadcasts a message ");	
         playerMsg("§6/rd§f: Remove all entities");
         return true;
        }       
     if (mode.equals("13"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c13§e----");
         playerMsg("§6/recommend§f: Recommend someone for admin");
         playerMsg("§6/rekt§f: Kill a OP, the MLG Style");
         playerMsg("§6/removelagg§f: removes server lag ");
         playerMsg("§6/rename§f: Rename a item");
         playerMsg("§6/ro§f: Remove blocks in a certain radius");
         playerMsg("§6/rollback§f: Rollback a player's block edits");
         playerMsg("§6/saconfig§f: Add or remove someone from the superadmin list ");	
         playerMsg("§6/samanagement§f: Add or remove someone from the superadmin list ");	
         playerMsg("§6/say§f: Broadcasts the given message as the console, includes sender name");
         return true;
        }       
     if (mode.equals("14"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c14§e----");
         playerMsg("§6/seniorworld§f: Go to the senior world");
         playerMsg("§6/server§f: Alco_Rs11 server management command");
         playerMsg("§6/serverclean§f: Runs the cleanup system");
         playerMsg("§6/serveremg§f: Something experimental ");
         playerMsg("§6/serverhealth§f: Shows status of the server");
         playerMsg("§6/servers§f: Something experimental");
         playerMsg("§6/services§f: Shows mojang server status");
         playerMsg("§6/setl§f: Sets worldedit block limits ");	
         playerMsg("§6/setlevel§f: Sets worldedit block limits ");	
         return true;
        } 
     if (mode.equals("15"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c15§e----");
         playerMsg("§6/setlever§f: Set the on/off state of the lever at position x, y, z in world 'worldname'");
         playerMsg("§6/setspawnworld§f: Set a world's spawnpoint");
         playerMsg("§6/sh§f: View ticks-per-second ");
         playerMsg("§6/silentsetl§f: Silently set worldedit limit");
         playerMsg("§6/smite§f: Kills a player and hits them with lightning. Used as a punishment for minor offense");
         playerMsg("§6/snowball§f: Rollback a player's block edits");
         playerMsg("§6/space§f: Launches a player ");	
         playerMsg("§6/specexecchat§f: Special-Executive Chat");	
         playerMsg("§6/sraban§f: Ban command for senior admins");
         return true;
        }       
     if (mode.equals("16"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c16§e----");
         playerMsg("§6/staffafk§f: Marks you as AFK");
         playerMsg("§6/status§f: misc. server stuff ");
         playerMsg("§6/stfu§f: Mutes someone ");
         playerMsg("§6/stop§f: stops the server");
         playerMsg("§6/superdoom§f: More evil doom");
         playerMsg("§6/superfireykick§f: Kick a nub in the face");
         playerMsg("§6/supernubcake§f: For big nubcakes ");	
         playerMsg("§6/superwarn§f: Warn a OP to shape up or else.");	
         playerMsg("§6/survival§f: Change your gamemode to survival");
         return true;
        }       
     if (mode.equals("17"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c17§e----");
         playerMsg("§6/suuperduum§f: Evil Doom");
         playerMsg("§6/sys§f: System-Admin Management Command ");
         playerMsg("§6/sysban§f: System-Admin ban command ");
         playerMsg("§6/syschat§f: System-Admin Chat");
         playerMsg("§6/tag§f: Give yourself a prefix");
         playerMsg("§6/tagnyan§f: Give yourself a rainbow prefix");
         playerMsg("§6/tban§f: Tempban someone ");	
         playerMsg("§6/telnetchat§f: Telnet Admin Chat");	
         playerMsg("§6/tempban§f: Tempban someone");
         return true;
        }   
     if (mode.equals("18"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c18§e----");
         playerMsg("§6/tfbanlist§f: View the Banlist");
         playerMsg("§6/tfipbanlist§f: View the IP Banlist ");
         playerMsg("§6/tfm§f: Information about the TotalFreedomMod or reload it ");
         playerMsg("§6/tfupdate§f: Update server files");
         playerMsg("§6/toggle§f: Enable/Disable misc. features");
         playerMsg("§6/tossmob§f: Toss mobs around");
         playerMsg("§6/trail§f: Make a colorful trail of wool ");	
         playerMsg("§6/trainingmode§f: Puts adminmode on for training of new admins ");	
         playerMsg("§6/twitter§f: Twitterbot command");
         return true;
        }   
     if (mode.equals("19"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Basic Commands Page §c19§e----");
         playerMsg("§6/uall§f: Undisguse all players");
         playerMsg("§6/unicorn§f: Makes a text unicorn ");
         playerMsg("§6/utilities§f: Alco Management Command ");
         playerMsg("§6/uuid§f: Find someone's UUID");
         playerMsg("§6/warn§f: Warn someone");
         playerMsg("§6/wetoggle§f: Enable/Disable worldedit");
         playerMsg("§6/whohas§f: Find out who has a certain item or smite them");	
         playerMsg("§6/wildcard§f: Run any command on all users, username placeholder = ? ");	
         playerMsg("§6/wipeflatlands§f: Wipe the FlatLands");
         playerMsg("§6/wipeuserdata§f: Wipe UserData");	
         playerMsg("§6/world§f: Go to a world");
         return true;
        }   
     if (mode.equals("20"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Personal/Fun Commands Page §c1§e----");
         playerMsg("§6/arse§f: Kills you and calls you a ass ");
         playerMsg("§6/asshole§f: Used to kill assholes ");
         playerMsg("§6/badbest§f: BestMCPlayers personal command ");
         playerMsg("§6/balls§f: Blow someone's balls up");
         playerMsg("§6/banhammer§f: The mighty banhammer");
         playerMsg("§6/blowjob§f: Give someone a blowjob");
         playerMsg("§6/cheeseslap§f: CheeseMan441 personal command");	
         playerMsg("§6/chiefslap§f: Robgreenwood personal command");	
         playerMsg("§6/darth§f: XXDidiXX personal command");
         playerMsg("§6/destroy§f: Destroys a faggot");	
         playerMsg("§6/destroypussy§f: Destroys a pussy");
         return true;
        }   
     if (mode.equals("21"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Personal/Fun Commands Page §c2§e----");
         playerMsg("§6/alcodoom§f: Alco_Rs11 personal command");
         playerMsg("§6/evanhammer§f: evanator324 personal command");
         playerMsg("§6/godhammer§f: XxNicozillaxX personal command ");
         playerMsg("§6/hack§f: Hack the server, NOT ");
         playerMsg("§6/hiram§f: hiram2238 personal command");
         playerMsg("§6/horsehammer§f: DarkHorse108 personal command");
         playerMsg("§6/jayhammer§f: Jayscoob personal command");
         playerMsg("§6/jayslay§f: Jayscoob personal command");	
         playerMsg("§6/k§f: Nobody cares about what you said");	
         	
         return true;
        }   
      if (mode.equals("22"))
        {
         playerMsg("§e----§aEXPLODINGFreedomMod Personal/Fun Commands Page §c3§e----");
         playerMsg("§6/kicknoob§f: Kicks all noobs");
         playerMsg("§6/landmine§f: Set Landmines ");
         playerMsg("§6/optroll§f: Trolls OPs (Alco_Rs11/DarkGamingDronze cmd)");
         playerMsg("§6/orbit§f: Launch someone into orbit");
         playerMsg("§6/pussy§f: Kills pussies ");
         playerMsg("§6/sexy§f: Tells everyone who's sexy ");
         playerMsg("§6/skull§f: Give yourself someone's skull ");
         playerMsg("§6/tnthammer§f: EXPLODINGTNT001/Alco_Rs11 personal command ");
         playerMsg("§6/whore§f: Calls someone a whore");
         playerMsg("§6/workbench§f:§c Command not supported");
         playerMsg("§6/v§f: Make yourself invisible");
         return true;
        }   
     return true;
        }
}