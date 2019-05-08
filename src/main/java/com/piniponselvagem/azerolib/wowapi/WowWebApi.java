package com.piniponselvagem.azerolib.wowapi;

import com.piniponselvagem.azerolib.wowapi.dto.*;

public interface WowWebApi {
    RealmDto[] getRealmsFor(String region);
    RealmDto[] getRealmByNameFor(String region, String... realm);
}
