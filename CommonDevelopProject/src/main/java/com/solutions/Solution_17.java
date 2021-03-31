package com.solutions;

import java.util.*;

public class Solution_17 {
    static Map<Character, List<String>> map = new HashMap<>();

    static {
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.trim().equals("")) return Collections.emptyList();
        List<List<String>> list = getPrintList(digits);
        List<String> result = new LinkedList<>();
        //combine(result, list);
        result = dp(result, list);
        return result;
    }

    private List<String> dp(List<String> result, List<List<String>> printList) {
        List<String> newResult = result;
        for (int i = 0; i < printList.size(); i++) {
            if (i == 0) {
                printList.get(0).forEach(newResult::add);
                continue;
            }
            newResult = addToResult(newResult, printList.get(i));
        }
        return newResult;
    }

    private List<String> addToResult(List<String> result, List<String> printList) {
        List<String> newResult = new LinkedList<>();
        for (int i = 0; i < printList.size(); i++) {
            for (String s : result) {
                newResult.add(s + printList.get(i));
            }
        }
        return newResult;
    }

    private void combine(List<String> result, List<List<String>> list) {
        dfs(result, list, "", 0);
    }

    private void dfs(List<String> result, List<List<String>> printList, String string, int i) {
        if (i == printList.size() - 1) {
            printList.get(i).forEach(s -> result.add(string + s));
            return;
        }
        List<String> strings = printList.get(i);
        strings.forEach(s -> dfs(result, printList, string + s, i + 1));
    }

    private List<List<String>> getPrintList(String digits) {
        List<List<String>> list = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            list.add(map.get(digits.charAt(i)));
        }
        return list;
    }
}
