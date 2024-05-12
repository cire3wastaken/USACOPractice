package me.cire3.finalprograms.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EvenMoreOddPhotosBronze2021JanProblem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        solve(br, n);
    }

    public static void solve(BufferedReader br, int n) throws IOException {
        Deque<Integer> evens = new ArrayDeque<>();
        Deque<Integer> odds = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if ((value & 1) == 0) {
                evens.add(value);
            } else {
                odds.add(value);
            }
        }

        List<List<Integer>> solution = new ArrayList<>();

        boolean toggle = false;

        for (int i = 0; i < n; i++) {
            Integer value;
            if (!toggle) {
                value = evens.peek();
                if (value != null) {
                    evens.pop();
                    solution.add(List.of(value));
                } else {
                    Integer v1 = odds.peek();
                    if (v1 != null) {
                        odds.pop();
                        Integer v2 = odds.peek();
                        if (v2 != null) {
                            odds.pop();
                            solution.add(List.of(v1, v2));
                        } else {
                            List<Integer> lastOdd = solution.remove(solution.size() - 1);
                            List<Integer> lastEven = solution.remove(solution.size() - 1);
                            // add lastOdd and value into lastEven, and append into array
                            List<Integer> coalescedList = new ArrayList<>(lastEven);
                            coalescedList.addAll(lastOdd);
                            coalescedList.add(v1);
                            solution.add(coalescedList);
                            // we can break loop now
                            break;
                        }
                    }
                }
            } else {
                value = odds.peek();
                if (value != null) {
                    odds.pop();
                    solution.add(List.of(value));
                } else {
                    // we cant make odds from evens
                    List<Integer> temp = solution.remove(solution.size() - 1);
                    Integer[] tempArr = new Integer[evens.size()];
                    evens.toArray(tempArr);
                    for (Integer integer : tempArr) {
                        temp.add(integer);
                    }
                    solution.add(temp);
                    break;
                }
            }
            toggle = !toggle;
        }

        System.out.println(solution.size());
    }
}
