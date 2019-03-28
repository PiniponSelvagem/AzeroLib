package com.piniponselvagem.azerolib.wowapi;

import com.google.gson.Gson;
import com.piniponselvagem.azerolib.utils.requests.HttpRequest;
import com.piniponselvagem.azerolib.utils.requests.Request;

public class WowWebApiJson extends BaseWowWebApi {

    private final Request req;
    private final Gson gson;

    public WowWebApiJson(String wowKey) {
        this(wowKey, new HttpRequest(), new Gson());
    }

    public WowWebApiJson(String wowKey, Request req) {
        this(wowKey, req, new Gson());
    }

    public WowWebApiJson(String wowKey, Request req, Gson gson) {
        super(wowKey);
        this.req = req;
        this.gson = gson;
    }
}
