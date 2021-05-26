package com.solutions;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int result = 0;
        while (low != high) {
            int waterVolume = Math.min(height[low], height[high]) * (high - low);
            result = Math.max(result, waterVolume);
            if (height[low] <= height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }

}
