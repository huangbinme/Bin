package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RandomizedSetTest {

    @Test
    public void testInsert() {
        RandomizedSet set = new RandomizedSet();
        set.remove(0);
        set.remove(0);
        set.insert(0);
        set.remove(0);
        System.out.println(set.insert(0));
    }
}