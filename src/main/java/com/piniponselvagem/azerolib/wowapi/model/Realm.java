package com.piniponselvagem.azerolib.wowapi.model;

import java.util.Arrays;

public class Realm {
    private final String region;
    private final String type;
    private final String population;
    private final boolean queue;
    private final boolean status;
    private final String name;
    private final String slug;
    private final String battleGroup;
    private final String locale;
    private final String timezone;
    private String[] connectedRealms;

    public Realm(String region, String type, String population, boolean queue, boolean status, String name, String slug, String battleGroup, String locale, String timezone, String[] connectedRealms) {
        this.region = region;
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

    @Override
    public String toString() {
        return "Realm{" +
                "region='" + region + '\'' +
                ", type='" + type + '\'' +
                ", population='" + population + '\'' +
                ", queue=" + queue +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", battleGroup='" + battleGroup + '\'' +
                ", locale='" + locale + '\'' +
                ", timezone='" + timezone + '\'' +
                ", connectedRealms=" + Arrays.toString(connectedRealms) +
                '}';
    }



    public String getRegion() {
        return region;
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

    public String[] getConnectedRealms() {
        return connectedRealms;
    }
}
