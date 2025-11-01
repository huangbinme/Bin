package com.leetcode;

    public class Solution_108 {
        public TreeNode sortedArrayToBST(int[] nums) {
            return dfs(nums, 0, nums.length);
        }

        private TreeNode dfs(int[] nums, int start, int end) {
            if (end - start == 1) {
                TreeNode treeNode = new TreeNode(nums[start]);
                return treeNode;
            }
            if (end - start < 1) return null;
            int minIndex = start + (end - start) / 2;
            int midV = nums[minIndex];
            TreeNode treeNode = new TreeNode(midV);
            treeNode.left = dfs(nums, start, minIndex);
            treeNode.right = dfs(nums, minIndex + 1, end);
            return treeNode;
        }
    }
