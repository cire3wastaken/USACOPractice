package me.cire3.drafts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LcsOnPermutationsCf {
    public static void begin() throws IOException {

    }

    private static <T> List<List<T>> generateSubArrays(T[] arr) {
        List<List<T>> results = new ArrayList<>();
        List<List<T>> inProgress = new ArrayList<>();

        for (T obj : arr) {
            List<List<T>> next = new ArrayList<>();

            for (List<T> sub : inProgress) {
                results.add(sub);

                List<T> copy = new ArrayList<>(sub);
                copy.add(obj);
                next.add(copy);
            }

            next.add(List.of(obj));
            inProgress = next;
        }

        results.addAll(inProgress);
        return results;
    }
}
