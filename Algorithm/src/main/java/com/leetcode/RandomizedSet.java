package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    Map<Integer, Integer> map = new HashMap<>();

    int l = 0;

    int[] nums = new int[200000];

    Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, l);
        nums[l] = val;
        l++;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int remove = map.remove(val);
        nums[remove] = nums[l - 1];
        if(remove != l - 1) map.put(nums[remove], remove);
        l--;
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(l)];
    }
}