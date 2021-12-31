package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_506 {
    public String[] findRelativeRanks(int[] score) {
        int[] copy = Arrays.copyOf(score, score.length);
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            map.put(copy[i], copy.length - i);
        }
        String[] ans = new String[score.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = getSortStr(map.get(score[i]));
        }
        return ans;
    }

    private String getSortStr(int order) {
        if (order == 1) {
            return "Gold Medal";
        }else if(order == 2){
            return "Silver Medal";
        }else if(order == 3){
            return "Bronze Medal";
        }else {
            return String.valueOf(order);
        }
    }
}
