package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class GuessTheMaximumCf {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("6\n" +
                "4\n" +
                "2 4 1 7\n" +
                "5\n" +
                "1 2 3 4 5\n" +
                "2\n" +
                "1 1\n" +
                "3\n" +
                "37 8 16\n" +
                "5\n" +
                "10 10 10 10 9\n" +
                "10\n" +
                "3 12 9 5 2 3 2 9 8 2\n"));

        int n = Integer.parseInt(br.readLine());
    }
}
