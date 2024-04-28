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
        int startedDay = 0;
        for (int i = 0; i < n; i++) {
            int day = days[i];

            if (i == 0) {
                accumCost++;
                totalK++;
            } else {
                int addToAccumCost = (day - startedDay + 1) * (day - startedDay + 2) / 2 - ((lastDay - startedDay + 1) * (lastDay  - startedDay + 2) / 2);

                if (addToAccumCost > k) {
                    startedDay = day;
                    totalK++;
                    accumCost++;
                } else {
                    accumCost += addToAccumCost;
                    totalK += day - lastDay + 1;
                }
                lastDay = day;
            }
        }

        System.out.println(accumCost + totalK);
    }
}
