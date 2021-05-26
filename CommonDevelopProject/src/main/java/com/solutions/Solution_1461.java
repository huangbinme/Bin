package com.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_1461 {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        int loopTimes = s.length() - k + 1;
        for (int i = 0; i < loopTimes; i++) {
            set.add(s.substring(i, i + k));
        }

        int expectSize = (int) Math.pow(2, k);
        return set.size() == expectSize;
    }

    public List<String> getSubString(int k) {
        List<String> tree = buildTree(k);
        List<String> outputStrings = new ArrayList<>();
        printPath(tree, outputStrings, 1, "Start");
        return outputStrings;
    }

    public void printPath(List<String> tree, List<String> output, int location, String path) {
        if (location >= tree.size()) {
            return;
        }
        if (isLeafNode(location, tree.size())) {
            output.add(path + "->" + tree.get(location));
            return;
        }

        printPath(tree, output, 2 * location, path + "->" + tree.get(location));
        printPath(tree, output, 2 * location + 1, path + "->" + tree.get(location));
    }

    public boolean isLeafNode(int k, int length) {
        return 2 * k >= length;
    }

    public List<String> buildTree(int k) {
        int nodeCount = (int) Math.pow(2, k + 1) - 1;
        List<String> list = new ArrayList<>(nodeCount + 1);
        list.add("null");
        for (int n = 0; n < nodeCount; n++) {
            if (n == 0) {
                list.add("-1");
                continue;
            }
            if (n % 2 == 0) {
                list.add("1");
            } else {
                list.add("0");
            }
        }
        return list;
    }
}
