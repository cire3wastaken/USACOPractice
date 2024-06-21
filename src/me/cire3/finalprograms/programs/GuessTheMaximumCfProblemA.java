package me.cire3.finalprograms.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuessTheMaximumCfProblemA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int smallest = Integer.MAX_VALUE;
            int[] numbers = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                numbers[j] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n - 1; j++)
                smallest = Math.min(smallest, Math.max(numbers[j], numbers[j + 1]));

            System.out.println(smallest - 1);
        }
    }
}
