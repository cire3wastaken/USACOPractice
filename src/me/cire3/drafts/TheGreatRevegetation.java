package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TheGreatRevegetation {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("25 29\n" +
                "23 4\n" +
                "12 16\n" +
                "7 9\n" +
                "20 25\n" +
                "4 22\n" +
                "8 5\n" +
                "4 20\n" +
                "21 19\n" +
                "9 16\n" +
                "16 25\n" +
                "22 24\n" +
                "22 2\n" +
                "5 14\n" +
                "17 1\n" +
                "19 1\n" +
                "10 15\n" +
                "25 15\n" +
                "13 7\n" +
                "19 17\n" +
                "10 12\n" +
                "8 2\n" +
                "1 8\n" +
                "9 21\n" +
                "5 13\n" +
                "20 18\n" +
                "6 15\n" +
                "24 12\n" +
                "6 2\n" +
                "24 7\n"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] neighbors = new List[n];

        for (int i = 0; i < n; i++)
            neighbors[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            x--;
            y--;

            neighbors[x].add(y);
            neighbors[y].add(x);
        }

        int[] colors = new int[n];
        colors[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= 4; c++) {
                boolean invalid = false;

                for (int j : neighbors[i])
                    if (colors[j] == c) {
                        invalid = true;
                        break;
                    }

                if (!invalid) {
                    colors[i] = c;
                    break;
                }
            }
        }

        for (int color : colors)
            System.out.print(color);
    }
}