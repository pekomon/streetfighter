package com.example.pekomon.streetfighter;

public class BaseFighter {

    private String name;
    private int life = 100;
    private int power;

    public BaseFighter(final String pName, final int pPower) {
        this.name = pName;
        this.power = pPower;
    }

    public String getName() {
        return name;
    }

    protected int getPower() {
        return power;
    }

    public void hit(final BaseFighter opponent) {
        System.out.println(name + " hits " + opponent.getName());
        opponent.takeDamage(power);
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
