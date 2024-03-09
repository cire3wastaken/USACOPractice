package me.cire3.drafts;

import me.cire3.Kattio;
import me.cire3.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShellGame {
    public static boolean[] shells = new boolean[3];
    public static void begin() throws IOException {
        int maxPoints = -1;
        Kattio io = new Kattio("problems/shellgame/shell");
        int maxSwaps = io.nextInt();

        List<Pair<Integer, Integer>> swaps = new ArrayList<>();
        List<Integer> guesses = new ArrayList<>();

        for (int k = 0; k < maxSwaps; k++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            int guess = io.nextInt();

            swaps.add(new Pair<>(a, b));
            guesses.add(guess);
        }

        for (int i = 0; i < 3; i++) {
            int points = 0;
            shells[0] = shells[1] = shells[2] = false;
            shells[i] = true;

            for (int k = 0; k < maxSwaps; k++) {
                Pair<Integer, Integer> swap = swaps.get(k);
                int a = swap.getFirst();
                int b = swap.getSecond();
                int guess = guesses.get(k);

                boolean t = shells[a];
                shells[a] = shells[b];
                shells[b] = t;

                if (shells[guess])
                    points++;
            }

            maxPoints = Math.max(points, maxPoints);
        }

        io.println(maxPoints);
        io.close();
    }
}
