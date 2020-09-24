package com.algorithm.find;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] ints = new int[]{1,2,4,7,9,15,16,22};
        System.out.println(binarySearch.find(ints,8));
    }

    public int find(int[] ints, int num){
        return find(0,ints.length-1,ints,num);
    }

    private int find(int low, int high, int[] ints, int num) {
        if(low>high){
            return -1;
        }
        int mid = (high+low)/2;
        if (ints[mid]>num){
            return find(low,mid-1,ints,num);
        }else if(ints[mid]<num){
            return find(mid+1,high,ints,num);
        }else {
            return mid;
        }
    }
}
