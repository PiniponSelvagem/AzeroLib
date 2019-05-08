package com.piniponselvagem.azerolib.wowapi.model;

import com.piniponselvagem.azerolib.wowapi.WowWebApi;
import com.piniponselvagem.azerolib.wowapi.dto.RealmDto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Stream;

public class WowService {

    private final WowWebApi api;

    public WowService(WowWebApi api) {
        this.api = api;
    }


    public Stream<Realm> getRealmsFor(String region) {
        Function<RealmDto, Realm> mapDtoToRealm = (dto) -> toRealm(region, dto);
        RealmDto[] realmDto = api.getRealmsFor(region);


        return Stream
                .iterate(0, i -> i+1)
                .takeWhile(i -> i<realmDto.length)
                .map(i -> realmDto[i])
                .flatMap(Stream::of)
                .map(mapDtoToRealm);
    }

    //TODO: This is not efficient when you take in consideration that
    //TODO: you can request the same information from Blizzard API
    //TODO: with just a single request. It is made this way atm, for
    //TODO: school studying.
    public Stream<Realm> getRealmByNameFor(String region, String... realm) {
        Function<RealmDto, Realm> mapDtoToRealm = (dto) -> toRealm(region, dto);

        return Stream
                .iterate(0, i -> i+1)
                .takeWhile(i -> i<realm.length)
                .map(i -> api.getRealmByNameFor(region, realm[i]))
                .flatMap(Stream::of)
                .map(mapDtoToRealm);
    }

    private Stream<Realm> getRealm(String region, String realm){
        return getRealmByNameFor(region, realm);
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
