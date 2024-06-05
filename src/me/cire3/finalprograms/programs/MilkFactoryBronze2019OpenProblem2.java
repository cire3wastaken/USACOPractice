package me.cire3.finalprograms.programs;

import java.io.*;
import java.util.StringTokenizer;

public class MilkFactoryBronze2019OpenProblem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("factory.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("factory.out"));

        int n = Integer.parseInt(br.readLine());

        int[] outgoingPaths = new int[n];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            outgoingPaths[Integer.parseInt(st.nextToken()) - 1]++;
        }

        br.close();

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (outgoingPaths[i] == 0) {
                if (index != -1) {
                    index = -1;
                    break;
                }
                index = i;
            }
        }

        pw.println(index == -1 ? -1 : index + 1);
        pw.close();
    }
}
