package com.solutions;

public class Solution_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length+nums2.length];
        if(nums1==null||nums1.length==0){
            merge = nums2;
        }else if(nums2==null||nums2.length==0){
            merge = nums1;
        } else {
            merge(merge,nums1,nums2);
        }
        return merge.length%2==0?(merge[merge.length/2]+merge[merge.length/2-1])/2d:merge[merge.length/2];
    }

    private void merge(int[] merge, int[] nums1, int[] nums2) {
        int point1 = 0;
        int point2 = 0;
        int point_in_merge = 0;
        while (point1<nums1.length&&point2<nums2.length){
            if(nums1[point1]<=nums2[point2]){
                merge[point_in_merge] = nums1[point1++];
            }else {
                merge[point_in_merge] = nums2[point2++];
            }
            point_in_merge++;
        }

        if(point1<nums1.length){
            for (int i = point1; i < nums1.length; i++) {
                merge[point_in_merge++] = nums1[i];
            }
        }else if(point2<nums2.length){
            for (int i = point2; i < nums2.length; i++) {
                merge[point_in_merge++] = nums2[i];
            }
        }
    }
}
