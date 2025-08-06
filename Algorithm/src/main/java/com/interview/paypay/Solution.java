package com.interview.paypay;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int solution(int[] inventory, int k) {
        int l = 0, r = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int uniqueCount = 0;
        while(r < inventory.length){
//            System.out.println(l + " | " + r);
            if(uniqueCount == k){
                ans++;
                Map<Integer, Integer> copyMap = new HashMap<>(map);
                int copyUniqueCount = uniqueCount;
                for(int i = r + 1; i < inventory.length ; i++) {
                    int num = inventory[i];
                    if(copyMap.containsKey(num)){
                        int fre = copyMap.get(num);
                        if(fre == 1) copyUniqueCount--;
                        copyMap.put(num, fre + 1);
                    }else{
                        copyUniqueCount++;
                        copyMap.put(num, 1);
                    }
                    if(copyUniqueCount >= k) ans++;
                }
                int fre = map.get(inventory[l]);
                if(fre == 1){
                    map.remove(inventory[l]);
                }else{
                    map.put(inventory[l], fre-1);
                }
                l++;
            }else {

            }

            int num = inventory[r];
            r++;
            if(map.containsKey(num)){
                int fre = map.get(num);
                if(fre == 1) uniqueCount--;
                map.put(num, fre + 1);
            }else{
                uniqueCount++;
                map.put(num, 1);
            }
        }
        return ans;
    }

}
