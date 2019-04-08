package com.piniponselvagem.azerolib;

import com.piniponselvagem.azerolib.utils.requests.Request;
import com.piniponselvagem.azerolib.utils.requests.FileRequest;
import com.piniponselvagem.azerolib.wowapi.WowWebApiJson;
import com.piniponselvagem.azerolib.wowapi.model.Realm;
import com.piniponselvagem.azerolib.wowapi.model.WowService;

import java.io.IOException;
import java.util.Iterator;

public class Main {

    //private static final String TOKEN_SERVER_URL = "https://eu.battle.net/oauth/token";
    //private static final String AUTHORIZATION_SERVER_URL = "https://eu.battle.net/oauth/authorize";

    /** OAuth 2 scope. */
    //private static final String SCOPE = "wow.profile";

    public static void main(String[] args) {
        Request reqFile = new FileRequest();
        try {
            Iterator<String> it = reqFile.getLines("config/token").iterator();
            //String clientID = it.next();
            //String clientSecret = it.next();
            String token = it.next();

            //TODO: Use OAuth2 instead of token

            WowService wow = new WowService(new WowWebApiJson(token));
            Iterable<Realm> realms = wow.getRealmByNameFor("eu", "vashj");
            Realm realm = realms.iterator().next();
            System.out.println(realm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
