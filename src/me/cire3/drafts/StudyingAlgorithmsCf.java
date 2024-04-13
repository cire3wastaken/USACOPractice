package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StudyingAlgorithmsCf {
    public static void begin() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new  ByteArrayInputStream("6 15\n4 3 8 4 7 3".getBytes())));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        int timeLeft = x;
        int index = 0;

        while (timeLeft >= a[index + 1]) {
            timeLeft -= a[index];
            index++;
        }

        System.out.println(index + 1);
    }

}
