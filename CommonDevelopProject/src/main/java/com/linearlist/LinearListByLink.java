package com.linearlist;

public class LinearListByLink {
    private Node node;
    private int size;

    public LinearListByLink() {
        this.size = 0;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        Node tmp = this.node;
        while(tmp!=null){
            sb.append(tmp.obj+" ");
            tmp=tmp.next;
        }
        System.out.println(sb.toString());
    }

    public int size(){
        return this.size;
    }

    public Object find(int index){
        if(index<0||index>this.size-1){
            System.out.println("Index out of bound error!");
            return null;
        }

        Node tmp = this.node;
        int toFindLocation = index;
        while(toFindLocation!=0){
            tmp=tmp.next;
            toFindLocation--;
        }
        return tmp.obj;
    }

    public void add(Object obj){
        if(this.node==null){
            this.node = new Node(obj);
            this.size++;
            return;
        }

        int findEnd = this.size;
        Node tmp = this.node;
        while(findEnd!=1){
            tmp = tmp.next;
            findEnd--;
        }
        tmp.next=new Node(obj);
        this.size++;
    }

    public void delete(int index){
        if(index<0||index>this.size-1){
            System.out.println("Index out of bound error!");
            return;
        }

        if(index==0){
            this.node = this.node.next;
            return;
        }

        Node tmp = this.node;
        for(int i=0;i<=index+1;i++){
            if(i==index-1){
                tmp.next=tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }
    }


    private class Node{
        public Object obj;
        public Node next;

        public Node(Object obj) {
            this.obj = obj;
            this.next=null;
        }

    }
}
