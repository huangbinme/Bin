package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    Map<String,Integer> map;

    public MapSum() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int ans = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getKey().startsWith(prefix)){
                ans += entry.getValue();
            }
        }
        return ans;
    }
}
