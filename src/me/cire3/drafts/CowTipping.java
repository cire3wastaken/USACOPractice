package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < n; j++)
                tipped[i][j] = Integer.parseInt(String.valueOf(str[j])) == 1;
        }

        int flips = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (tipped[i][j]) {
                    for (int k = 0; k < i; k++) {
                        for (int l = 0; l < j; l++) {
                            tipped[k][l] = !tipped[k][l];
                        }
                    }
                    flips++;
                }
            }
        }

        System.out.println(flips);
    }
}
