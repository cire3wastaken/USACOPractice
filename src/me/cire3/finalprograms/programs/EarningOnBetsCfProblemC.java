package me.cire3.finalprograms.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EarningOnBetsCfProblemC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
