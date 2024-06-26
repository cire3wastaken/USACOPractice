package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MilkMeasurementUsaco {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(("4\n" +
                "7 Mildred +3\n" +
                "4 Elsie -1\n" +
                "9 Mildred -1\n" +
                "1 Bessie +2").getBytes())));

        int n = Integer.parseInt(br.readLine());
        int m = 7, e = 7, b = 7;

        // day is the index
        int[] bessie = new int[100];
        int[] mildred = new int[100];
        int[] elsie = new int[100];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken()) - 1;
            switch (st.nextToken()) {
                case "Mildred":
                    mildred[day] = Integer.parseInt(st.nextToken());
                    break;
                case "Bessie":
                    bessie[day] = Integer.parseInt(st.nextToken());
                    break;
                case "Elsie":
                    elsie[day] = Integer.parseInt(st.nextToken());
                    break;
            }
        }

        boolean[] shown = new boolean[3];
        int changes = 0;

        for (int i = 0; i < 100; i++) {
            boolean[] snapshot = Arrays.copyOf(shown, 3);
            b += bessie[i];
            m += mildred[i];
            e += elsie[i];

            int max = 0;
            max = Math.max(b, max);
            max = Math.max(m, max);
            max = Math.max(e, max);

            shown[0] = b == max;
            shown[1] = m == max;
            shown[2] = e == max;

            if (!Arrays.equals(snapshot, shown))
                changes++;
        }
        System.out.println(changes);
    }
}
