package me.cire3.finalprograms.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ManhattanCircleCfProblemD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[][] grid = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                String string = br.readLine();
                for (int j = 0; j < m; j++)
                    grid[i][j] = string.charAt(j) == '#';
            }

            int largestRadius = 0;
            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j]) {
                        int radius = 1;
                        while (true) {
                            boolean radiusWorks = doesRadiusWork(radius, i, j, grid);
                            if (radiusWorks)
                                radius++;
                            else {
                                if (radius > largestRadius) {
                                    largestRadius = radius;
                                    x = i;
                                    y = j;
                                }
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println((x + 1) + " " + (y + 1));
        }
    }

    public static boolean doesRadiusWork(int radius, int x, int y, boolean[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return false;
        if (x - radius < 0 || y - radius < 0 || x + radius >= grid.length || y + radius >= grid[0].length)
            return false;
        if (!grid[x][y])
            return false;
        return grid[x][y - radius] && grid[x][y + radius] && grid[x + radius][y] && grid[x - radius][y];
    }
}
