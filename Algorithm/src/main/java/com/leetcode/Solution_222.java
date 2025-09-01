package com.leetcode;

public class Solution_222 {

    public int countNodes(TreeNode root) {
        int lHigh = 0, rHigh = 0;
        TreeNode l = root, r = root;
        while (l != null) {
            l = l.left;
            lHigh++;
        }
        while (r != null) {
            r = r.right;
            rHigh++;
        }
        if (lHigh == rHigh) {
            return (int) Math.pow(2, lHigh) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
