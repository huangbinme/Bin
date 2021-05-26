package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution_1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[C * R][];
        List<Point> pointList = new ArrayList<>();
        supplyPointList(pointList, R, C, r0, c0);
        Collections.sort(pointList);
        inputResult(result, pointList);
        return result;
    }

    private void inputResult(int[][] result, List<Point> pointList) {
        for (int i = 0; i < result.length; i++) {
            result[i] = pointList.get(i).getPoint();
        }
    }

    private void supplyPointList(List<Point> pointList, int r, int c, int r0, int c0) {
        int[] targetPoint = new int[]{r0, c0};
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int[] curPoint = new int[]{i, j};
                Point point = new Point();
                point.setPoint(curPoint);
                point.setDistance(calDistance(targetPoint, curPoint));
                pointList.add(point);
            }
        }
    }

    public int calDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public class Point implements Comparable<Point> {
        private int[] point;
        private int distance;

        public int[] getPoint() {
            return point;
        }

        public void setPoint(int[] point) {
            this.point = point;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(Point o) {
            return this.distance - o.getDistance();
        }
    }
}