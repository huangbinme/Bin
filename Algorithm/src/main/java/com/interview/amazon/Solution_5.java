package com.interview.amazon;

import java.util.*;
import java.util.regex.Pattern;

public class Solution_5 {
    public static List<Integer> flagSuspiciousRequests(List<String> restrictedKeys, List<String> accessRequests) {
        int q = accessRequests.size();
        List<Integer> ans = new ArrayList<>();
        List<Pattern> patterns = new ArrayList<>();
        for (String key : restrictedKeys) {
            String regex = key.replace(".", "\\.").replace("*", ".*");
            patterns.add(Pattern.compile(regex));
        }
        Map<String, Deque<Integer>> recentMap = new HashMap<>();
        for (int i = 0; i < q; i++) {
            String request = accessRequests.get(i);
            int time = i + 1;
            boolean restricted = false;
            for (Pattern p : patterns) {
                if (p.matcher(request).matches()) {
                    restricted = true;
                    break;
                }
            }
            if (restricted) {
                ans.add(1);
                continue;
            }
            recentMap.putIfAbsent(request, new ArrayDeque<>());
            Deque<Integer> times = recentMap.get(request);
            while (!times.isEmpty() && times.peekFirst() <= time - 5) {
                times.pollFirst();
            }
            if (times.size() >= 2) {
                ans.add(1);
            } else {
                ans.add(0);
                times.addLast(time);
            }
        }
        return ans;
    }
}
