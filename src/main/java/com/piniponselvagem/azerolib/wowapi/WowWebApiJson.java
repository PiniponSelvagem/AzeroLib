package com.piniponselvagem.azerolib.wowapi;

import com.google.gson.Gson;
import com.piniponselvagem.azerolib.wowapi.dto.*;
import com.piniponselvagem.azerolib.utils.requests.HttpRequest;
import com.piniponselvagem.azerolib.utils.requests.Request;
import com.piniponselvagem.azerolib.wowapi.jsondto.RealmsStatusDto;

import java.io.IOException;

public class WowWebApiJson extends BaseWowWebApi {

    private final Request req;
    private final Gson gson;

    public WowWebApiJson(String token) {
        this(token, new HttpRequest(), new Gson());
    }

    public WowWebApiJson(String token, Request req) {
        this(token, req, new Gson());
    }

    public WowWebApiJson(String token, Request req, Gson gson) {
        super("eu", token);     //TODO: support for multiple region
        this.req = req;
        this.gson = gson;
    }



    @Override
    public Iterable<RealmDto> getRealmsFor(String region) throws IOException {
        final String url = getRealmAllUrl(region);
        Iterable<String> src = req.getLines(url);
        String body = String.join("", src);
        RealmsStatusDto dto = gson.fromJson(body, RealmsStatusDto.class);

        return null;
    }
}
