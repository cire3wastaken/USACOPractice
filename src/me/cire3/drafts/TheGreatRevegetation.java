package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TheGreatRevegetation {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("5 6\n" +
                "4 1\n" +
                "4 2\n" +
                "4 3\n" +
                "2 5\n" +
                "1 2\n" +
                "1 5"));

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
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < 4; c++) {
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