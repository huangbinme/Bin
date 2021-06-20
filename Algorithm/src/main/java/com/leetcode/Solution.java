package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (sIndex >= s.length()) return true;
            if (t.charAt(i) == s.charAt(sIndex)) {
                sIndex++;
            }
        }
        return sIndex >= s.length();
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                ans += prices[i + 1] - prices[i];
            }
        }
        return ans;
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> -1 * a[1]));
        int unitSum = 0, boxSum = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxSum == truckSize) break;
            int addBox = Math.min(truckSize - boxSum, boxTypes[i][0]);
            boxSum += addBox;
            unitSum += (addBox * boxTypes[i][1]);
        }
        return unitSum;
    }

    public int minCostToMoveChips(int[] position) {
        if (position.length == 1) return 0;
        int num1 = 0, num2 = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] / 2 == 0) {
                num1++;
            } else {
                num2++;
            }
        }
        return Math.min(num1, num2);
    }

    public int minimumSwap(String s1, String s2) {
        int xCount = 0, yCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    xCount++;
                } else {
                    yCount++;
                }
            }
        }
        if ((xCount + yCount) % 2 != 0) return -1;
        int ans = 0;
        ans += xCount / 2;
        ans += yCount / 2;
        if (xCount % 2 != 0) ans += 2;
        return ans;
    }

    public int leastMinutes(int n) {
        int ans = 0, speed = 1;
        while (speed < n) {
            ans++;
            speed *= 2;
        }
        return ans + 1;
    }

    public int maxSubArray(int[] nums) {
        int min = 0, sum = 0, ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(sum - min, ans);
            min = Math.min(sum, min);
        }
        return ans;
    }

    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int a = 0, b = 1, num = 1000000007;
        for (int i = 0; i < n - 2; i++) {
            int sum = (a + b) % num;
            a = b;
            b = sum;
        }
        return b;
    }

    public boolean canConstruct(String s, int k) {
        int min = 0, max = s.length();
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }
        for (int anInt : ints) {
            if (anInt % 2 != 0) min++;
        }
        return min <= k && k <= max;
    }
}
