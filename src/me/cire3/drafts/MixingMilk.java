package me.cire3.drafts;

import me.cire3.Kattio;

import java.io.IOException;
import java.util.Arrays;

public class MixingMilk {
    private static final int[] capacities = new int[3];
    private static final int[] currentMilkLevel = new int[3];

    public static void begin() throws IOException {
        Kattio io = new Kattio("problems/mixingmilk/mixmilk");

        for (int i = 0; i < 3; i++) {
            capacities[i] = io.nextInt();
            currentMilkLevel[i] = io.nextInt();
        }

        for (int i = 0; i < 100; i++) {
            int fillingFrom = i % 3;
            int fillingTo = (i + 1) % 3;

            int leftToFill = capacities[fillingTo] - currentMilkLevel[fillingTo];

            int amtShifted = Math.min(leftToFill, currentMilkLevel[fillingFrom]);

            currentMilkLevel[fillingTo] += amtShifted;
            currentMilkLevel[fillingFrom] -= amtShifted;
        }

        for (int milk : currentMilkLevel) io.println(milk);
        io.close();
    }
}
