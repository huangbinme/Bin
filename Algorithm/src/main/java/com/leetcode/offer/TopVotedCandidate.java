package com.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {

    int[] candidate;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.candidate = new int[times.length];
        int person = -1, maxVote = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < persons.length; i++) {
            int vote = map.getOrDefault(persons[i], 0) + 1;
            map.put(persons[i], vote);
            if (maxVote <= vote) {
                maxVote = vote;
                person = persons[i];
            }
            candidate[i] = person;
        }
    }

    public int q(int t) {
        int l = 0, r = candidate.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (t >= times[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return candidate[l];
    }
}
