package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArray {

    //k : index
    //v : v[0] snap id, v[1] : value
    Map<Integer, List<int[]>> map = new HashMap<>();

    int snap = 0;

    public SnapshotArray(int length) {

    }

    public void set(int index, int val) {
        map.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[]{snap, val});
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snap_id) {
        List<int[]> list = map.get(index);
        if (list == null) return 0;
        int[] first = list.get(0), last = list.get(list.size() - 1);
        if (snap_id < first[0]) return 0;
        if (last[0] < snap_id) return last[1];
        return search(list, snap_id);
    }

    private int search(List<int[]> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target < list.get(mid + 1)[0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return list.get(l)[1];
    }
}
