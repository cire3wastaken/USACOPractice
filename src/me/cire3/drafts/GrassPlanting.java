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
        System.out.println(beginImpl("56\n" +
                "8 33\n" +
                "40 52\n" +
                "24 1\n" +
                "34 31\n" +
                "8 34\n" +
                "31 46\n" +
                "41 43\n" +
                "0 30\n" +
                "11 55\n" +
                "3 46\n" +
                "1 30\n" +
                "38 24\n" +
                "55 32\n" +
                "35 9\n" +
                "10 2\n" +
                "36 12\n" +
                "2 10\n" +
                "44 37\n" +
                "46 55\n" +
                "8 0\n" +
                "44 26\n" +
                "48 50\n" +
                "35 25\n" +
                "22 32\n" +
                "55 10\n" +
                "42 4\n" +
                "48 45\n" +
                "31 46\n" +
                "16 50\n" +
                "38 46\n" +
                "47 9\n" +
                "37 7\n" +
                "53 48\n" +
                "51 23\n" +
                "43 39\n" +
                "3 44\n" +
                "14 31\n" +
                "50 49\n" +
                "41 49\n" +
                "6 13\n" +
                "5 36\n" +
                "14 52\n" +
                "40 14\n" +
                "0 39\n" +
                "48 3\n" +
                "19 7\n" +
                "26 11\n" +
                "41 15\n" +
                "52 46\n" +
                "48 47\n" +
                "3 51\n" +
                "38 29\n" +
                "41 6\n" +
                "39 30\n" +
                "54 23"));
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

                int n = random.nextInt(1000) + 1;
                testcase += n;

                for (int i = 1; i < n; i++) {
                    testcase += "\n";
                    int random1 = random.nextInt(n - 1) + 1;
                    int random2 = random.nextInt(n - 1) + 1;

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