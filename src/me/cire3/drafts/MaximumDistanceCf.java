package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumDistanceCf {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++)
            x[i] = Integer.parseInt(st1.nextToken());
        for (int i = 0; i < n; i++)
            y[i] = Integer.parseInt(st2.nextToken());

        long maxDistance = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = x[i] - x[j];
                int dy = y[i] - y[j];

                long dist = (long) dx * dx + (long) dy * dy;

                if (dist > maxDistance)
                    maxDistance = dist;
            }
        }

        System.out.println(maxDistance);
    }
}
