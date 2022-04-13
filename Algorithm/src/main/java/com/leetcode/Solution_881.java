package com.leetcode;

import java.util.Arrays;

public class Solution_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int r = 0, l = people.length - 1, ans = 0;
        while (r <= l) {
            if (r == l) {
                ans++;
                break;
            }
            if (people[l] + people[r] <= limit) {
                l--;
                r++;
            } else {
                l--;
            }
            ans++;
        }
        return ans;
    }
}
