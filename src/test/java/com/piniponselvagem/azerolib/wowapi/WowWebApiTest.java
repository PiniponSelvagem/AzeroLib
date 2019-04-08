package com.piniponselvagem.azerolib.wowapi;

import com.piniponselvagem.azerolib.wowapi.dto.RealmDto;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public abstract class WowWebApiTest {
    private final WowWebApi wowWebApi;
    private final String REGION = "eu";


    public WowWebApiTest(WowWebApi wowWebApi) {
        this.wowWebApi = wowWebApi;
    }

    @Test
    public void getRealmsForRegionEU() throws IOException {
        // Arrange

        // Act
        final Iterable<RealmDto> realms = wowWebApi.getRealmsFor(REGION);

        // Assert
        Assert.assertTrue(realms.iterator().hasNext());
        assertEachRealmIsValid(realms);
    }


    private void assertEachRealmIsValid(Iterable<RealmDto> realms) {
        for(RealmDto realm : realms) {
            Assert.assertNotNull(realm);
        }
    }
}
