package com.linearlist;

public class LinearListByArray {

    private Object [] array;

    public LinearListByArray(int size) {
        this.array = new Object[size];
    }

    public LinearListByArray() {
        this.array = new Object[1000];
    }

    public int size(){
        int size = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]!=null){
                size++;
            }else {
                break;
            }
        }
        return size;
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
        int location = size();
        array[location]=obj;
    }

    public Object find(int location){
        if(location<0||location>size()-1){
            return null;
        }else{
            return  array[location];
        }
    }

    public void add (Object obj,int index){
        if(array[index]==null){
            if(index==0){
                array[0] = obj;
            }else {
                if(array[index-1]==null){
                    System.out.print("Index out of bound error!");
                }else {
                    array[index] = obj;
                }
            }
        }else {
            for(int i = size();i>=index;i--){
                array[i+1]=array[i];
            }
            array[index]=obj;
        }
    }

    public void delete(int index){
        if(index<0||array[index]==null){
            System.out.println("Index out of bound error");
            return;
        }

        if(array[index+1]==null){
            array[index]=null;
        }else {
            int size = size();
            for(int i=index+1;i<size;i++){
                array[i-1] = array[i];
            }
            array[size-1]=null;
        }
    }

}
