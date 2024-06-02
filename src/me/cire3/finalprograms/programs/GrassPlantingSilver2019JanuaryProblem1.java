package me.cire3.finalprograms.programs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@SuppressWarnings("rawtypes")
public class GrassPlantingSilver2019JanuaryProblem1 {
    static boolean[] visited;
    static int[] types;
    static List<Integer>[] neighbors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("planting.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("planting.out"));

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

        dfs(0, 0);

        int mType = 0;
        for (int t : types)
            mType = Math.max(mType, t);

        pw.println(mType);
        pw.close();
    }

    private static void dfs(int node, int prevNode) {
        int type = 1;

        for (int n : neighbors[node]) {
            if (n == prevNode)
                continue;

            while (type == types[node] || type == types[prevNode])
                type++;

            types[n] = type;

            dfs(n, node);

            type++;
        }
    }
}