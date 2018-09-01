package com.linearlist;

public class LinearListByArray {

    private Object [] array;
    private int size;

    public LinearListByArray(int size) {

        this.array = new Object[size];
        this.size = 0;
    }

    public LinearListByArray() {

        this.array = new Object[1000];
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<array.length;i++){
            if(array[i]!=null){
                sb.append(array[i]+" ");
            }else {
                break;
            }
        }
        System.out.println(sb.toString());
    }

    public void add(Object obj){
        int location = this.size;
        array[location]=obj;
        this.size++;
    }

    public Object find(int location){
        if(location<0||location>this.size-1){
            return null;
        }else{
            return  array[location];
        }
    }

    public void add (Object obj,int index){
        int size = this.size;
        if(index>size||index<0){
            System.out.println("Index out of bound error");
            return;
        }

        if(size==index){
            array[index] = obj;
        }else {
            for(int i=size-1;i>=index;i--){
                array[i+1]=array[i];
            }
            array[index]=obj;
        }
        this.size++;
    }

    public void delete(int index){
        if(index<0||array[index]==null){
            System.out.println("Index out of bound error");
            return;
        }

        if(array[index+1]==null){
            array[index]=null;
        }else {
            int size = this.size;
            for(int i=index+1;i<size;i++){
                array[i-1] = array[i];
            }
            array[size-1]=null;
        }
        this.size--;
    }

}
