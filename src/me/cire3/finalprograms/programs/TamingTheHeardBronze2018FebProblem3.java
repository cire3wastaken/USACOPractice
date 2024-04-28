package me.cire3.finalprograms.programs;

import java.io.*;
import java.util.*;

public class TamingTheHeardBronze2018FebProblem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("taming.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("taming.out"));
        int n = Integer.parseInt(br.readLine());
        Integer[] logs = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            logs[i] = Integer.parseInt(st.nextToken());

        int must = n;
        int lastZero = 0; // 0
        logs[0] = 0;
        Set<Integer> indexesCounted = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (logs[i] > 0) {
                if (i - logs[i] < 0) {
                    pw.println(-1);
                    pw.close();
                    return;
                }

                if (i - lastZero < logs[i]) {
                    pw.println(-1);
                    pw.close();
                    return;
                }

                for (int j = i - logs[i]; j < i; j++) {
                    logs[j] = logs[i] + j - i;
                    if (logs[j] == 0)
                        lastZero = j;
                    if (indexesCounted.add(j))
                        must--;
                }
            }
        }

        int could = 0;
        for (int value : logs)
            if (value == -1)
                could++;

        if (must == 1) {
            pw.println(-1);
            pw.close();
            return;
        }

        pw.println((must - 1) + " " + (must + could - 1));
        br.close();
        pw.close();
    }
}