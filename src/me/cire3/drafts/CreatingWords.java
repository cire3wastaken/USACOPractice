package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

public class CreatingWords {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("6\n" +
                "bit set\n" +
                "cat dog\n" +
                "hot dog\n" +
                "uwu owo\n" +
                "cat cat\n" +
                "zzz zzz\n"));
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
