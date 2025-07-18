package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LRUCacheTest {

    @Test
    public void testGet() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,0);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}