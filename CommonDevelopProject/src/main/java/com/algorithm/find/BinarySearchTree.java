package com.algorithm.find;

import java.util.Objects;

public class BinarySearchTree<Key extends Comparable<Key>, Value>{
    private Node root;

    public Value get(Key k) {
        Node current = root;
        return get(current,k);
    }

    private Value get(Node current, Key k) {
        if (current==null) return null;
        int cmp = current.getKey().compareTo(k);
        if(cmp==0) return current.getValue();
        if(cmp>0){
            return get(current.getLeft(),k);
        } else {
            return get(current.getRight(),k);
        }
    }

    public void put(Key k, Value v) {
        Node current = root;
        put(current,k,v);
    }

    private void put(Node current, Key k, Value v) {
        int cmp = current.getKey().compareTo(k);
        if (cmp==0){
            current.setValue(v);
            return;
        }else if(cmp>0){
            if(current.getLeft()==null){
                Node node = new Node(k,v);
                current.setLeft(node);
                return;
            }else {
                put(current.getLeft(),k,v);
            }
        }else {
            if(current.getRight()==null){
                Node node = new Node(k,v);
                current.setRight(node);
                return;
            }else {
                put(current.getRight(),k,v);
            }
        }
    }

    public void delete(Key k) {

    }

    public boolean contains(Key k) {
        return false;
    }

    public BinarySearchTree(Node root) {
        Objects.requireNonNull(root);
        this.root = root;
    }
    public BinarySearchTree(Key k, Value v) {
        Objects.requireNonNull(k);
        Node node = new Node(k,v);
        this.root = node;
    }

    public class Node{
        private int index;
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}
