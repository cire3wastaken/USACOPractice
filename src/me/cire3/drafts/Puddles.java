package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Puddles {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean[][] field = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                field[i][j] = str.toCharArray()[j] == '#';
            }
        }

        int ponds = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (field[i][j]) {
                    boolean checkPlusOneHorizontal = true, checkPlusOneVertical = true;
                    if (j == c - 1)
                        checkPlusOneHorizontal = false;
                    if (i == r - 1)
                        checkPlusOneVertical = false;

                    if (checkPlusOneHorizontal)
                        if (field[i][j + 1]) continue;
                    if (checkPlusOneVertical)
                        if (field[i + 1][j]) continue;
                    ponds++;
                }
            }
        }

        System.out.println(ponds);
    }
}
