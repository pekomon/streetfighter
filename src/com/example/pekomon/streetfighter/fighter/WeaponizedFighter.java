package com.example.pekomon.streetfighter.fighter;

public class WeaponizedFighter extends BaseFighter {


    @Override
    public void hit(BaseFighter opponent) {

        super.hit(opponent);
    }

    public WeaponizedFighter(String pName, int pPower) {
        super(pName, pPower);
    }

}
