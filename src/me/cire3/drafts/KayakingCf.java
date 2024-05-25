package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**+
 * O(n)
 * */
public class KayakingCf {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(("2\n" +
                "1 2 3 4").getBytes())));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] weights = new Integer[2 * n];

        for (int i = 0; i < n * 2; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weights);

        int minX = -1;
        for (int i = 0; i < n * 2; i++) {
            for (int j = i + 1; j < n * 2; j++) {
                List<Integer> w = new ArrayList<>();
                for (int k = 0; k ++< weights.length;)
                    if (k != j && k != i)
                        w.add(weights[k]);

                int x = 0;
                for (int k = 0; k < n - 2; k += 2)
                    x += w.get(k + 1) - w.get(k);

                minX = Math.min(x, minX);
            }
        }

        System.out.println(minX);
        br.close();
    }
}
