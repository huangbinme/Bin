package com.leetcode;

public class Trie {
    TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode treeNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (treeNode.treeNodes[index] != null) {
                treeNode = treeNode.treeNodes[index];
            } else {
                treeNode.treeNodes[index] = new TreeNode();
                treeNode = treeNode.treeNodes[index];
            }
        }
        treeNode.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode treeNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (treeNode.treeNodes[index] != null) {
                treeNode = treeNode.treeNodes[index];
            } else {
                return false;
            }
        }
        return treeNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode treeNode = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (treeNode.treeNodes[index] != null) {
                treeNode = treeNode.treeNodes[index];
            } else {
                return false;
            }
        }
        return true;
    }

    public class TreeNode {
        boolean isEnd;
        TreeNode[] treeNodes = new TreeNode[26];
    }
}
