package me.cire3.drafts.usaco2024.january.bronze;

import java.io.*;
import java.util.StringTokenizer;

// solution is O(n^2)
public class BalancingBacteria {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(("5\n" +
                "1 3 -2 -7 5").getBytes())));

        int n = Integer.parseInt(br.readLine());

        long operations = 0;
        long sum = 0;
        long diff = 0;
        long[] originals = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            originals[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            originals[i] += sum - diff - (i == 0 ? 0 : originals[i - 1]);
            long original = originals[i];
            if (original == 0)
                continue;
            if (original < 0)
                sum -= original;
            else diff += original;
        }

        System.out.println(sum + diff);
    }
}
