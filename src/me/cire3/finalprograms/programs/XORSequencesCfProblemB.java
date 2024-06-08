package me.cire3.finalprograms.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XORSequencesCfProblemB {
    public static final int MAX_ITERATIONS = (int) Math.ceil(Math.log(Math.pow(10, 9)) / Math.log(2));
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = 0; j < MAX_ITERATIONS; j++) {
                if ((x & (int) Math.pow(2, j)) != (y & (int) Math.pow(2, j))) {
                    System.out.println((int)Math.pow(2, j));
                    break;
                }
            }
        }
    }
}
