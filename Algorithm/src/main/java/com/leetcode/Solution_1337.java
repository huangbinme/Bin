package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        for (int i = 0; i < mat.length; i++) {
            queue.add(new int[]{sum(mat[i]), i});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[1];
        }
        return ans;
    }

    public int sum(int[] ints) {
        if (ints[0] == 0) return 0;
        if (ints[ints.length - 1] == 1) return ints.length;
        int l = 0, r = ints.length - 1;
        while (l + 1 < r) {
            int mid = getMid(l, r);
            if (ints[mid] == 0) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return ints[l] == 1 ? r : l;
    }

    public int getMid(int i, int j) {
        return i + (j - i) / 2;
    }
}
