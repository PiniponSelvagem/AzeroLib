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
    public void getRealmsForRegionEU() {
        // Arrange

        // Act
        final RealmDto[] realms = wowWebApi.getRealmsFor(REGION);

        // Assert
        Assert.assertNotNull(realms);
        assertEachRealmIsValid(realms, 267);
    }

    @Test
    public void getRealmVashjRegionEU() {
        // Arrange
        String realmName = "vashj";

        // Act
        final RealmDto[] realms = wowWebApi.getRealmByNameFor(REGION, realmName);

        // Assert
        Assert.assertNotNull(realms);
        assertEachRealmIsValid(realms, 1);
    }


    private void assertEachRealmIsValid(RealmDto[] realms, int expected) {
        int count = 0;
        for(RealmDto realm : realms) {
            Assert.assertNotNull(realm);
            ++count;
        }
        Assert.assertEquals(expected, count);
    }
}
