package com.structure.queue;

import java.util.Arrays;

public class ArrayQueue<T> {

    private T[] strArray;
    private int size = 0;

    public void enqueue(T obj){
        if(strArray.length==size){
            resize(size*2);
        }
        strArray[size] = obj;
        size++;
    }

    public T dequeue(){
        if(isEmpty()){
            throw new NullPointerException();
        }
        T first = strArray[0];
        strArray[0] = null;
        size--;
        for (int i = 0; i < size; i++) {
            strArray[i]=strArray[i+1];
            strArray[i+1]=null;
        }
        if(strArray.length/4>=size){
            resize(strArray.length/2);
        }
        return first;
    }

    public int size(){
        return size;
    }

    public Boolean isEmpty(){
        return size==0;
    }


    public ArrayQueue(int capacity) {
        this.strArray = (T[])(new Object[capacity]);
    }

    public void resize(int size){
        T[] resizeStrArray = (T[])new Object[size];
        if (size>=strArray.length){
            for (int i = 0; i < strArray.length; i++) {
                resizeStrArray[i]=strArray[i];
            }
        }else {
            for (int i = 0; i < resizeStrArray.length; i++) {
                resizeStrArray[i]=strArray[i];
            }
        }
        strArray = resizeStrArray;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "strArray=" + Arrays.toString(strArray)+
                '}';
    }
}
