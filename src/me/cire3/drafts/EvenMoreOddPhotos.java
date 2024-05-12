package me.cire3.drafts;

import java.io.*;
import java.util.*;

public class EvenMoreOddPhotos {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(("1\n" + "13").getBytes())));

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
                            // no UnsupportedOperationException if u create a new modifiable array
                            List<Integer> lastOdd = new ArrayList<>(solution.remove(solution.size() - 1));
                            List<Integer> lastEven = new ArrayList<>(solution.remove(solution.size() - 1));
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
                    List<Integer> temp = new ArrayList<>(solution.remove(solution.size() - 1));
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

    public static void stressTest() throws IOException {
        String testcase = "";
        BufferedReader br = null;

        try {
            for (int m = 0; m < 100000; m++) {
                testcase = "";
                Random random = new Random();

                int n = random.nextInt(1001);
                if (n == 0)
                    continue;

                testcase += n;
                testcase += "\n";

                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    int randomValue = random.nextInt(101);
                    if ((i & 1) == 0) {
                        if ((randomValue & 1) == 1) {
                            randomValue--;
                        }
                    } else if ((randomValue & 1) == 0) {
                        randomValue--;
                    }
                    builder.append(randomValue).append(" ");
                }
                testcase += builder.toString().trim();

                br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(testcase.getBytes())));
                br.readLine();
                solve(br, n);
            }
        } catch (Exception e) {
            if (br != null)
                br.close();

            System.out.println("Failed Testcase:");
            System.out.println(testcase);
            PrintWriter pw = new PrintWriter("failed_testcase.txt");
            pw.println(testcase);
            pw.close();
            return;
        }
        System.out.println("Passed all test cases");
    }
}
