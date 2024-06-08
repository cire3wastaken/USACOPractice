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
    }
}
