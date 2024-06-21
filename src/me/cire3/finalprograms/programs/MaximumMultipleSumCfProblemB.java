package me.cire3.finalprograms.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumMultipleSumCfProblemB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
