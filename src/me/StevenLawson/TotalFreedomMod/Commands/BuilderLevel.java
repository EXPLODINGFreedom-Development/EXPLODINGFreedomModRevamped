package me.StevenLawson.TotalFreedomMod.Commands;

public enum BuilderLevel
{
    ALL("All Player Commands"), BUILDER("Builder Commands"), ARCHITECT("Architect Commands"), MASTERBUILDER("Master-Builder Commands");
    //
    private final String friendlyName;

    private BuilderLevel(String friendlyName)
    {
        this.friendlyName = friendlyName;
    }

    public String getFriendlyName()
    {
        return friendlyName;
    }
}
