package me.cire3.finalprograms.programs;

import java.io.*;

public class CowTippingBronze2017JanuaryProblem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowtip.out"));

        int n = Integer.parseInt(br.readLine());

        boolean[][] tipped = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < n; j++)
                tipped[i][j] = Integer.parseInt(String.valueOf(str[j])) == 1;
        }

        int flips = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (tipped[i][j]) {
                    for (int k = 0; k <= i; k++) {
                        for (int l = 0; l <= j; l++) {
                            tipped[k][l] = !tipped[k][l];
                        }
                    }
                    flips++;
                }
            }
        }

        pw.println(flips);
        pw.close();
    }
}
