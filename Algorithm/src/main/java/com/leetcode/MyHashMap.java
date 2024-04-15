package com.leetcode;

import java.util.Arrays;

public class MyHashMap {
    int[] ints;

    public MyHashMap() {
        ints = new int[1000001];
        Arrays.fill(ints, -1);
    }

    public void put(int key, int value) {
        ints[key] = value;
    }

    public int get(int key) {
        return ints[key];
    }

    public void remove(int key) {
        ints[key] = -1;
    }
}
