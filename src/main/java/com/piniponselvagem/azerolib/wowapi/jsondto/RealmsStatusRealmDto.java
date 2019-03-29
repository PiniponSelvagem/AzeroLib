package com.piniponselvagem.azerolib.wowapi.jsondto;

public class RealmsStatusRealmDto {
    private final String type;
    private final String population;
    private final boolean queue;
    private final boolean status;
    private final String name;
    private final String slug;
    private final String battlegroup;
    private final String locale;
    private final String timezone;

    private final String[] connected_realms;

    public RealmsStatusRealmDto(String type, String population, boolean queue, boolean status, String name, String slug,
                                String battlegroup, String locale, String timezone, String[] connected_realms) {
        this.type = type;
        this.population = population;
        this.queue = queue;
        this.status = status;
        this.name = name;
        this.slug = slug;
        this.battlegroup = battlegroup;
        this.locale = locale;
        this.timezone = timezone;
        this.connected_realms = connected_realms;
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
        return battlegroup;
    }

    public String getLocale() {
        return locale;
    }

    public String getTimezone() {
        return timezone;
    }

    public String[] getConnectedRealms() {
        return connected_realms;
    }
}
