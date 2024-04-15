package me.cire3.drafts.usaco2024.january.bronze.finalized;

import java.io.*;
import java.util.StringTokenizer;

public class CannonballUsacoJan2024BronzeProblem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int currentLocation = Integer.parseInt(tokenizer.nextToken()) - 1;
        int direction = 1;
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

        int max = 0;
        while (true) {
            if (max > 5e6)
                break;
            if (currentLocation >= n || currentLocation < 0)
                break;
            // jump pad
            if (types[currentLocation] == 0) {
                direction = (direction == -1 ? 1 : -1);
                power += values[currentLocation];
            }
            if (types[currentLocation] == 1) {
                if (power >= values[currentLocation] && !broken[currentLocation]) {
                    broken[currentLocation] = true;
                    targetsBroken++;
                }
            }
            currentLocation += power * direction;
            max++;
        }
        pw.println(targetsBroken);
        pw.close();
    }
}
