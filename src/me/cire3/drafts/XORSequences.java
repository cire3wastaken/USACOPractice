package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class XORSequences {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("4\n" +
                "0 1\n" +
                "12 4\n" +
                "57 37\n" +
                "316560849 14570961\n"));
        int t = Integer.parseInt(br.readLine());
        int MAX_ITERATIONS = (int) Math.ceil(Math.log(Math.pow(10, 9)) / Math.log(2));

        for (int i = 0; i < t; i++) {
        }
    }
}
