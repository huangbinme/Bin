package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_5736 {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(t -> t.enqueueTime));
        for (int i = 0; i < tasks.length; i++) priorityQueue.offer(new Task(i, tasks[i][0], tasks[i][1]));
        PriorityQueue<Task> timePriorityQueue = new PriorityQueue<>(Comparator.<Task>comparingInt(t -> t.processingTime).thenComparingInt(t -> t.taskIndex));
        int[] result = new int[tasks.length];
        int resultIndex = 0;
        int time = 0;
        while (!priorityQueue.isEmpty() || !timePriorityQueue.isEmpty()) {
            if (!priorityQueue.isEmpty() && timePriorityQueue.isEmpty() && priorityQueue.peek().enqueueTime > time)
                time = priorityQueue.peek().enqueueTime;
            while (!priorityQueue.isEmpty() && priorityQueue.peek().enqueueTime <= time) {
                timePriorityQueue.offer(priorityQueue.poll());
            }
            Task timePriorityTask = timePriorityQueue.poll();
            result[resultIndex++] = timePriorityTask.taskIndex;
            time += timePriorityTask.processingTime;
        }
        return result;
    }

    public class Task {
        int taskIndex;
        int enqueueTime;
        int processingTime;

        public Task(int taskIndex, int enqueueTime, int processingTime) {
            this.taskIndex = taskIndex;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }
}
