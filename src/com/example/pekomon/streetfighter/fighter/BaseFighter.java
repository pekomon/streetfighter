package com.example.pekomon.streetfighter.fighter;

import com.example.pekomon.streetfighter.util.RandomizationUtils;
import com.example.pekomon.streetfighter.weapon.Weapon;

public class BaseFighter {

    private String name;
    private int life;
    private int power;
    private Weapon weapon;

    public BaseFighter(final String pName, final int pPower) {
        this.name = pName;
        this.power = pPower;
        life = 100 + RandomizationUtils.getNumber(-20, 20);
    }

    public String getName() {
        return name;
    }

    protected int getPower() {
        return power;
    }

    public void setWeapon(final Weapon pWeapon) {
        weapon = pWeapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void hit(final BaseFighter opponent) {

        if (!isAlive()) {
            return;
        }

        int hitPower = power + RandomizationUtils.getNumber(-3, 3);

        StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(" hits ")
                .append(opponent.getName());
        if (weapon != null) {
            hitPower += weapon.getPower();
            sb.append(" with a ")
                    .append(weapon.getName());
        }
        sb.append(" [" + hitPower +"]");

        System.out.println(sb);
        opponent.takeDamage(hitPower);
    }

    protected void takeDamage(final int pDamage) {
        life -= pDamage;
        if (!isAlive()) {
            System.out.println(name + " loses the game");
        }
    }

    public boolean isAlive() {
        return life > 0;
    }
}
