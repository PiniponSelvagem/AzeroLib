package com.piniponselvagem.azerolib.wowapi;

public class BaseWowWebApi implements WowWebApi {
    private final String HOST = "https://eu.api.blizzard.com/wow/";
    private final String wowKey;

    public BaseWowWebApi(String wowKey) {
        this.wowKey = wowKey;
    }
}
