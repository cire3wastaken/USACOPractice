package me.cire3.drafts;

import me.cire3.finalprograms.programs.XORSequencesCfProblemB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

public class XORSequences {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("4\n" +
                "0 1\n" +
                "12 4\n" +
                "57 37\n" +
                "316560849 14570961\n"));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = 0; j < XORSequencesCfProblemB.MAX_ITERATIONS; j++) {
                if ((x & (int) Math.pow(2, j)) != (y & (int) Math.pow(2, j))) {
                    System.out.println((int)Math.pow(2, j));
                    break;
                }
            }
        }
    }
}