package com.piniponselvagem.azerolib.wowapi;

import com.piniponselvagem.azerolib.wowapi.dto.*;

import java.io.IOException;

public interface WowWebApi {
    Iterable<RealmDto> getRealmsFor(String region) throws IOException;
}
