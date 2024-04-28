package me.cire3.drafts;

import java.io.*;
import java.util.StringTokenizer;

public class Race {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
                ("10 5\n" +
                        "1\n" +
                        "2\n" +
                        "3\n" +
                        "4\n" +
                        "5").getBytes()
        )));
//        BufferedReader br = new BufferedReader(new FileReader("race.in"));
//        FileWriter fw = new FileWriter("race.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        long k = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        for (int i = 0; i < n; i++) {
            solve(k, Long.parseLong(br.readLine()));
        }
    }

    public static void solve(long k, long x) {
        long leftSideSum = 0;
        long rightSideSum = 0;
        long timeSpent = 0;
        // int will not overflow, since it can store up to 10^9/2 + 1
        int currentSpeed = 0;

        while (leftSideSum + rightSideSum < k) {
            currentSpeed++;
            leftSideSum += currentSpeed;
            timeSpent++;

            if (leftSideSum + rightSideSum >= k)
                break;

            if (currentSpeed >= x) {
                rightSideSum += currentSpeed;
                timeSpent++;
            }
        }
        System.out.println(timeSpent);
    }
}
