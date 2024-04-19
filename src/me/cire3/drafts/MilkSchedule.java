package me.cire3.drafts;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MilkSchedule {
    public static void begin() throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[] endingTimes = new int[n];

        for (int i = 0; i < n; i++) {
            endingTimes[i] = (i == 0) ? scanner.nextInt() : endingTimes[i - 1] + scanner.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int time = scanner.nextInt();
            if (time == 0)
                System.out.println(1);
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    if (time < endingTimes[j])
                        System.out.println(j + 1);
                if (time < endingTimes[j] && time >= endingTimes[j - 1])
                    System.out.println(j + 1);
            }
        }
    }
}
