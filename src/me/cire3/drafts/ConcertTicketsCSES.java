package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConcertTicketsCSES {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(("4 3 5\n" +
//                "60 45 80 60\n" +
//                "30 60 75").getBytes())));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // force mergesort - O(n log n)
        Integer[] prices = new Integer[n];
        Integer[] maxPrices = new Integer[m];
        boolean[] sold = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            maxPrices[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(maxPrices);
        Arrays.sort(prices);

        for (int i = 0; i < m; i++) {
            int maxPrice = maxPrices[i];
            for (int j = 0; j < n; j++) {
                if (prices[j] == maxPrice){
                    System.out.println(prices[j]);
                    sold[j] = true;
                }
                if (j == n - 1 && prices[j] <= maxPrice && !sold[j]) {
                    sold[j] = true;
                    System.out.println(prices[j]);
                } else if (prices[j] <= maxPrice && (j + 1 == n || prices[j + 1] > maxPrice) && !sold[j]) {
                    sold[j] = true;
                    System.out.println(prices[j]);
                }
            }
        }
    }
}
