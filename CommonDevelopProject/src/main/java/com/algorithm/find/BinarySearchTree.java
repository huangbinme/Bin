package com.algorithm.find;

import com.algorithm.find.api.ST;

public class BinarySearchTree<Key extends Comparable, Value> implements ST<Key,Value> {
    private Node root;
    private int size = 0;

    @Override
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

    @Override
    public void put(Key k, Value v) {
        Node current = root;
        if(current==null){
            this.root = new Node(k,v);
            this.size++;
            return;
        }
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
                this.size++;
                return;
            }else {
                put(current.getLeft(),k,v);
            }
        }else {
            if(current.getRight()==null){
                Node node = new Node(k,v);
                current.setRight(node);
                this.size++;
                return;
            }else {
                put(current.getRight(),k,v);
            }
        }
    }

    @Override
    public void delete(Key k) {
        this.size--;
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
        return min(root);
    }

    public Key min(Node node) {
        if(node.getLeft()==null) return node.getKey();
        return min(node.getLeft());
    }

    @Override
    public Key max() {
        return max(root);
    }

    public Key max(Node node) {
        if(node.getRight()==null) return node.getKey();
        return max(node.getRight());
    }

    @Override
    public void deleteMin() {
        if(root.getLeft()==null){
            root = root.getRight();
            this.size--;
            return;
        }
        deleteMin(root);
        this.size--;
    }

    public void deleteMin(Node node) {
        if(node.getLeft().getLeft()==null){
            node.setLeft(node.getLeft().getRight());
            return;
        }
        deleteMin(node.getLeft());
    }

    @Override
    public void deleteMax() {
        if(root.getRight()==null){
            root = root.getLeft();
            this.size--;
            return;
        }
        deleteMax(root);
        this.size--;
    }

    public void deleteMax(Node node) {
        if(node.getRight().getRight()==null){
            node.setRight(node.getRight().getLeft());
            return;
        }
        deleteMax(node.getRight());
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
