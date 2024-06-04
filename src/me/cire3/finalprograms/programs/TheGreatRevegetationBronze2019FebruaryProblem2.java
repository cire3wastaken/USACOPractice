package me.cire3.finalprograms.programs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TheGreatRevegetationBronze2019FebruaryProblem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));

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
            pw.print(color);
        pw.close();
        br.close();
    }
}
