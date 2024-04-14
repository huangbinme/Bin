package com.leetcode;

    public class MyHashSet {

        boolean[] booleans;

        public MyHashSet() {
            booleans = new boolean[1000001];
        }

        public void add(int key) {
            booleans[key] = true;
        }

        public void remove(int key) {
            booleans[key] = false;
        }

        public boolean contains(int key) {
            return booleans[key];
        }
    }
