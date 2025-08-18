package com.review;

public class Solution_lcr_159 {
    public int[] inventoryManagement(int[] stock, int cnt) {
        int l = 0, r = stock.length - 1;
        while (l < r) {
            int pivot = quickSort(stock, l, r);
            if (pivot == cnt - 1) break;
            if (pivot > cnt - 1) {
                r = pivot - 1;
            } else {
                l = pivot + 1;
            }
        }
        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            ans[i] = stock[i];
        }
        return ans;
    }

    private int quickSort(int[] stock, int start, int end) {
        int pivot = stock[start], l = start + 1, r = end;
        while (l <= r) {
            while (l <= r && stock[l] <= pivot) l++;
            while (l <= r && stock[r] >= pivot) r--;
            if (l > r) break;
            swap(stock, l, r);
        }
        swap(stock, start, r);
        return r;
    }

    private void swap(int[] stock, int l, int r) {
        int t = stock[l];
        stock[l] = stock[r];
        stock[r] = t;
    }
}
