package com.review;

public class Trie {

    Node root;

    public Trie() {
        root = new Node(true);
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.nodes[j] == null) {
                node.nodes[j] = new Node(i == word.length() - 1);
            }
            node = node.nodes[j];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.nodes[j] == null) return false;
            node = node.nodes[j];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (node.nodes[j] == null) return false;
            node = node.nodes[j];
        }
        return true;
    }

    static class Node {
        private boolean isEnd;
        private Node[] nodes;

        public Node(boolean isEnd) {
            this.isEnd = isEnd;
            this.nodes = new Node[26];
        }
    }
}
