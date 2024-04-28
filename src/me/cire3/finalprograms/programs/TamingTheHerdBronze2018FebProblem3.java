package me.cire3.finalprograms.programs;

import java.io.*;
import java.util.*;

public class TamingTheHerdBronze2018FebProblem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("taming.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("taming.out"));
        int n = Integer.parseInt(br.readLine());
        Integer[] logs = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            logs[i] = Integer.parseInt(st.nextToken());

        int must = 0;
        int lastZero = 0; // 0
        logs[0] = 0;
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
                }
            }
        }

        int could = 0;
        for (int value : logs) {
            if (value == 0)
                must++;
            if (value == -1)
                could++;
        }

        pw.println((must) + " " + (must + could));
        br.close();
        pw.close();
    }
}