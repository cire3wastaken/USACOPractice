package me.cire3.finalprograms.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StudyingAlgorithmsCfUsacoGuideProblemB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        int timeUsed = 0;
        int index = 0;

        while (true) {
            if (index == a.length)
                break;
            if (timeUsed + a[index] > x)
                break;
            timeUsed += a[index];
            index++;
        }

        System.out.println(index);
    }
}

