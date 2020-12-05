package com.algorithm.heap.queue;

public abstract class HeapMaxPQ<E extends Comparable> implements MaxPriorityQueue{
    protected E[] array;
    protected int size = 0;

    @Override
    public void insert(Comparable key) {
        if(size()>=array.length-1){
            throw new IndexOutOfBoundsException(String.format("Max capacity of current array is [%s]",array.length-1));
        }
        array[size()+1] = (E)key;
        swim(size()+1);
        size++;
    }

    @Override
    public Comparable delMax() {
        Comparable comparable = array[1];
        exchange(1,size());
        array[size()] = null;
        sink(1);
        size--;
        return comparable;
    }

    @Override
    public Comparable max() {
        return array[1];
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public int size() {
        return size;
    }

    public void swim(int i){
        while (i>1&&more(array[i],array[i/2])){
            exchange(i,i/2);
            i=i/2;
        }
    }

    public void sink(int i){
        while (i*2+1<array.length-1){
            if(isLeafNode(i)){
                break;
            }
            int max = getMaxIndex(i,i*2,i*2+1);
            if(max==i){
                break;
            }
            exchange(i,max);
            i = max;
        }
    }

    public int childNodeNumber(int i){
        if(isLeafNode(i)){
            return 0;
        }
        return (isNullNode(i*2)?0:1)+(isNullNode(i*2+1)?0:1);
    }

    public void exchange(int i,int j){
        E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
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

    public int getMaxIndex(int parent, int left, int right){
        if(isNullNode(left)){
            return more(array[parent],array[right])?parent:right;
        }

        if(isNullNode(right)){
            return more(array[parent],array[left])?parent:left;
        }

        int tmp = more(array[parent],array[right])?parent:right;
        tmp =  more(array[tmp],array[left])?tmp:left;
        return tmp;
    }
}