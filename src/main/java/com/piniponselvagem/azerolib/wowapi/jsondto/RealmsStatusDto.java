package com.piniponselvagem.azerolib.wowapi.jsondto;

public class RealmsStatusDto {
    private final RealmsStatusRealmDto[] realms;

    public RealmsStatusDto(RealmsStatusRealmDto[] realms) {
        this.realms = realms;
    }

    public RealmsStatusRealmDto[] getRealm() {
        return realms;
    }
}
