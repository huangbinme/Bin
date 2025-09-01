package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_117 {
    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.pollFirst();
                if (i != size - 1) {
                    node.next = deque.peekFirst();
                }
                if (node.left != null) deque.offerLast(node.left);
                if (node.right != null) deque.offerLast(node.right);
            }
        }
        return root;
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }
}
