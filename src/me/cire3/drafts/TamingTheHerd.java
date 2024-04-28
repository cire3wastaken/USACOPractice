package me.cire3.drafts;

import java.io.*;
import java.util.*;

public class TamingTheHerd {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
                ("50\n" +
                        "0 -1 2 3 0 1 2 3 4 5 6 -1 8 9 10 11 12 13 -1 15 16 17 18 -1 20 21 -1 23 24 25 0 1 2 3 0 1 2 3 4 5 6 -1 8 9 10 11 12 13 14 0").getBytes()
        )));

//        BufferedReader br = new BufferedReader(new FileReader("taming.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("taming.out"));
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
                    System.out.println(-1);
                    return;
                }

                if (i - lastZero < logs[i]) {
                    System.out.println(-1);
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

        System.out.println(Arrays.toString(logs));
        System.out.println((must) + " " + (must + could));
        br.close();
//        pw.close();
    }
}
