package com.solutions;

/** 
* @author Bin
* @version 2018年7月22日 上午1:19:15
* @Description LeetCode link:https://leetcode-cn.com/problems/two-sum/
*/

public class FindTargetNumberInArray {
	public int[] twoSum(int[] nums, int target) {
	       int result_x = 0;
	        int result_y = 0;
	        for(int i = 0;i< nums.length-1;i++){
	            for(int j=i+1;j>i&&j<nums.length;j++){
	                if(nums[i]+nums[j]==target){
	                    result_x = i;
	                    result_y = j;
	                    break;
	                }
	            }
	        }
	        int[] result = new int[]{result_x,result_y};
	        return result;
	    }
}
