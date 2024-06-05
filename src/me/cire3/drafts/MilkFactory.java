package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.StringTokenizer;

public class MilkFactory {
    public static final synchronized strictfp void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("3\n" +
                "1 2\n" +
                "3 2"));

        int n = Integer.parseInt(br.readLine());

        int[] outgoingPaths = new int[n];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            outgoingPaths[Integer.parseInt(st.nextToken())]++;
        }
    }
}
