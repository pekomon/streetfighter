package com.example.pekomon.streetfighter.Util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizationUtils {

    /**
     * Randomizes a number between 1 and parameter pMax and returns true if
     * given parameter pProbablity is greater than randomized number.
     * Basically you can for example 'flip a coin' using params 1 and 2. Or get
     * result or rolling a dice to get one certain number when using params 1 and 6.
     * Getting a 27% probablility, use params 27 and 100.
     *
     * @param pProbability, the probability of 'luck'. The higher, the better chance of being lucky.
     * @param pMax, the max value of randomized. The higher, the smaller chance of being lucky.
     * @return, boolean true if randomization was lucky. False otherwise.
     */
    public static boolean isLucky(final int pProbability, final int pMax) {

        if (pProbability >= pMax) {
            return true;
        }

        final int randomNumber = ThreadLocalRandom.current().nextInt(pMax + 1);
        return pProbability > randomNumber;
    }

    public static int getPositiveNumber(final int pMax) {
        return ThreadLocalRandom.current().nextInt(pMax + 1);
    }

    public static int getNumber(final int pMin, final int pMax) {
        return ThreadLocalRandom.current().nextInt(pMin, pMax + 1);
    }
}
