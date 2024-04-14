package me.cire3.drafts.usaco2024.january.bronze;

import java.io.*;
import java.util.*;

public class MajorityOpinion {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
            ("5\n5\n4 1 4 2 4\n6\n1 2 3 1 2 3\n6\n1 1 1 2 2 2\n3\n3 2 3\n2\n2 1").getBytes())));
        PrintWriter pw = new PrintWriter(System.out);
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            Set<Integer> possibleHay = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] favoriteHay = new int[n];
            for (int j = 0; j < n; j++) {
                favoriteHay[j] = Integer.parseInt(st.nextToken());
            }
            for (int k = 0; k < n - 2; k++) {
                if (favoriteHay[k] == favoriteHay[k + 1] || favoriteHay[k] == favoriteHay[k + 2])
                    possibleHay.add(favoriteHay[k]);
                if (favoriteHay[k + 1] == favoriteHay[k + 2])
                    possibleHay.add(favoriteHay[k + 1]);
            }
            if (possibleHay.size() != 0) {
                boolean printed = false;
                for (Integer integer : possibleHay) {
                    if (!printed) {
                        pw.print(integer);
                        printed = true;
                        continue;
                    }
                    pw.print(" ");
                    pw.print(integer);
                }
            } else
                pw.print(-1);
        }
    }
}
