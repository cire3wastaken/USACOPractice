package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowTipping {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(("3\n" +
                "001\n" +
                "111\n" +
                "111").getBytes())));

        int n = Integer.parseInt(br.readLine());

        boolean[][] tipped = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                tipped[i][j] = Integer.parseInt(st.nextToken()) == 1;
        }

        for (int i = n - 1; i >= 0; i--) {

        }
    }
}
