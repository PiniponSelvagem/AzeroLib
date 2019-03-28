package com.piniponselvagem.azerolib.wowapi.jsondto;

public class RealmsStatusDataRealmDto {
    private final String type;
    private final String population;
    private final boolean queue;
    private final boolean status;
    private final String name;
    private final String slug;
    private final String battleGroup;
    private final String locale;
    private final String timezone;
    private final ContainerDto[] connectedRealms;

    public RealmsStatusDataRealmDto(String type, String population, boolean queue, boolean status, String name, String slug, String battleGroup, String locale, String timezone, ContainerDto[] connectedRealms) {
        this.type = type;
        this.population = population;
        this.queue = queue;
        this.status = status;
        this.name = name;
        this.slug = slug;
        this.battleGroup = battleGroup;
        this.locale = locale;
        this.timezone = timezone;
        this.connectedRealms = connectedRealms;
    }

    public String getType() {
        return type;
    }

    public String getPopulation() {
        return population;
    }

    public boolean isQueue() {
        return queue;
    }

    public boolean isStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getBattleGroup() {
        return battleGroup;
    }

    public String getLocale() {
        return locale;
    }

    public String getTimezone() {
        return timezone;
    }

    public ContainerDto[] getConnectedRealms() {
        return connectedRealms;
    }
}
