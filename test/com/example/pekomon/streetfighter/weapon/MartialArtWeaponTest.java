package com.example.pekomon.streetfighter.weapon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MartialArtWeaponTest {

    @Test
    public void testBasicCreation() {
        final String expectedName = "gfdg";
        final int expectedPower = 10;
        Weapon weapon = new MartialArtWeapon(expectedName, expectedPower);
        assertEquals(expectedName, weapon.getName());
        final int receivedPower = weapon.getPower();
        assertTrue(receivedPower >= expectedPower - 2 );
        assertTrue(receivedPower <= expectedPower + 2 );
    }

    @Test
    public void testNegativePower() {
        Weapon weapon = new MartialArtWeapon("d", -100);
        for (int i = 0; i < 10; i++) {
            assertEquals(0, weapon.getPower());
        }
    }

    @Test
    public void testPowerVariance() {
        // This needs luck and can fail if power is always randomized with same value.
        // With several rounds we _should_ get some variance
        final int power = 10;
        Weapon weapon = new MartialArtWeapon("d", power);
        List<Integer> receivedPowers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            receivedPowers.add(weapon.getPower());
        }

        assertTrue(receivedPowers.contains(8));
        assertTrue(receivedPowers.contains(9));
        assertTrue(receivedPowers.contains(10));
        assertTrue(receivedPowers.contains(11));
        assertTrue(receivedPowers.contains(12));
    }
}