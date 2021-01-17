package com.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution_1394 {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        return map.entrySet().stream()
                .filter(integerIntegerEntry -> integerIntegerEntry.getKey().equals(integerIntegerEntry.getValue()))
                .map(integerIntegerEntry -> integerIntegerEntry.getKey())
                .max(Integer::compareTo).orElse(-1);
    }
}
