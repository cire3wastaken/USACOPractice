package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WatchMooloo {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
                ("2 4\n" +
                "7 9").getBytes())));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }

        int totalK = 0;
        int accumCost = 0;

        int lastDay = 0;
        int baseToAdd = 0;
        for (int i = 0; i < n; i++) {
            int day = days[i];

        }
    }
}
