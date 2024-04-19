//package me.cire3.finalprograms.programs;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MilkMeasurementBronze2017DecemberProblem3 {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("measurement");

        int n = io.nextInt();
        int m = 7, e = 7, b = 7;

        // day is the index
        int[] bessie = new int[100];
        int[] mildred = new int[100];
        int[] elsie = new int[100];

        for (int i = 0; i < n; i++) {
            int day = io.nextInt() - 1;
            switch (io.next()) {
                case "Mildred":
                    mildred[day] = io.nextInt();
                    break;
                case "Bessie":
                    bessie[day] = io.nextInt();
                    break;
                case "Elsie":
                    elsie[day] = io.nextInt();
                    break;
            }
        }

        boolean[] shown = new boolean[3];
        int changes = 0;

        for (int i = 0; i < 100; i++) {
            boolean[] snapshot = Arrays.copyOf(shown, 3);
            b += bessie[i];
            m += mildred[i];
            e += elsie[i];

            int max = 0;
            max = Math.max(b, max);
            max = Math.max(m, max);
            max = Math.max(e, max);

            shown[0] = b == max;
            shown[1] = m == max;
            shown[2] = e == max;

            if (!Arrays.equals(snapshot, shown))
                changes++;
        }
        System.out.println(changes);
    }

    private static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

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
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
