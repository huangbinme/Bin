package com.interview.hackerrank;

import java.util.*;

public class Solution {
    public static int makeAnagram(String a, String b) {
        // Write your code here
        Map<Character, Integer> aFreMap = getFreMap(a);
        Map<Character, Integer> bFreMap = getFreMap(b);
        int ans = 0;
        for (Map.Entry<Character, Integer> entry : aFreMap.entrySet()) {
            char aChar = entry.getKey();
            int aFre = entry.getValue();
            int bFre = bFreMap.getOrDefault(aChar, 0);
            ans += Math.abs(aFre - bFre);
            if (bFre > 0) bFreMap.remove(aChar);
        }

        for (Map.Entry<Character, Integer> entry : bFreMap.entrySet()) {

            int fre = entry.getValue();
            ans += fre;
        }
        return ans;
    }

    private static Map<Character, Integer> getFreMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        return map;
    }

    public static int alternatingCharacters(String s) {
        // Write your code here
        Deque<Integer> deque = new LinkedList<>();
        char curC = s.charAt(0);
        deque.offerLast(1);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == curC) {
                int count = deque.pollLast();
                deque.offerLast(count + 1);
            } else {
                curC = c;
                deque.offerLast(1);
            }
        }
        int ans = 0;
        while (!deque.isEmpty()) {
            int c = deque.pollFirst();
            ans += c - 1;
        }
        return ans;
    }

    public static String isValid(String s) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>(map.values());
        if (allSame(list)) return "YES";
        list.sort(Comparator.naturalOrder());
        int max = list.get(list.size() - 1);
        list.set(list.size() - 1, max - 1);
        if (allSame(list)) return "YES";
        list.set(list.size() - 1, max);
        if (list.get(0) == 1) {
            list.remove(0);
            if (allSame(list)) return "YES";
        }
        return "NO";
    }

    private static boolean allSame(List<Integer> list) {
        int n = list.get(0);
        boolean allSame = true;
        for (int i = 1; i < list.size(); i++) {
            int m = list.get(i);
            if (n != m) {
                allSame = false;
                break;
            }
        }
        return allSame;
    }
}
