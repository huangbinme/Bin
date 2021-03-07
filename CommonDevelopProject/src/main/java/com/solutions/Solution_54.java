package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution_54 {
    int m;
    int n;
    int circleCount;
    int[][] record;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        m = matrix.length;
        n = matrix[0].length;
        circleCount = Math.min(m%2==0?m/2:m/2+1,n%2==0?n/2:n/2+1);
        if(m==2||n==2) circleCount = 1;
        record = new int[m][n];
        for (int i = 0; i < circleCount; i++) {
            if(i==circleCount-1){
                search(list,matrix,i,true);
            }else {
                search(list,matrix,i,false);
            }
        }
        return list;
    }

    private void search(List<Integer> list, int[][] matrix, int i, boolean lastLoop) {
        if(lastLoop&&isPoint(i)){
            list.add(matrix[i][i]);
        }else if(lastLoop&&isHorizontalLine(i)){
            for (int j = i; j < n-i; j++) {
                list.add(matrix[i][j]);
            }
        }else if (lastLoop&&isVerticalLine(i)){
            for (int j = i; j < m-i; j++) {
                list.add(matrix[j][i]);
            }
        } else {
            top(list, matrix, i);
            right(list, matrix, i);
            bottom(list, matrix, i);
            left(list, matrix, i);
        }
    }

    public boolean isPoint(int i){
        return isBound(i+1,i)&&isBound(i,i+1);
    }

    public boolean isVerticalLine(int i){
        return !isBound(i+1,i)&&isBound(i,i+1);
    }

    public boolean isHorizontalLine(int i){
        return isBound(i+1,i)&&!isBound(i,i+1);
    }

    private boolean isBound(int i, int j){
        if(i<0||j<0||i>=m||j>=n) return true;
        return record[i][j] == -1;
    }

    private void top(List<Integer> list,int[][] matrix, int circle){
        for (int i = circle; i < n-circle-1; i++) {
            list.add(matrix[circle][i]);
            record[circle][i] = -1;
        }
    }

    private void right(List<Integer> list,int[][] matrix, int circle){
        for (int i = circle; i < m-circle-1; i++) {
            list.add(matrix[i][n-circle-1]);
            record[i][n-circle-1] = -1;
        }
    }

    private void bottom(List<Integer> list,int[][] matrix, int circle){
        for (int i = n-circle-1; i > circle ; i--) {
            list.add(matrix[m-circle-1][i]);
            record[m-circle-1][i] = -1;
        }
    }

    private void left(List<Integer> list,int[][] matrix, int circle){
        for (int i = m-circle-1; i > circle ; i--) {
            list.add(matrix[i][circle]);
            record[i][circle] = -1;
        }
    }
}
