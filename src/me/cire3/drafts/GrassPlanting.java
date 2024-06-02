package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@SuppressWarnings("rawtypes")
public class GrassPlanting {
    static boolean[] visited;
    static int[] types;
    static List<Integer>[] neighbors;
    public void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("4\n" +
                "1 2\n" +
                "4 3\n" +
                "2 3"));

        int n = Integer.parseInt(br.readLine());

        neighbors = new List[n];
        types = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++)
            neighbors[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            first--;
            second--;
            neighbors[first].add(second);
            neighbors[second].add(first);
        }
    }
}