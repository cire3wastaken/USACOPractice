package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

// FIXME
public class FinalBoss {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("8\n" +
                "3 2\n" +
                "2 1\n" +
                "2 1\n" +
                "5 2\n" +
                "2 1\n" +
                "2 1\n" +
                "50 3\n" +
                "5 6 7\n" +
                "5 6 7\n" +
                "50 3\n" +
                "2 2 2\n" +
                "3 3 3\n" +
                "90000 2\n" +
                "200000 200000\n" +
                "1 1\n" +
                "100000 1\n" +
                "1\n" +
                "200000\n" +
                "6 7\n" +
                "3 2 3 2 3 1 2\n" +
                "6 5 9 5 10 7 7\n" +
                "21 6\n" +
                "1 1 1 1 1 1\n" +
                "5 5 8 10 7 6\n"));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] dmgs = new int[n];
            // use long arr to support System#arraycopy
            long[] cds = new long[n];
            long[] next = new long[n];

            long lcm = 1;

            for (int i = 0; i < n; i++)
                dmgs[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int turns = Integer.parseInt(st.nextToken());

                lcm = lcm(turns, lcm);
                cds[i] = turns;
            }

            long damagePerCycle = 0;
            for (int i = 0; i < n; i++) {
                damagePerCycle += dmgs[i] * lcm / cds[i];
            }

            long cycles = (int) Math.floor((float) h / damagePerCycle);
            long hpLeft = h - cycles * damagePerCycle;

            long turnBegin = cycles * lcm;
            long turn = turnBegin;

            if (cycles != 0)
                System.arraycopy(cds, 0, next, 0, n);

            while (hpLeft > 0) {
                turn++;
                long time = turn - turnBegin;
                for (int i = 0; i < n; i++) {
                    if (next[i] <= time) {
                        hpLeft -= dmgs[i];
                        next[i] = time + cds[i];
                    }
                }

            }

            System.out.println(turn);
        }
    }

    public static long lcm(long a, long b) {
        long c = a;
        long d = b;

        while (b != 0) {
            long mod = a % b;
            a = b;
            b = mod;
        }

        return c * d / a;
    }
}
