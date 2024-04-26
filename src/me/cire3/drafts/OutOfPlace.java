package me.cire3.drafts;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class OutOfPlace {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(("6\n" +
                "2\n" +
                "4\n" +
                "7\n" +
                "7\n" +
                "9\n" +
                "3").getBytes())));
//        BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("outofplace.out"));

        int n = Integer.parseInt(br.readLine());

        // force mergesort
        Integer[] sorted = new Integer[n];
        Integer[] heights = new Integer[n];
        for (int i = 0; i < n; i++)
            heights[i] = sorted[i] = Integer.parseInt(br.readLine());

        Arrays.sort(sorted);

        int count = 0;
        for (int i = 0; i < n; i++)
            if (heights[i].intValue() != sorted[i].intValue())
                count++;
        System.out.println(Math.max(0, count - 1));
        pw.close();
    }
}
