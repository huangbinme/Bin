package com.algorithm.find;

import com.algorithm.find.api.ST;

public class BinarySearchTree<Key extends Comparable, Value> implements ST<Key,Value> {
    private Node root;
    private int size = 0;

    @Override
    public Value get(Key k) {
        return get(root,k);
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

    @Override
    public void put(Key k, Value v) {
        root = put(root,k,v);
    }

    private Node put(Node node, Key k, Value v) {
        if(node==null){
            this.size++;
            return new Node(k,v);
        }
        int cmp = node.getKey().compareTo(k);
        if(cmp>0){
            node.left = put(node.left,k,v);
        }else if (cmp<0){
            node.right = put(node.right,k,v);
        }else {
            node.setValue(v);
        }
        return node;
    }

    @Override
    public void delete(Key k) {
        root = delete(root,k);
    }

    private Node delete(Node node, Key k) {
        if(node==null) return null;

        int cmp = node.getKey().compareTo(k);
        if(cmp>0){
            node.left = delete(node.left,k);
        }else if (cmp<0){
            node.right = delete(node.right,k);
        }else {
            if(node.left==null) return node.right;
            if(node.right==null) return node.left;
            Node tmp = node;
            Node rightMin = min(node.getRight());
            deleteMin(node.getRight());
            rightMin.right = tmp.right;
            rightMin.left = tmp.left;
            return rightMin;
        }
        return node;
    }

    @Override
    public boolean contains(Key k) {
        return get(k)!=null;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Key min() {
        return min(root).getKey();
    }

    public Node min(Node node) {
        if(node.getLeft()==null) return node;
        return min(node.getLeft());
    }

    @Override
    public Key max() {
        return max(root).getKey();
    }

    public Node max(Node node) {
        if(node.getRight()==null) return node;
        return max(node.getRight());
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
        this.size--;
    }

    private Node deleteMin(Node node) {
        if(node.getLeft()==null){
            return node.getRight();
        }
        node.left = deleteMin(node.getLeft());
        return node;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
        this.size--;
    }

    private Node deleteMax(Node node) {
        if(node.getRight()==null){
            return node.getLeft();
        }
        node.right = deleteMax(node.getRight());
        return node;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        print(sb,this.root);
        System.out.println(sb.toString());
    }

    private void print(StringBuilder sb, Node root) {
        if(root==null) return;
        sb.append(String.format("[%s]",root.getKey()));
        print(sb,root.getLeft());
        print(sb,root.getRight());
    }

    private int subNodeNumber(Node node){
        return (node.getLeft()==null?0:1)+(node.getRight()==null?0:1);
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
