package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

public class GoodPrefixes {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("7\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "1\n" +
                "4\n" +
                "1 1 2 0\n" +
                "5\n" +
                "0 1 2 1 4\n" +
                "7\n" +
                "1 1 0 3 5 2 12\n" +
                "7\n" +
                "1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 294967296\n" +
                "10\n" +
                "0 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 589934592\n"));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] maxs = new long[n];
            long[] prefixSums = new long[n + 1];

            for (int i = 0; i < n; i++)
                prefixSums[i] = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                long yes = Long.parseLong(st.nextToken());

                if (i == 0)
                    maxs[i] = yes;
                else
                    maxs[i] = Math.max(maxs[i - 1], yes);

                prefixSums[i + 1] = yes + prefixSums[i];
            }

            long ans = getAns(n, maxs, prefixSums);

            System.out.println(ans);
        }
    }

    private static long getAns(int n, long[] maxs, long[] prefixes) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (maxs[i] == prefixes[i + 1] - maxs[i]) {
                ans++;
            }
        }
        return ans;
    }
}
