package me.cire3.drafts.usaco2024.open.bronze;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LogicalMoos {
    public static void begin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(("5 7\n" +
                "false and true or true\n" +
                "1 1 false\n" +
                "1 3 true\n" +
                "1 5 false\n" +
                "3 3 true\n" +
                "3 3 false\n" +
                "5 5 false\n" +
                "5 5 true").getBytes())));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int q = Integer.parseInt(st1.nextToken());

        List<Operable> values = new ArrayList<>(n);

        st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0)
                values.add(new Boolean(java.lang.Boolean.parseBoolean(st1.nextToken())));
            else
                values.add(new Operation(st1.nextToken().equals("and")));
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            boolean wantedValue = java.lang.Boolean.parseBoolean(st.nextToken());

            List<Operable> afterQuery = new ArrayList<>(values);

            for (int j = l; j <= r; j++) {
                afterQuery.remove(j - 1);
            }
        }
    }

    private static boolean evaluate(List<Operable> operables) {
        List<Operable> newOperables = new ArrayList<>(operables);
        for (int i = 0; i < operables.size(); i++) {
            if (operables.get(i) instanceof Operation) {
                if ((((Operation) operables.get(i)).and)) {
                    boolean result = ((Boolean)operables.get(i - 1)).value && ((Boolean)operables.get(i + 1)).value;
                    newOperables.add(new Boolean(result));
                }
            }
//            newOperables.add();
        }

        for (int i = 0; i < operables.size(); i++) {
            if (operables.get(i) instanceof Operation) {

            }
        }
        return false;
    }

    private static class Boolean implements Operable {
        boolean value;

        public Boolean(boolean value) {
            this.value = value;
        }
    }

    private static class Operation implements Operable {
        boolean and;

        public Operation(boolean and) {
            this.and = and;
        }
    }

    private interface Operable {

    }
}
