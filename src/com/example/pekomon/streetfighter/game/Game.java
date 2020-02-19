package com.example.pekomon.streetfighter.game;

import com.example.pekomon.streetfighter.fighter.BaseFighter;
import com.example.pekomon.streetfighter.util.NameUtils;
import com.example.pekomon.streetfighter.util.RandomizationUtils;
import com.example.pekomon.streetfighter.weapon.MartialArtWeapon;
import com.example.pekomon.streetfighter.weapon.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {

    List<String> fighterNames;
    List<Weapon> weapons;

    public Game() {
        fighterNames = NameUtils.getFighterNames();
        weapons = generateWeapons();
    }

    public void fight() {

        final int fighterCount = 2; // So far only 1 vs 1 matches

        Collections.shuffle(fighterNames);

        List<BaseFighter> fighters = new ArrayList<>();
        for (int i = 0; i < fighterCount; i++) {
            fighters.add( new BaseFighter(fighterNames.get(i), RandomizationUtils.getNumber(18, 26)));
        }

        // Weapons
        Collections.shuffle(weapons);
        int weaponCounter = 0;
        for (int i = 0; i < fighterCount; i++) {
            if (RandomizationUtils.isLucky(30, 100)) {
                // Are there any weapons left?
                if (weaponCounter <= weapons.size()) {
                    fighters.get(i).setWeapon(weapons.get(weaponCounter));
                    weaponCounter++;
                } else {
                    continue;
                }
            }
        }

        while (fighters.get(0).isAlive() && fighters.get(1).isAlive()) {
            fighters.get(0).hit(fighters.get(1));
            doSleep(100);
            fighters.get(1).hit(fighters.get(0));
            doSleep(100);
        }

        for (BaseFighter f : fighters) {
            if (f.isAlive()) {
                System.out.println("Winner is " + f.getName());
                continue;
            }
        }

    }

    private static void doSleep(final int pMillis) {
        try {
            Thread.sleep(pMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<Weapon> generateWeapons() {
        return new ArrayList<>(Arrays.asList(
                new MartialArtWeapon("Knife", 7),
                new MartialArtWeapon("Sword", 10),
                new MartialArtWeapon("Tazer", 22),
                new MartialArtWeapon("Pepper spray", 5),
                new MartialArtWeapon("Pillow", 1)

        ));
    }
}
