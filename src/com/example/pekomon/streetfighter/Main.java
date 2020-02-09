package com.example.pekomon.streetfighter;

public class Main {

    public static void main(String[] args) {

        BaseFighter dick = new BaseFighter("Dick", 25);
        BaseFighter jack = new BaseFighter("Jack", 51);

        while (dick.isAlive() && jack.isAlive()) {
            dick.hit(jack);
            jack.hit(dick);
        }

        if (dick.isAlive()) {
            System.out.println("Winner is Dick");
        } else {
            System.out.println("Jack wins");
        }

    }
}
