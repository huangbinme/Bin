package com.algorithm.sort;

import com.algorithm.heap.queue.IntegerHeapMaxPQ;

public class HeapSort implements BaseSort{
    @Override
    public int[] sort(int[] input) {
        IntegerHeapMaxPQ integerHeapMaxPQ = new IntegerHeapMaxPQ(input.length);
        for (int i = 0; i < input.length; i++) {
            integerHeapMaxPQ.insert(new Integer(input[i]));
        }
        return convert(integerHeapMaxPQ,input);
    }

    private int[] convert(IntegerHeapMaxPQ integerHeapMaxPQ,int[] ints){
        for (int i = ints.length-1; i >=0; i--) {
            ints[i] = (Integer)integerHeapMaxPQ.delMax();
        }
        return ints;
    }
}