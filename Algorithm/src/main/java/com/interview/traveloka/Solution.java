package com.interview.traveloka;

import java.util.*;

public class Solution {
    public static long pilesOfBoxes(List<Integer> boxesInPiles) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < boxesInPiles.size(); i++) {
            map.merge(boxesInPiles.get(i), 1, Integer::sum);
        }
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        list.sort(Comparator.comparingInt(a -> a[0] * -1));
        long ans = 0, sum = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            ans += (list.get(i)[1] + sum);
            sum += list.get(i)[1];
        }
        return ans;
    }

    static class CharNode {
        char character;
        int count;

        CharNode(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    public static String compressWord(String word, int k) {
        Deque<CharNode> deque = new LinkedList<>();
        for (char c : word.toCharArray()) {
            if (!deque.isEmpty() && deque.getLast().character == c) {
                deque.getLast().count++;
                if (deque.getLast().count == k) {
                    deque.removeLast();
                }
            } else {
                deque.add(new CharNode(c, 1));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (CharNode node : deque) {
            ans.append(String.valueOf(node.character).repeat(node.count));
        }
        return ans.toString();
    }
}
