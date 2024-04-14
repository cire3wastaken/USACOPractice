package me.cire3.drafts.usaco2024.january.bronze.finalized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class MajorityOpinionUsacoJan2024BronzeProblem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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