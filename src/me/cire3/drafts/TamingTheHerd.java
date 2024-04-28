package me.cire3.drafts;

import java.io.*;
import java.util.*;

public class TamingTheHerd {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
                ("10\n" +
                        "0 1 2 3 4 5 6 -1 -1 1\n").getBytes()
        )));

//        BufferedReader br = new BufferedReader(new FileReader("taming.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("taming.out"));
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
            System.out.println(-1);
            return;
        }

        System.out.println(Arrays.toString(logs));
        System.out.println((must - 1) + " " + (must + could - 1));
        br.close();
//        pw.close();
    }
}
