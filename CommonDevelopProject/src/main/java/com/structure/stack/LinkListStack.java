package com.structure.stack;

public class LinkListStack<T> {
    
    private int size;
    private Node<T> header;
    
    public int size(){
        return size;
    }
    
    public Boolean isEmpty(){
        return size==0;
    }
    
    public void push(T obj){
        Node newNode = new Node(obj);
        if(isEmpty()){
            header = newNode;
        }else {
            newNode.next=header;
            header=newNode;
        }
        size++;
    }

    public T pop(){
        if (isEmpty()){
            throw new NullPointerException();
        }
        Node<T> tmp = header;
        header=tmp.next;
        size--;
        return tmp.getObj();
    }

    public void reverse(){
        recursiveReverse(null,this.header);
    }

    private void recursiveReverse(Node fro, Node beh) {
        if(beh==null){
            this.setHeader(fro);
            return;
        }
        Node<T> currentNode = beh;
        beh = beh.next;
        currentNode.next=fro;
        recursiveReverse(currentNode,beh);
    }
    
    private class Node<T>{
        private T obj;
        private Node next;

        public Node(T obj) {
            this.obj = obj;
        }

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()){
            return "NULL";
        }
        Node tmp = header;
        do{
            sb.append(tmp.getObj().toString()+"|");
            tmp=tmp.next;
        }while(tmp!=null);
        return sb.toString();
    }

    public Node<T> getHeader() {
        return header;
    }

    public void setHeader(Node<T> header) {
        this.header = header;
    }

}
