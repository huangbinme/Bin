package com.solutions;

import java.util.*;

public class Solution_15 {
    Set<String> set = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            find(result, nums, i);
        }
        return result;
    }

    private void find(List<List<Integer>> result, int[] nums, int i) {
        int targetNum = nums[i] * -1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int j = i+1; j < nums.length; j++) {
            if(map.containsKey(nums[j])){
                validateThenAdd(result,Arrays.asList(nums[i],nums[j],nums[map.get(nums[j])]));
            }
            map.put(targetNum-nums[j],j);
        }
    }

    private void validateThenAdd(List<List<Integer>> result, List<Integer> addList){
        String listStr = listToSting(addList);
        if(!set.contains(listStr)){
            set.add(listStr);
            result.add(addList);
        }
    }

    private String listToSting(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        list.sort(Integer::compareTo);
        list.forEach(s -> sb.append(s));
        return sb.toString();
    }
}
