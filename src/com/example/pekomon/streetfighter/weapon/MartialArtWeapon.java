package com.example.pekomon.streetfighter.weapon;

import com.example.pekomon.streetfighter.util.RandomizationUtils;

public class MartialArtWeapon implements Weapon {

    private final String name;
    private final int power;
    public MartialArtWeapon(final String pName, final int pPower) {
        name = pName;
        power = pPower;
    }

    @Override
    public int getPower() {
        return power + RandomizationUtils.getNumber(-2, 2);
    }

    @Override
    public String getName() {
        return name;
    }
}
