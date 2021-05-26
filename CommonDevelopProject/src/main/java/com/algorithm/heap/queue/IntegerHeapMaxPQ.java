package com.algorithm.heap.queue;

public class IntegerHeapMaxPQ extends HeapMaxPQ<Integer>{
    private int[] sortArray;

    public IntegerHeapMaxPQ(int initMaxSize) {
        super.array = new Integer[initMaxSize+1];
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= super.size(); i++) {
            if(i==super.size()){
                sb.append(array[i].toString());
            }else {
                sb.append(array[i].toString()+", ");
            }
        }
        System.out.println(sb.toString());
    }
}
