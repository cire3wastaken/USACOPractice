package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class MaximumMultipleSum {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("2\n" +
                "3\n" +
                "15\n"));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int maxSum = 0;
            int sol = 0;

            int n = Integer.parseInt(br.readLine());
            for (int i = 2; i <= n; i++) {
                int maxMultipleMultiplier = (int) Math.floor((double) n / i);
                int curSum = 0;
                for (int j = 1; j <= maxMultipleMultiplier; j++) {
                    curSum += j * i;
                }

                if (curSum > maxSum) {
                    maxSum = curSum;
                    sol = i;
                }
            }

            System.out.println(sol);
        }
    }
}
