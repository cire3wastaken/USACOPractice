package me.cire3.drafts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("rawtypes")
public class GrassPlanting {
    static boolean[] visited;
    static int[] types;
    static List<Integer>[] neighbors;
    public static void begin() throws IOException {
        System.out.println(beginImpl("4\n" +
                "1 2\n" +
                "4 3\n" +
                "2 3"));
    }

    private static String beginImpl(String testcase) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(testcase));

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

        return mType + "";
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

    public static void stressTest() throws IOException {
        String testcase = "";

        try {
            for (int m = 0; m < 100000; m++) {
                testcase = "";
                Random random = new Random();

                int n = random.nextInt(1001);
                testcase += n;

                for (int i = 1; i < n; i++) {
                    testcase += "\n";
                    int random1 = random.nextInt(n);
                    int random2 = random.nextInt(n);

                    if (random1 == random2) {
                        if (random2 < n - 1)
                            random2++;
                        else
                            random2--;
                    }

                    testcase += random1 + " " + random2;
                }

                beginImpl(testcase);
            }
        } catch (Exception e) {
            System.out.println("Failed Testcase:");
            System.out.println(testcase);
            PrintWriter pw = new PrintWriter("failed_testcase.txt");
            pw.println(testcase);
            pw.close();
            return;
        }
        System.out.println("Passed all test cases");
    }
}