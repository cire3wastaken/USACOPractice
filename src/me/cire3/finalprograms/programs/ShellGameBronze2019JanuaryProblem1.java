

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ShellGameBronze2019JanuaryProblem1 {
    public static boolean[] shells;
    public static void main(String[] args) throws IOException {
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

        shells = new boolean[3];

        for (int i = 0; i < 3; i++) {
            int points = 0;

            for (int index = 0; index < 3; index++) shells[index] = false;

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

    private static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

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
