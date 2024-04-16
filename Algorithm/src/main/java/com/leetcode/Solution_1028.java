package com.leetcode;

public class Solution_1028 {

    public TreeNode recoverFromPreorder(String traversal) {
        return build(traversal, 1);
    }

    private TreeNode build(String traversal, int subDepth) {
        if (!traversal.contains("-")) {
            return new TreeNode(Integer.parseInt(traversal));
        }
        int first = traversal.indexOf("-");
        TreeNode cur = new TreeNode(Integer.parseInt(traversal.substring(0, first)));
        int count = 0, leftStart = -1, rightStart = -1;
        for (int j = first; j < traversal.length(); j++) {
            if (traversal.charAt(j) == '-') {
                count++;
            } else {
                if (count == subDepth) {
                    if (leftStart == -1) {
                        leftStart = j;
                    } else {
                        rightStart = j;
                        break;
                    }
                }
                count = 0;
            }
        }
        String left = traversal.substring(leftStart, rightStart == -1 ? traversal.length() : rightStart - subDepth);
        cur.left = build(left, subDepth + 1);
        cur.right = rightStart == -1 ? null : build(traversal.substring(rightStart), subDepth + 1);
        return cur;
    }

}
