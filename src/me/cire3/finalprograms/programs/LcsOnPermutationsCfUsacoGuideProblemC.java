package me.cire3.finalprograms.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LcsOnPermutationsCfUsacoGuideProblemC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < n; i++)
            a.add(i, Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            b.add(i, Integer.parseInt(st.nextToken()));

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            boolean foundFirst = false;
            int lastB = 0;
            int length = 0;

            for (int x = i; x < n; x++) {
                List<Integer> indices = indicesOf(b, a.get(x));
                if (indices.size() == 0)
                    continue;
                if (!foundFirst) {
                    foundFirst = true;
                    length++;
                    lastB = indices.get(0);
                }

                for (int index : indices) {
                    if (lastB < index) {
                        length++;
                        lastB = index;
                        break;
                    }
                }
            }

            if (maxLength < length)
                maxLength = length;
        }

        System.out.println(maxLength);
    }

    public static <T> List<Integer> indicesOf(List<T> list, T o) {
        List<Integer> indices = new ArrayList<>();

        if (o == null) {
            for (int i = 0; i < list.size(); i++)
                if (list.get(i) == null)
                    indices.add(i);
        } else {
            for (int i = 0; i < list.size(); i++)
                if (o.equals(list.get(i)))
                    indices.add(i);
        }
        return indices;
    }
}
