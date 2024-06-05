package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
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
            outgoingPaths[Integer.parseInt(st.nextToken()) - 1]++;
        }

        br.close();

        int index = -2;
        for (int i = 0; i < n; i++) {
            if (outgoingPaths[i] == 0) {
                if (index != -2) {
                    index = -2;
                    break;
                }
                index = i;
            }
        }

        System.out.println(index + 1);
    }
}
