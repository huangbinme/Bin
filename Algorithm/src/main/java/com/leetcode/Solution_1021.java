package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_1021 {
    public String removeOuterParentheses(String s) {
        int lCount = 0, remove = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ans.append(s.charAt(i));
            lCount += s.charAt(i) == '(' ? 1 : -1;
            if (lCount == 0) {
                ans.deleteCharAt(remove);
                ans.deleteCharAt(ans.length() - 1);
                remove = ans.length();
            }
        }
        return ans.toString();
    }

    public int percentageLetter(String s, char letter) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                c++;
            }
        }
        double d = c, e = s.length();
        double f = c / e;
        f *= 100;
        return (int) f;
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] ints = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            ints[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(ints);
        int ans = 0;
        for (int i = 0; i < ints.length; i++) {
            additionalRocks -= ints[i];
            if (additionalRocks < 0) {
                break;
            } else {
                ans++;
            }
        }
        return ans;
    }

    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1 || stockPrices.length == 2) return stockPrices.length - 1;
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int p1 = 0, p2 = 1, p3 = 2;
        while (p3 < stockPrices.length) {
            if (check(stockPrices[p1], stockPrices[p2], stockPrices[p3])) {
                p3++;
            } else {
                p1 = p3 - 1;
                p2 = p1 + 1;
                p3 = p2 + 1;
                ans++;
            }
        }
        ans++;
        return ans;
    }

    public boolean check(int[] ints1, int[] ints2, int[] ints3) {
        return (ints1[0] == ints2[0] && ints1[0] == ints3[0]) || ((ints3[1] - ints2[1]) * (ints2[0] - ints1[0]) == (ints2[1] - ints1[1]) * (ints3[0] - ints2[0]));
    }
}
