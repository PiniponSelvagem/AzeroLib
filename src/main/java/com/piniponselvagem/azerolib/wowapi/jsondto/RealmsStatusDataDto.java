package com.piniponselvagem.azerolib.wowapi.jsondto;

public class RealmsStatusDataDto {
    private final RealmsStatusDataRealmDto[] data;

    public RealmsStatusDataDto(RealmsStatusDataRealmDto[] data) {
        this.data = data;
    }

    public RealmsStatusDataRealmDto[] getData() {
        return data;
    }
}
