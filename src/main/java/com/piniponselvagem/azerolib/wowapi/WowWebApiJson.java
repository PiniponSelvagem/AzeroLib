package com.piniponselvagem.azerolib.wowapi;

import com.google.gson.Gson;
import com.piniponselvagem.azerolib.utils.queries.lazy.LazyQueries;
import com.piniponselvagem.azerolib.wowapi.dto.*;
import com.piniponselvagem.azerolib.utils.requests.HttpRequest;
import com.piniponselvagem.azerolib.utils.requests.Request;
import com.piniponselvagem.azerolib.wowapi.jsondto.ContainerDto;
import com.piniponselvagem.azerolib.wowapi.jsondto.RealmsStatusRealmDto;
import com.piniponselvagem.azerolib.wowapi.jsondto.RealmsStatusDto;

import java.io.IOException;
import java.util.Arrays;

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
        return getRealmByNameFor(region);
    }

    @Override
    public Iterable<RealmDto> getRealmByNameFor(String region, String... realm) throws IOException {
        String url;
        if (realm.length > 0)
            url = getRealmUrl(region, realm);
        else
            url = getRealmAllUrl(region);
        Iterable<String> src = req.getLines(url);
        String body = String.join("", src);
        RealmsStatusDto dto = gson.fromJson(body, RealmsStatusDto.class);
        RealmsStatusRealmDto[] realmDto = dto.getRealm();

        return LazyQueries.of(Arrays.asList(realmDto)).map(rsdrDto -> toRealmDto(rsdrDto));
    }

    private RealmDto toRealmDto(RealmsStatusRealmDto dto) {
        return new RealmDto(
                dto.getType(),
                dto.getPopulation(),
                dto.isQueue(),
                dto.isStatus(),
                dto.getName(),
                dto.getSlug(),
                dto.getBattleGroup(),
                dto.getLocale(),
                dto.getTimezone(),
                Arrays.asList(dto.getConnectedRealms())
        );
    }
}
