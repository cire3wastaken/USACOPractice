package me.cire3.finalprograms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ShellGameBronze2019JanuaryProblem1 {
    public static boolean[] shells = new boolean[3];
    public static void main(String[] args) throws IOException {
        long beginMS = System.currentTimeMillis();

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

        System.out.println(System.currentTimeMillis() - beginMS);
    }

    private static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
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
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }

    private static class Pair<V, K> {
        private V first;
        private K second;

        public Pair(V first, K second) {
            this.first = first;
            this.second = second;
        }

        public V getFirst() {
            return first;
        }

        public K getSecond() {
            return second;
        }
    }
}
