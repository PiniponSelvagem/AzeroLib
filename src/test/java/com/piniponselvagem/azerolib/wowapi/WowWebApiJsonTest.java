package com.piniponselvagem.azerolib.wowapi;

import com.piniponselvagem.azerolib.utils.requests.FileRequest;
import com.piniponselvagem.azerolib.wowapi.utils.requests.MockRequest;

import java.io.IOException;

public class WowWebApiJsonTest extends WowWebApiTest {

    public WowWebApiJsonTest() throws IOException {
        super(new WowWebApiJson(
                new FileRequest().getLines("config/token").iterator().next(),
                new MockRequest())
        );
    }
}
