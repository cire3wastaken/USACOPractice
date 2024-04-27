package me.cire3.drafts.usaco2024.january.bronze.finalized;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BalancingBacteriaUsacoJan2024BronzeProblem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

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
