package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

// FIXME
public class EarningOnBets {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("6\n" +
                "3\n" +
                "3 2 7\n" +
                "2\n" +
                "3 3\n" +
                "5\n" +
                "5 5 5 5 5\n" +
                "6\n" +
                "7 9 3 17 9 13\n" +
                "3\n" +
                "6 3 2\n" +
                "5\n" +
                "9 4 6 8 3\n"));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            int lcm = 1;
            for (int j = 0; j < n; j++)
                lcm = lcm(lcm, arr[j] = Integer.parseInt(st.nextToken()));

            int a = 0;
            for (int j : arr)
                a += 1 / j;

            if (a >= 1) {
                System.out.println(-1);
                continue;
            }

            for (int j = 0; j < n; j++)
                System.out.print(lcm / arr[j] + " ");
            System.out.println();
        }
    }

    public static int lcm(int a, int b) {
        int c = a;
        int d = b;

        while (b != 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }

        return c * d / a;
    }
}
