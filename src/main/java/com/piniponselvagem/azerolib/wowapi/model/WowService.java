package com.piniponselvagem.azerolib.wowapi.model;

import com.piniponselvagem.azerolib.utils.queries.Queries;
import com.piniponselvagem.azerolib.utils.queries.lazy.LazyQueries;
import com.piniponselvagem.azerolib.wowapi.WowWebApi;
import com.piniponselvagem.azerolib.wowapi.dto.RealmDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class WowService {

    private final WowWebApi api;

    public WowService(WowWebApi api) {
        this.api = api;
    }


    public Iterable<Realm> getRealmsFor(String region) throws IOException {
        return getRealmByNameFor(region);
    }

    public Iterable<Realm> getRealmByNameFor(String region, String... realm) throws IOException {
        Iterable<RealmDto> realms = api.getRealmByNameFor(region, realm);
        return LazyQueries.of(realms).map(rd -> toRealm(region, rd));
    }

    private Realm toRealm(String region, RealmDto rd) {
        return new Realm(
                region,
                rd.getType(),
                rd.getPopulation(),
                rd.isQueue(),
                rd.isStatus(),
                rd.getName(),
                rd.getSlug(),
                rd.getBattleGroup(),
                rd.getLocale(),
                rd.getTimezone(),
                getConnectedRealmsSlug(rd.getConnectedRealms())
        );
    }

    private String[] getConnectedRealmsSlug(Iterable<String> dto) {
        Iterator<String> slugs = dto.iterator();
        ArrayList<String> connected = new ArrayList<>();
        for (int i=0; slugs.hasNext(); ++i) {
            connected.add(i, slugs.next());
        }
        return connected.toArray(new String[0]);
    }
}
