package com.example.pekomon.streetfighter.fighter;

public class ArmoredFighter extends BaseFighter {


    public ArmoredFighter(String pName, int pPower) {
        super(pName, pPower);
    }

    @Override
    protected void takeDamage(int pDamage) {
        super.takeDamage(pDamage/2);
    }
}
