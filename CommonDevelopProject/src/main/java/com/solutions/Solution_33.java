package com.solutions;

public class Solution_33 {
    public int search(int[] nums, int target) {
        if(nums.length==1) return nums[0]==target?0:-1;
        int left = 0;
        int right = nums.length-1;
        int mid = getMid(left,right);
        while (left+1!=right){
            boolean leftIsSorted = nums[mid]>nums[left];
            boolean targetInLeft;
            if(leftIsSorted){
                targetInLeft = nums[left]<=target&&target<=nums[mid];
            }else {
                targetInLeft = !(nums[mid]<=target&&target<=nums[right]);
            }

            if(targetInLeft){
                right = mid;
                mid = getMid(left,right);
            }else {
                left = mid;
                mid = getMid(left,right);
            }
        }
        if(nums[left]==target||nums[right]==target){
            return nums[left]==target?left:right;
        }else {
            return -1;
        }
    }

    private int getMid(int i, int j){
        return i+(j-i)/2;
    }
}
