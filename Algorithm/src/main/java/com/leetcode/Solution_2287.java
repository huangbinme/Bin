package com.leetcode;

public class Solution_2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] note = getCount(s);
        int[] note2 = getCount(target);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < note2.length; i++) {
            if (note2[i] != 0) {
                ans = Math.min(ans, note[i] / note2[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    private int[] getCount(String s){
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }
}
