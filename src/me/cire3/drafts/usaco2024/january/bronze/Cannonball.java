package me.cire3.drafts.usaco2024.january.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class Cannonball {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(("5 2\n" +
                "0 1\n" +
                "1 1\n" +
                "1 2\n" +
                "0 1\n" +
                "1 1"
                ).getBytes())));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int currentLocation = Integer.parseInt(tokenizer.nextToken()) - 1;
        // 0 = right, 1 = left
        int direction = 0;
        int power = 1;
        int targetsBroken = 0;
        int[] types = new int[n];
        int[] values = new int[n];
        boolean[] broken = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            types[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            if (currentLocation >= n || currentLocation < 0)
                break;
            // jump pad
            if (types[currentLocation] == 0) {
                direction = (direction == 0 ? 1 : 0);
                power += values[currentLocation];
            }
            if (types[currentLocation] == 1) {
                if (power >= values[currentLocation] && !broken[currentLocation]) {
                    broken[currentLocation] = true;
                    targetsBroken++;
                }
            }
            if (direction == 0)
                currentLocation += power;
            else
                 currentLocation -= power;
        }
        pw.println(targetsBroken);
        pw.close();
    }
}
