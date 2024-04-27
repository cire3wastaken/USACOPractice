//package me.cire3.finalprograms.programs;

import java.io.*;
import java.util.StringTokenizer;

public class RaceBronze2020JanProblem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("race.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("race.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long k = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        for (int i = 0; i < n; i++) {
            solve(k, Long.parseLong(br.readLine()), pw);
        }
    }

    public static void solve(long k, long x, PrintWriter pw) throws IOException {
        long leftSideSum = 0;
        long rightSideSum = 0;
        long timeSpent = 0;

        for (long currentSpeed = 0;; currentSpeed++) {
            leftSideSum += currentSpeed;
            timeSpent++;

            if (leftSideSum + rightSideSum >= k) {
                pw.println((int) (timeSpent - 1));
                return;
            }

            if (currentSpeed >= x) {
                rightSideSum += currentSpeed;
                timeSpent++;

                if (leftSideSum + rightSideSum >= k) {
                    pw.println(timeSpent - 1);
                    return;
                }
            }
        }
    }
}
