package com.leetcode;

import java.util.Arrays;

public class TreeAncestor {

    int[][] note;

    public TreeAncestor(int n, int[] parent) {
        note = new int[n][];
        for (int i = 0; i < note.length; i++) {
            note[i] = new int[16];
            Arrays.fill(note[i], -1);
        }
        for (int i = 0; i < note.length; i++) {
            note[i][0] = parent[i];
        }
        for (int j = 1; j < note[0].length; j++) {
            for (int i = 0; i < note.length; i++) {
                if (note[i][j - 1] == -1) continue;
                note[i][j] = note[note[i][j - 1]][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        if (k == 0) return node;
        int l = Integer.numberOfTrailingZeros(k) + 1;
        if (note[node][l - 1] == -1) return -1;
        return getKthAncestor(note[node][l - 1], k - Integer.lowestOneBit(k));
    }
}
