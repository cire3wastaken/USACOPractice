package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

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
            int[] dmgPerTurn = new int[n];

            for (int i = 0; i < n; i++)
                dmgs[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                dmgPerTurn[i] = dmgs[i] / Integer.parseInt(st.nextToken());
                System.out.println(dmgPerTurn[i]);
            }

            int totalDamagePerTurn = 0;
            for (int i = 0; i < n; i++) {
                totalDamagePerTurn += dmgPerTurn[i];
            }

            System.out.println((long) Math.ceil((float) h / totalDamagePerTurn));
        }
    }
}
