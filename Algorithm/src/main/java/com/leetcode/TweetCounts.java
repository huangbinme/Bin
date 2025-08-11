package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class TweetCounts {

    Map<String, List<Integer>> map = new HashMap<>();

    public TweetCounts() {

    }

    public void recordTweet(String tweetName, int time) {
        map.computeIfAbsent(tweetName, k -> new ArrayList<>()).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int interval = 0;
        if (freq.equals("minute")) {
            interval = 60;
        } else if (freq.equals("hour")) {
            interval = 60 * 60;
        } else {
            interval = 60 * 60 * 24;
        }
        int start = startTime;
        List<int[]> chunk = new ArrayList<>();
        while (start <= endTime) {
            int s = start, e = Math.min(endTime, s + interval - 1);
            chunk.add(new int[]{s, e});
            start = e + 1;
        }
        int[] ans = new int[chunk.size()];
        List<Integer> times = map.getOrDefault(tweetName, new ArrayList<>());
        for (Integer time : times) {
            for (int i = 0; i < chunk.size(); i++) {
                if (chunk.get(i)[0] <= time && time <= chunk.get(i)[1]) {
                    ans[i]++;
                }
            }
        }
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }
}
