package me.cire3.drafts;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FencePainting {
    public static void begin() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int lower, higher;
        lower = scanner.nextInt();
        higher = scanner.nextInt();

        Set<Integer> values = new HashSet<>();
        for (int i = lower + 1; i <= higher; i++) {
            values.add(i);
        }

        int possibleLower, possibleHigher;
        possibleLower = scanner.nextInt();
        possibleHigher = scanner.nextInt();

        for (int i = possibleLower + 1; i <= possibleHigher; i++) {
            values.add(i);
        }

        System.out.println(values.size());
    }
}
