package me.cire3.drafts.usaco2024.january.bronze;

import java.io.*;
import java.util.*;

public class MajorityOpinion {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
            ("10\n" +
                    "50\n" +
                    "30 23 23 30 27 27 30 3 36 30 26 7 30 43 23 30 42 42 30 11 11 30 4 28 30 5 5 30 50 50 30 43 43 30 35 13 30 31 31 30 44 44 30 20 20 30 13 44 30 20\n" +
                    "50\n" +
                    "46 15 41 28 41 17 34 2 32 27 6 34 17 43 21 27 2 32 33 20 50 1 43 39 46 16 3 37 10 19 10 38 35 33 2 25 12 27 31 15 37 9 18 48 6 30 11 3 8 29\n" +
                    "50\n" +
                    "39 11 24 14 11 44 44 11 2 2 11 23 22 11 39 7 11 31 23 11 36 36 11 36 17 11 15 47 11 32 29 11 13 13 11 14 14 11 8 8 11 5 5 11 12 42 11 2 2 11\n" +
                    "50\n" +
                    "24 18 7 32 30 36 8 11 26 27 5 43 22 50 25 44 33 44 22 46 11 28 29 45 27 38 15 42 5 30 20 38 2 2 41 6 21 2 49 35 42 6 39 21 1 46 32 21 5 19\n" +
                    "50\n" +
                    "35 22 22 35 1 1 35 46 46 35 34 42 35 40 40 35 48 34 35 1 11 35 23 2 35 16 18 35 13 13 35 41 4 35 21 32 35 3 23 35 9 9 35 49 49 35 9 9 35 4\n" +
                    "50\n" +
                    "34 24 4 28 30 10 37 7 1 42 1 19 27 8 31 29 7 35 14 29 47 12 12 15 40 22 15 7 5 33 37 10 34 22 42 5 19 32 28 32 32 3 32 15 6 9 17 4 36 33\n" +
                    "50\n" +
                    "25 49 49 25 37 34 25 11 50 25 39 39 25 1 1 25 24 24 25 6 7 25 5 5 25 17 29 25 11 39 25 47 47 25 43 34 25 32 2 25 29 31 25 29 29 25 32 24 25 2\n" +
                    "50\n" +
                    "50 4 30 40 43 20 38 42 31 30 1 33 21 31 3 23 2 17 3 26 34 35 34 10 46 9 40 45 43 45 24 50 18 43 23 8 18 38 12 15 17 41 43 14 27 49 6 21 7 38\n" +
                    "50\n" +
                    "43 25 49 49 25 12 5 25 17 17 25 3 3 25 13 42 25 18 18 25 41 27 25 24 34 25 16 45 25 1 47 25 29 5 25 4 34 25 12 14 25 31 33 25 38 47 25 16 49 25\n" +
                    "50\n" +
                    "32 31 2 36 26 13 11 46 17 13 43 48 23 31 14 42 27 1 26 25 23 17 32 46 29 8 8 44 29 11 14 48 30 45 47 12 45 41 4 19 25 7 30 43 27 17 46 22 47 22\n").getBytes())));
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
            for (int k = 0; k < n; k++) {
                if (k < n - 2) {
                    if (favoriteHay[k] == favoriteHay[k + 1] || favoriteHay[k] == favoriteHay[k + 2])
                        possibleHay.add(favoriteHay[k]);
                }
                if (k == n - 2 && n != 2) {
                    if (favoriteHay[k] == favoriteHay[k + 1])
                        possibleHay.add(favoriteHay[k]);
                }
                if (n == 2) {
                    if (favoriteHay[0] == favoriteHay[1])
                        possibleHay.add(favoriteHay[0]);
                    break;
                }
            }
            if (possibleHay.size() != 0) {
                List<Integer> sortedHay = new ArrayList<>(possibleHay);
                Collections.sort(sortedHay);
                pw.print(sortedHay.get(0));

                for (int j = 1; j < sortedHay.size(); j++) {
                    pw.print(" ");
                    pw.print(sortedHay.get(j));
                }
                pw.println();
            } else
                pw.println(-1);
        }
        pw.close();
    }
}
