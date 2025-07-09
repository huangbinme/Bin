package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {

    public static int minLength(int[] systemState, int[] dist) {
        boolean[] inGraph = new boolean[systemState.length + 1];
        List<Integer> systemStateList = Arrays.stream(systemState).boxed().collect(Collectors.toList());
        List<Integer> disList = Arrays.stream(dist).boxed().collect(Collectors.toList());
        systemStateList.add(0, 1);
        disList.add(0, 0);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < systemStateList.size(); i++) {
            if (i == 0) {
                add(0, 1, systemStateList, disList, priorityQueue);
            } else if (i == systemStateList.size() - 1) {
                add(i - 1, i, systemStateList, disList, priorityQueue);
            } else {
                add(i - 1, i, systemStateList, disList, priorityQueue);
                add(i, i + 1, systemStateList, disList, priorityQueue);
            }
        }
        int count = 0, ans = 0;
        while (count != systemStateList.size() && !priorityQueue.isEmpty()) {
            int[] edge = priorityQueue.poll();
            int p1 = edge[0], p2 = edge[1], dis = edge[2];
            if (!inGraph[p1]) count++;
            if (!inGraph[p2]) count++;
            if ((systemStateList.get(p1) == 0 || systemStateList.get(p2) == 0) && (!inGraph[p1] || !inGraph[p2])) {
                if (!(systemStateList.get(p1) == 1 && inGraph[p2])){
                    ans += dis;
                }
            }
            inGraph[p1] = true;
            inGraph[p2] = true;
        }
        return ans;
    }

    private static void add(int p1, int p2, List<Integer> systemStateList, List<Integer> disList, PriorityQueue<int[]> queue) {
        queue.offer(new int[]{p1, p2, getDis(p1, p2, systemStateList, disList)});
        queue.offer(new int[]{p2, p1, getDis(p1, p2, systemStateList, disList)});
    }

    private static int getDis(int p1, int p2, List<Integer> systemStateList, List<Integer> disList) {
        return systemStateList.get(p1) == 1 && systemStateList.get(p2) == 1 ? 0 : disList.get(p2) - disList.get(p1);
    }
}
