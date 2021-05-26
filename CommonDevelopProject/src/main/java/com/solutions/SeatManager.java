package com.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SeatManager {
    PriorityQueue<Integer> priorityQueue;

    public SeatManager(int n) {
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x));
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(i + 1);
        }
    }

    public int reserve() {
        return priorityQueue.poll();
    }

    public void unreserve(int seatNumber) {
        priorityQueue.offer(seatNumber);
    }
}
