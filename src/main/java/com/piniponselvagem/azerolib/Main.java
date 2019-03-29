package com.piniponselvagem.azerolib;

import com.piniponselvagem.azerolib.utils.requests.Request;
import com.piniponselvagem.azerolib.utils.requests.FileRequest;
import com.piniponselvagem.azerolib.wowapi.WowWebApiJson;
import com.piniponselvagem.azerolib.wowapi.model.Realm;
import com.piniponselvagem.azerolib.wowapi.model.WowService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Request reqFile = new FileRequest();
        try {
            String token = reqFile.getLines("config/token").iterator().next();
            WowService wow = new WowService(new WowWebApiJson(token));
            Iterable<Realm> realms = wow.getRealmByNameFor("eu", "vashj");
            Realm realm = realms.iterator().next();
            System.out.println(realm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
