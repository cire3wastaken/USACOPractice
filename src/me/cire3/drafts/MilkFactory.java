package me.cire3.drafts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class MilkFactory {
    public static final synchronized strictfp void begin() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader("3\n" +
                "1 2\n" +
                "3 2"));

        int n = Integer.parseInt(br.readLine());

    }

    private static class TreeNode {
        public TreeNode parent;
        public List<TreeNode> children;
    }
}
