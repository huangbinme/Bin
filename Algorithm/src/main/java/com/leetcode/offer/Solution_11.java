package com.leetcode.offer;

public class Solution_11 {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l + 1 < r) {
            int mid = getMid(l, r);
            if (numbers[mid] < numbers[r]) {
                r = mid;
            } else if(numbers[mid] > numbers[r]){
                l = mid;
            }else {
                r--;
            }
        }
        return Math.min(numbers[l], numbers[r]);
    }

    private int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
