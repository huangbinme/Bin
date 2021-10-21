package com.leetcode;

public class WordDictionary {
    Node node;

    public WordDictionary() {
        node = new Node();
    }

    public void addWord(String word) {
        Node cp = this.node;
        for (int i = 0; i < word.length(); i++) {
            if (cp.nodes == null) cp.nodes = new Node[26];
            if (cp.nodes[word.charAt(i) - 'a'] == null) cp.nodes[word.charAt(i) - 'a'] = new Node();
            cp = cp.nodes[word.charAt(i) - 'a'];
            if (i == word.length() - 1) cp.end = true;
        }
    }

    public boolean search(String word) {
        return dfs(this.node, word, 0);
    }

    private boolean dfs(Node node, String word, int match) {
        if (match == word.length()) return node.end;
        if (word.charAt(match) != '.') {
            if (node.nodes == null || node.nodes[word.charAt(match) - 'a'] == null) return false;
            return dfs(node.nodes[word.charAt(match) - 'a'], word, match + 1);
        } else {
            if (node.nodes == null) return false;
            boolean ans = false;
            for (int j = 0; j < 26; j++) {
                if (ans) return true;
                if (node.nodes[j] != null) {
                    ans = dfs(node.nodes[j], word, match + 1);
                }
            }
            return false;
        }
    }

    public static class Node {
        Node[] nodes;
        boolean end = false;
    }
}
