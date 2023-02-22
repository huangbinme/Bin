package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<MockClass> queue = new PriorityQueue<>(Comparator.comparingDouble(v -> v.increase * -1));
        for (int i = 0; i < classes.length; i++) {
            queue.offer(new MockClass(classes[i][0], classes[i][1]));
        }
        for (int i = 0; i < extraStudents; i++) {
            MockClass mockClass = queue.poll();
            mockClass.addNewStu();
            queue.offer(mockClass);
        }
        double sum = 0d;
        while (!queue.isEmpty()) {
            sum += queue.poll().cur;
        }
        return sum / classes.length;
    }

    public class MockClass {
        int pass;
        int total;
        double cur;
        double increase;

        public MockClass(int pass, int total) {
            this.pass = pass;
            this.total = total;
            cur = (double) pass / total;
            increase = (double) (pass + 1) / (double) (total + 1) - cur;
        }

        public void addNewStu() {
            pass++;
            total++;
            cur = (double) pass / total;
            increase = (double) (pass + 1) / (double) (total + 1) - cur;
        }
    }
}
