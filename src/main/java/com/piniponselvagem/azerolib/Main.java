package com.piniponselvagem.azerolib;

import com.piniponselvagem.azerolib.utils.requests.Request;
import com.piniponselvagem.azerolib.utils.requests.FileRequest;
import com.piniponselvagem.azerolib.wowapi.WowWebApiJson;
import com.piniponselvagem.azerolib.wowapi.model.Realm;
import com.piniponselvagem.azerolib.wowapi.model.WowService;

import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Stream;

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
            Stream<Realm> realms = wow.getRealmByNameFor("eu", "vashj", "silvermoon");
            realms.forEach(System.out::println);

            Stream<Realm> realmsAll = wow.getRealmsFor("eu");
            realmsAll.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
