package me.cire3.finalprograms.programs;

import java.io.*;
import java.util.*;

// the USACO problem: https://usaco.org/index.php?page=viewproblem2&cpid=669
// We can solve this problem by creating a Disjoint Set Union, and iterate over all vertices
// Since they are all originally pair-wise disconnected we can loop over the edges
// and add an edge between two vertices which are not already connected.
// After adding all N - 1 edges, the last edge we added is the solution to the problem
// This hands us a O(N) time complexity solution, because the tree's depth is linear
// which will pass without TLE. Notably, we can improve
// the runtime by using path compression, and memoize all Find(parent[x]) calls

public class MooCastGold2016December {
    public static void main(String[] args) throws IOException {
        // for testing purposes
//        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(("4\n" +
//                "1 3\n" +
//                "5 4\n" +
//                "7 2\n" +
//                "6 1").getBytes())));
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));

        // read in how many cows
        int n = Integer.parseInt(br.readLine());

        // array of X values
        int[] xs = new int[n];

        // array of Y values
        int[] ys = new int[n];

        // loop to take in input
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }

        // create a DSU (Disjoint Set Union),
        DisjointSets sets = new DisjointSets(n);

        List<WeightedEdge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                edges.add(new WeightedEdge(i, j, (xs[i] - xs[j]) * (xs[i] - xs[j]) + (ys[i] - ys[j]) * (ys[i] - ys[j])));
            }
        }
        // sort the edges based on weight/length
        // edges implement Comparable, so check compareTo
        Collections.sort(edges);


        int lastW = 0;
        int numConnected = n;

        for(WeightedEdge curr : edges) {
            if(sets.find(curr.vertexA) != sets.find(curr.vertexB)) {
                sets.unite(curr.vertexA, curr.vertexB);
                lastW = curr.weight;
                if(--numConnected == 1) {
                    break;
                }
            }
        }
        pw.println(lastW);
        pw.close();
//      testing
//      System.out.println(lastW);
    }

    static class DisjointSets {
        int[] parents;

        public DisjointSets(int size) {
            parents = new int[size];
            for (int i = 0; i < size; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            return parents[x] == x ? x : (parents[x] = find(parents[x]));
        }

        public void unite(int x, int y) {
            parents[find(x)] = find(y);
        }
    }

    static class WeightedEdge implements Comparable<WeightedEdge> {
        int vertexA, vertexB, weight;

        public WeightedEdge(int a, int b, int c){
            vertexA=a;
            vertexB=b;
            weight=c;
        }
        public int compareTo(WeightedEdge e) {
            return weight - e.weight;
        }
    }
}