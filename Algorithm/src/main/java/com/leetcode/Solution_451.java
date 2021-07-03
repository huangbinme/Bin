package com.leetcode;

import java.util.*;

public class Solution_451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Num> queue = new PriorityQueue<>(Comparator.comparingInt(n -> -1 * n.count));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new Num(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Num num = queue.poll();
            for (int i = 0; i < num.count; i++) {
                sb.append(num.character);
            }
        }
        return sb.toString();
    }

    public class Num {
        Character character;
        Integer count;

        public Num(Character character, Integer count) {
            this.character = character;
            this.count = count;
        }
    }
}
