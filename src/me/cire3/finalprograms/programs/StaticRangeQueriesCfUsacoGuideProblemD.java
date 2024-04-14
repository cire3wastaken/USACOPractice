package me.cire3.finalprograms.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StaticRangeQueriesCfUsacoGuideProblemD {
    public static void main(String[] args) throws IOException {
        int[] a = new int[(int) 2e5];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(tokenizer.nextToken());
            int r = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            for (int j = l; j < r; j++) {
                a[j] += v;
            }
        }
        for (int i = 0; i < q; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(tokenizer.nextToken());
            int r = Integer.parseInt(tokenizer.nextToken());
            int value = 0;
            for (int j = l; j < r; j++) {
                value += a[j];
            }
            System.out.println(value);
        }
    }
}
