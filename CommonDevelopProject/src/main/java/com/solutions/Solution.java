package com.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums){
        List<Integer> newNums = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            newNums.add(nums[i]);
        }
        return subsets(newNums);
    }

    public List<List<Integer>> subsets(List<Integer> nums) {

        if(nums.isEmpty()){
            List<List<Integer>> result= new ArrayList<>();
            result.add(Collections.emptyList());
            return result;
        }

        Integer first = nums.get(0);
        List<Integer> subList = nums.subList(1,nums.size());
        List<List<Integer>> sb1 = subsets(subList);
        List<List<Integer>> sb2 = addAll(first,sb1);
        return concactList(sb1,sb2);
    }

    private List<List<Integer>> addAll(Integer first, List<List<Integer>> subList) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list:subList){
            List<Integer> s = new ArrayList<>();
            s.addAll(list);
            s.add(first);
            result.add(s);
        }
        return result;
    }

    private List<List<Integer>> concactList(List<List<Integer>> sb1,List<List<Integer>> sb2){
        List<List<Integer>> result= new ArrayList<>();
        result.addAll(sb1);
        result.addAll(sb2);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{1,2,3};
        System.out.println(s.subsets(a));
    }

}
