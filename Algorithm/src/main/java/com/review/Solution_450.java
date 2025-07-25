package com.review;

public class Solution_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null || root.left == null) return root.left == null ? root.right : root.left;
            TreeNode t = root, tLeft = t.left, tRight = t.right, move = tLeft;
            while (move.right != null) move = move.right;
            move.right = tRight;
            return t.left;
        }
        return root;
    }
}
