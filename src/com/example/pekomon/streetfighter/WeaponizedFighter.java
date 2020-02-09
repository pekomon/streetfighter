package com.example.pekomon.streetfighter;

public class WeaponizedFighter extends BaseFighter {

    private Weapon axe = new Weapon() {
        @Override
        public int getPower() {
            return 10;
        }
    };

    @Override
    public void hit(BaseFighter opponent) {
        if (axe != null) {

        }

        super.hit(opponent);
    }

    public WeaponizedFighter(String pName, int pPower) {
        super(pName, pPower);
    }




}
