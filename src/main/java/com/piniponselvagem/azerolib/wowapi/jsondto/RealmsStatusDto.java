package com.piniponselvagem.azerolib.wowapi.jsondto;

public class RealmsStatusDto {
    private final RealmsStatusDataDto data;

    public RealmsStatusDto(RealmsStatusDataDto data) {
        this.data = data;
    }

    public RealmsStatusDataDto getData() {
        return data;
    }
}
