package com.leetcode;

import java.util.Arrays;

public class Solution_923 {

    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1, r = arr.length - 1;
            while (l < r) {
                if (arr[i] + arr[l] + arr[r] > target) {
                    r--;
                } else if (arr[i] + arr[l] + arr[r] < target) {
                    l++;
                } else {
                    int subL = l, subR = r;
                    while (subL < subR && arr[subL] == arr[l]) {
                        subL++;
                    }
                    if (subL == subR && arr[subL] == arr[l]) {
                        ans += (r - l) * (r - l + 1) / 2;
                        l = subL;
                    } else {
                        while (arr[subR] == arr[r]) {
                            subR--;
                        }
                        ans += (subL - l) * (r - subR);
                        r = subR;
                        l = subL;
                    }
                }
            }
            ans %= 1000000007;
        }
        return ans;
    }
}
