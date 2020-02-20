package com.example.pekomon.streetfighter.weapon;

import com.example.pekomon.streetfighter.util.RandomizationUtils;

public class MartialArtWeapon implements Weapon {

    private final static int POWER_THRESHOLD = 2;

    private final String name;
    private final int power;
    public MartialArtWeapon(final String pName, final int pPower) {
        name = pName;
        power = pPower;
    }

    /**
     * Returns the power of weapon. Includes some variance but is always greater than zero.
     * @return, int, describing the power of weapon in this specific attack. Value may be different everytime but
     * it is never negative.
     */
    @Override
    public int getPower() {
        return Math.max(0, power + RandomizationUtils.getNumber(-POWER_THRESHOLD, POWER_THRESHOLD));
    }

    @Override
    public String getName() {
        return name;
    }
}
