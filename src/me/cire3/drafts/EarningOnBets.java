package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

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

        }
    }
}
