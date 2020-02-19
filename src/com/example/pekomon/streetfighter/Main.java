package com.example.pekomon.streetfighter;

import com.example.pekomon.streetfighter.Util.RandomizationUtils;
import com.example.pekomon.streetfighter.fighter.BaseFighter;
import com.example.pekomon.streetfighter.weapon.Weapon;

public class Main {

    public static void main(String[] args) {

        BaseFighter dick = new BaseFighter("Dick", 25);
        BaseFighter jack = new BaseFighter("Jack", 31);

        if (RandomizationUtils.isLucky(30, 100)) {
            dick.setWeapon(new Weapon() {
                final int power = RandomizationUtils.getPositiveNumber(7);
                @Override
                public int getPower() {
                    return power;
                }

                @Override
                public String getName() {
                    return "axe";
                }
            });
            System.out.println("Dick got a weapon.");
        }

        if (RandomizationUtils.isLucky(30, 100)) {
            jack.setWeapon(new Weapon() {
                final int power = RandomizationUtils.getPositiveNumber(10);
                @Override
                public int getPower() {
                    return power;
                }

                @Override
                public String getName() {
                    return "shotgun";
                }
            });

            System.out.println("Jack got a weapon.");
        }

        while (dick.isAlive() && jack.isAlive()) {
            dick.hit(jack);
            doSleep(100);
            jack.hit(dick);
            doSleep(100);
        }

        if (dick.isAlive()) {
            System.out.println("Winner is Dick");
        } else {
            System.out.println("Jack wins");
        }
    }

    private static void doSleep(final int pMillis) {
        try {
            Thread.sleep(pMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
