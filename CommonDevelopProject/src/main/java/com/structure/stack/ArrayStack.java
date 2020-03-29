package com.structure.stack;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> implements Iterable{

    private T[] strArray;
    private int size = 0;

    public void push(T str){
        if (isFull()){
            resize(strArray.length*2);
        }
        strArray[size++]=str;
    }

    public T pop(){
        if (isEmpty()){
            throw new NullPointerException();
        }
        T result = strArray[--size];
        strArray[size] = null;
        if(strArray.length/4>=size){
            resize(strArray.length/2);
        }
        return result;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public ArrayStack(int capacity) {
        this.strArray = (T[])(new Object[capacity]);
    }

    public boolean isFull(){
        return strArray.length==size;
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
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T>{
        private int i = size;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public T next() {
            return strArray[--i];
        }
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "strArray=" + Arrays.toString(strArray) +
                '}';
    }
}
