package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution_1847 {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        TreeSet<Room> treeSet = new TreeSet<>(Comparator.comparingInt(a -> a.id));
        int[][] newQ = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            newQ[i][0] = queries[i][0];
            newQ[i][1] = queries[i][1];
            newQ[i][2] = i;
            newQ[i][3] = -1;
        }
        Arrays.sort(rooms, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(newQ, Comparator.comparingInt(a -> -a[1]));
        for (int i = 0; i < newQ.length; i++) {
            if (newQ[i][1] <= rooms[rooms.length - 1][1]) {
                for (int j = rooms.length - treeSet.size() - 1; j >= 0; j--) {
                    if (newQ[i][1] <= rooms[j][1]) {
                        treeSet.add(new Room(rooms[j][0], rooms[j][1]));
                    } else {
                        break;
                    }
                }
                Room room = new Room(newQ[i][0], newQ[i][1]);
                Room f = treeSet.floor(room);
                Room c = treeSet.ceiling(room);
                if (f == null) {
                    newQ[i][3] = c.id;
                } else if (c == null) {
                    newQ[i][3] = f.id;
                } else {
                    newQ[i][3] = Math.abs(newQ[i][0] - f.id) <= Math.abs(newQ[i][0] - c.id) ? f.id : c.id;
                }
            }
        }
        int[] ans = new int[newQ.length];
        for (int i = 0; i < newQ.length; i++) {
            ans[newQ[i][2]] = newQ[i][3];
        }
        return ans;
    }

    public class Room {
        int id;
        int size;

        public Room(int id, int size) {
            this.id = id;
            this.size = size;
        }
    }
}
