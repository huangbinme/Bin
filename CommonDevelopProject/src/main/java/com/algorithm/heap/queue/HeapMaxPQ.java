package com.algorithm.heap.queue;

public abstract class HeapMaxPQ<E extends Comparable> implements MaxPriorityQueue{
    private E[] array;

    @Override
    public void insert(Comparable key) {

    }

    @Override
    public Comparable delMax() {
        return null;
    }

    @Override
    public Comparable max() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public int size() {
        return 0;
    }

    public void exchange(int i,int j){
        E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void swim(int i){
        while (i>1&&more(array[i],array[i/2])){
            exchange(i,i/2);
            i=i/2;
        }
    }

    public void sink(int i){
        while (2*i<=array.length){
        }
    }

    public int childNodeNumber(int i){
        if(isLeafNode(i)){
            return 0;
        }
        return (isNullNode(i*2)?0:1)+(isNullNode(i*2+1)?0:1);
    }

    public boolean isLeafNode(int i){
        return isNullNode(2*i)&&isNullNode(2*i+1);
    }

    public boolean isNullNode(int i){
        return i==0||i>array.length-1||array[i]==null;
    }

    public boolean less(Comparable c1,Comparable c2){
        return c1.compareTo(c2)<0;
    }

    public boolean equals(Comparable c1,Comparable c2){
        return c1.compareTo(c2)==0;
    }

    public boolean more(Comparable c1,Comparable c2){
        return c1.compareTo(c2)>0;
    }
}