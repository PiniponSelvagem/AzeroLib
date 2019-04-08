package com.piniponselvagem.azerolib.wowapi;

public abstract class BaseWowWebApi implements WowWebApi {
    private final String HOST = "https://%s.api.blizzard.com/wow";
    private final String LOCALE_TOKEN;
    private final String REALM_STATUS = "/realm/status";
    private final String REALM_PARAM = "realm=";

    public BaseWowWebApi(String locale, String token) {
        this.LOCALE_TOKEN = String.format("?locale=%s&access_token=%s", locale, token);
    }


    protected String getRealmAllUrl(String region) {
        return String.format(HOST + REALM_STATUS + LOCALE_TOKEN, region);
    }

    protected String getRealmUrl(String region, String... realm) {
        StringBuilder realms = new StringBuilder();
        for (String aRealm : realm) {
            realms.append(REALM_PARAM).append(aRealm);
        }
        return String.format(HOST + REALM_STATUS + '?' + realms + '&' + LOCALE_TOKEN, region);
    }
}
