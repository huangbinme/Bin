package com.review;

public class Solution_5 {
    public String longestPalindrome(String s) {
        int[] ans = new int[]{-1, -1, 0};
        for (int i = 0; i < s.length(); i++) {
            int[] ans1 = longestPalindrome(s, i, i);
            ans = ans1[2] > ans[2] ? ans1 : ans;
            if (i < s.length() - 1) {
                int[] ans2 = longestPalindrome(s, i, i + 1);
                ans = ans2[2] > ans[2] ? ans2 : ans;
            }
        }
        return s.substring(ans[0], ans[1]);
    }

    private int[] longestPalindrome(String s, int l, int r) {
        int[] ans = new int[]{-1, -1, 0};
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        ans[0] = l + 1;
        ans[1] = r;
        ans[2] = ans[1] - ans[0];
        return ans;
    }
}
