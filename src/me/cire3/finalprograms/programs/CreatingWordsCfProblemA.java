package me.cire3.finalprograms.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CreatingWordsCfProblemA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            System.out.print(b.charAt(0));
            System.out.print(a.substring(1));
            System.out.print(" ");
            System.out.print(a.charAt(0));
            System.out.print(b.substring(1));
            System.out.println();
        }
    }
}
