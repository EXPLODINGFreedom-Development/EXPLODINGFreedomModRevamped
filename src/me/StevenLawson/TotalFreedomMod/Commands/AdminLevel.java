package me.StevenLawson.TotalFreedomMod.Commands;

public enum AdminLevel
{
    ALL("All Player Commands"), OP("OP Commands"), SUPER("SuperAdmin Commands"), TELNET("Telnet Admin Commands"), BUILDER("Builder Commands"), BUILDERP("Builder+ Commands"), SENIOR("Senior Admin Commands");
    //
    private final String friendlyName;

    private AdminLevel(String friendlyName)
    {
        this.friendlyName = friendlyName;
    }

    public String getFriendlyName()
    {
        return friendlyName;
    }
}
