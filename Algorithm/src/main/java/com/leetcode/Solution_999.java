package com.leetcode;

public class Solution_999 {
    public int countStr(String str1, String str2) {
        if (str1 == null) return 0;
        String[] strings = str1.split(",");
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].contains(str2)) result++;
        }
        return result;
    }

    public int getPos(int[] array, int n) {
        if (n <= array[0]) return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = getMid(left, right);
        while (left + 1 != right) {
            if (array[left] <= n && array[mid] >= n) {
                right = mid;
            } else {
                left = mid;
            }
            mid = getMid(left, right);
        }
        if (array[left] == n || array[left] > n) return left;
        if (array[right] == n || array[right] > n) return right;
        return right + 1;
    }

    public int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
