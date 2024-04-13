package me.cire3.finalprograms.programs;

import java.io.*;
import java.util.StringTokenizer;

public class MixingMilkBronze2018DecemberProblem1 {
    private static final int[] capacities = new int[3];
    private static final int[] currentMilkLevel = new int[3];

    public static void main(String[] args) throws IOException {
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

    private static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception ignored) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
    }
}
