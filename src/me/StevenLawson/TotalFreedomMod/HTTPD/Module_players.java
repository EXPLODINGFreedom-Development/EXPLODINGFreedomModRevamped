package me.StevenLawson.TotalFreedomMod.HTTPD;

import java.util.UUID;
import me.StevenLawson.TotalFreedomMod.Admin.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Module_players extends TFM_HTTPD_Module
{
    public Module_players(NanoHTTPD.HTTPSession session)
    {
        super(session);
    }

    @Override
    @SuppressWarnings("unchecked")
    public NanoHTTPD.Response getResponse()
    {
        final JSONObject responseObject = new JSONObject();

        final JSONArray players = new JSONArray();
        final JSONArray superadmins = new JSONArray();
        final JSONArray telnetadmins = new JSONArray();
        final JSONArray senioradmins = new JSONArray();
        final JSONArray developers = new JSONArray();
        final JSONArray executives = new JSONArray();
        final JSONArray specialists = new JSONArray();
        final JSONArray systemadmins = new JSONArray();
        final JSONArray leadsystemadmins = new JSONArray();
        final JSONArray coowners = new JSONArray();
        final JSONArray owners = new JSONArray();


        // All online players
        for (Player player : TotalFreedomMod.server.getOnlinePlayers())
        {
            players.add(player.getName());
        }

        // Super admins (non-telnet and non-senior)
        for (UUID superadmin : TFM_AdminList.getSuperUUIDs())
        {
            if (TFM_AdminList.getSeniorUUIDs().contains(superadmin))
            {
                continue;
            }

            if (TFM_AdminList.getTelnetUUIDs().contains(superadmin))
            {
                continue;
            }

            superadmins.add(getName(superadmin));
        }

        // Telnet admins (non-senior)
        for (UUID telnetadmin : TFM_AdminList.getTelnetUUIDs())
        {
            if (TFM_AdminList.getSeniorUUIDs().contains(telnetadmin))
            {
                continue;
            }
            telnetadmins.add(getName(telnetadmin));
        }

        // Senior admins
        for (UUID senioradmin : TFM_AdminList.getSeniorUUIDs())
        {
            senioradmins.add(getName(senioradmin));
        }

        // Developers
        developers.addAll(TFM_Util.DEVELOPERS);
        // Executives
        executives.addAll(TFM_Util.EXECS);
        // Specialists
        specialists.addAll(TFM_Util.SPECIAL_EXECS);
        // System-Admins
        systemadmins.addAll(TFM_Util.SYS_ADMINS);
        // Lead System-Admins
        leadsystemadmins.addAll(TFM_Util.LEADSYSS);
        // Co-Owners
        coowners.addAll(TFM_Util.SYS_COOWNERS);
        // Owners
        owners.addAll(TFM_Util.OWNERS);
        responseObject.put("players", players);
        responseObject.put("superadmins", superadmins);
        responseObject.put("telnetadmins", telnetadmins);
        responseObject.put("senioradmins", senioradmins);
        responseObject.put("developers", developers);
        responseObject.put("executives", executives);
        responseObject.put("specialists", specialists);
        responseObject.put("system-admins", systemadmins);
        responseObject.put("lead system-admins", leadsystemadmins);
        responseObject.put("co-owners", coowners);
         responseObject.put("owners", owners);

        final NanoHTTPD.Response response = new NanoHTTPD.Response(NanoHTTPD.Response.Status.OK, NanoHTTPD.MIME_JSON, responseObject.toString());
        response.addHeader("Access-Control-Allow-Origin", "*");
        return response;
    }

    private String getName(UUID uuid)
    {
        return TFM_AdminList.getEntry(uuid).getLastLoginName();
    }
}
