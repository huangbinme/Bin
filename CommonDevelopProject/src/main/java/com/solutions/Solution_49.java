package com.solutions;

import java.util.*;

public class Solution_49 {
    Map<String, List<String>> map = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String key = getStr(strs[i]);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                map.put(key, strings);
            }
        }
        List<List<String>> list = new ArrayList<>();
        map.values().forEach(value -> {
            list.add(value);
        });
        return list;
    }


    public String getStr(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = str.length();
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
            chars[i] = str.charAt(i);
        }
        Arrays.sort(chars);
        for (int i = 0; i < size; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
