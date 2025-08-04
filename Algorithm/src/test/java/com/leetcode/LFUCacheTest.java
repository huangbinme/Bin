package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LFUCacheTest {

    @Test
    public void testGet() {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3,3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
    }
}