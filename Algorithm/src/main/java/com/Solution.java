package com;

import java.util.*;

public class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long ans = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int n1 = nums[l], n2 = nums[r - 1], n3 = nums[r];
            ans += n2;
            l++;
            r -= 2;
        }
        return ans;
    }

    public long numOfSubsequences(String s) {
        long l = 0, c = 0, leftT = 0, lc = 0, ct = 0, lt = 0, lct = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'T') leftT++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                l++;
            } else if (s.charAt(i) == 'C') {
                c++;
                lc += l;
            } else if (s.charAt(i) == 'T') {
                leftT--;
                ct += c;
                lct += (lc);
            }
            lt = Math.max(lt, l * leftT);
        }
        long ans1 = lct + lc;
        long ans2 = lct + lt;
        long ans3 = lct + ct;
        return Math.max(ans1, Math.max(ans2, ans3));
    }

    public boolean checkDivisibility(int n) {
        int t = n, n1 = 0, n2 = 1;
        while (t != 0) {
            int i = t % 10;
            n1 += i;
            n2 *= i;
            t /= 10;
        }
        return n % (n1 + n2) == 0;
    }

    public int countTrapezoids1(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.merge(points[i][1], 1, Integer::sum);
        }
        long mod = 1000000007, ans = 0, sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            long v = (long) entry.getValue();
            long twoPointFre = v * (v - 1) / 2;
            ans += (twoPointFre * sum);
            sum += twoPointFre;
            ans %= mod;
        }
        return (int) ans;
    }

    public int countTrapezoids2(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        if (validate2(points[i], points[j], points[k], points[l])) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public boolean validate2(int[] p1, int[] p2, int[] p3, int[] p4) {
        return validate(p1, p2, p3, p4)
                || validate(p1, p3, p4, p2)
                || validate(p1, p4, p3, p2);
    }

    public boolean validate(int[] p1, int[] p2, int[] p3, int[] p4) {
        int x1 = p1[0], x2 = p2[0], x3 = p3[0], x4 = p4[0];
        int y1 = p1[1], y2 = p2[1], y3 = p3[1], y4 = p4[1];
        return (y3 - y4) * (x2 - x1) == (x3 - x4) * (y2 - y1);
    }

    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int[][] ints = new int[x.length][2];
        for (int i = 0; i < ints.length; i++) {
            ints[i][0] = x[i];
            ints[i][1] = y[i];
        }
        Arrays.sort(ints, Comparator.comparingInt(a -> a[1] * -1));
        Set<Integer> set = new HashSet<>();
        set.add(ints[0][0]);
        int ans = ints[0][1];
        for (int i = 1; i < ints.length && set.size() < 3; i++) {
            if (!set.contains(ints[i][0])) {
                set.add(ints[i][0]);
                ans += ints[i][1];
            }
        }
        return set.size() == 3 ? ans : -1;
    }
}
