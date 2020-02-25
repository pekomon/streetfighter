package com.example.pekomon.streetfighter.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomizationUtilsTest {

    private static final int BASIC_TEST_ROUNDS = 20;
    private static final int VARIANCE_TEST_ROUNDS = 100;

    @Test
    public void testNeverLucky() {
        for (int i = 0; i < BASIC_TEST_ROUNDS; i++) {
            assertFalse(RandomizationUtils.isLucky(0, i));
        }
        for (int i = 0; i < BASIC_TEST_ROUNDS; i++) {
            assertFalse(RandomizationUtils.isLucky(i*(-1), i));
        }
    }

    @Test
    public void testAlwaysLucky() {
        for (int i = 0; i < BASIC_TEST_ROUNDS; i++) {
            final int num = i + 1;
            assertTrue(RandomizationUtils.isLucky(num, num));
        }
    }

    @Test
    public void testNeverLuckyPercentage() {
        assertFalse(RandomizationUtils.isLucky(0));
        for (int i = 0; i < BASIC_TEST_ROUNDS; i++) {
            assertFalse(RandomizationUtils.isLucky(i * -1));
        }
    }

    @Test
    public void testAlwaysLuckyPercentage() {
        assertTrue(RandomizationUtils.isLucky(100));
        for (int i = 0; i < BASIC_TEST_ROUNDS; i++) {
            assertTrue(RandomizationUtils.isLucky(100 + i));
        }
    }

    /**
     * It is pretty impossible to test randomness but let's run many rounds with 50/50
     * probability and hope we get both true and false values.
     * Note: it is possible that this test may fail but that shouldn't be very frequent
     * */
    @Test
    public void testIsLuckyWithVariationExpectation() {
        final List<Boolean> returnValues = new ArrayList<>();
        for (int i = 0; i < VARIANCE_TEST_ROUNDS; i++) {
            returnValues.add(RandomizationUtils.isLucky(1,2));
        }
        assertAlmostEqualAmountOfValues(returnValues);
    }

    @Test
    public void testIsLuckPercentageyWithVariationExpectation() {
        final List<Boolean> returnValues = new ArrayList<>();
        for (int i = 0; i < VARIANCE_TEST_ROUNDS; i++) {
            returnValues.add(RandomizationUtils.isLucky(50));
        }
        assertAlmostEqualAmountOfValues(returnValues);
    }

    private void assertAlmostEqualAmountOfValues(final List<Boolean> pBooleans) {
        int trues = 0;
        int falses = 0;

        for (boolean b : pBooleans) {
            if (b) {
                trues++;
            } else {
                falses++;
            }
        }
        final int itemCount = pBooleans.size();
        assertTrue(trues > (itemCount / 5), "Not enough trues. " + trues + " of " + itemCount);
        assertTrue(falses > (itemCount / 5), "Not enough falses. " + falses + " of " + itemCount);

        System.out.println("Trues: " + trues + ", Falses: " + falses + ", Total: " + itemCount);
    }

    @Test
    public void testGetNumberInRange() {

        for (int i = 0; i < BASIC_TEST_ROUNDS; i++) {
            final int low = i - (3 * i);
            final int high = i + (2 * i);
            final int num = RandomizationUtils.getNumber(low, high);
            assertTrue(num >= low);
            assertTrue(num <= high);
        }
    }

    @Test
    public void testGetPositiveNumber() {
        for (int i = 0; i < BASIC_TEST_ROUNDS; i++) {
            assertTrue(RandomizationUtils.getPositiveNumber((i * i )+ 1 ) > 0);
        }
    }
}