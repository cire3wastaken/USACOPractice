package me.cire3.finalprograms.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoodPrefixesCfProblemC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
