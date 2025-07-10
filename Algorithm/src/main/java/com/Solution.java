package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Solution {
    Set<Integer> set = Set.of(1, 3, 7, 9);

    int[][] ints = new int[][]{
            new int[]{0, 1, 2},
            new int[]{3, 4, 5},
            new int[]{6, 7, 8},
            new int[]{0, 3, 6},
            new int[]{1, 4, 7},
            new int[]{2, 5, 8},
            new int[]{0, 4, 8},
            new int[]{2, 4, 6},
    };

    public void solution() {
        boolean[] visit = new boolean[10];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> save = new ArrayList<>();
        dfs(ans, save, visit);
        System.out.println(ans.size());
        for (List<Integer> an : ans) {
            if(checkAns(an)){
                System.out.println(an);
            }
        }
    }

    private void dfs(List<List<Integer>> ans, List<Integer> save, boolean[] visit) {
        if (save.size() == 9) {
            if (checkSave(save)) {
                ans.add(new ArrayList<>(save));
            }
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            save.add(i);
            dfs(ans, save, visit);
            save.remove(save.size() - 1);
            visit[i] = false;
        }
    }

    private boolean checkSave(List<Integer> save) {
        boolean mid = save.get(4).equals(5);
        return mid && set.contains(save.get(1))
                && set.contains(save.get(3))
                && set.contains(save.get(5))
                && set.contains(save.get(7));
    }

    private boolean checkAns(List<Integer> ans) {
        for (int i = 0; i < ints.length; i++) {
            int[] v = ints[i];
            int sum = 0;
            for (int j : v) {
                sum += ans.get(j);
            }
            if(sum != 15) return false;
        }
        return true;
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        List<Integer> list1 = Arrays.asList(2, 7, 6, 9, 5, 1, 4, 3, 8);
        List<Integer> list2 = Arrays.asList(2, 9, 4, 7, 5, 3, 6, 1, 8);
        List<Integer> list3 = Arrays.asList(4, 3, 8, 9, 5, 1, 2, 7, 6);
        List<Integer> list4 = Arrays.asList(4, 9, 2, 3, 5, 7, 8, 1, 6);
        List<Integer> list5 = Arrays.asList(6, 1, 8, 7, 5, 3, 2, 9, 4);
        List<Integer> list6 = Arrays.asList(6, 7, 2, 1, 5, 9, 8, 3, 4);
        List<Integer> list7 = Arrays.asList(8, 1, 6, 3, 5, 7, 4, 9, 2);
        List<Integer> list8 = Arrays.asList(8, 3, 4, 1, 5, 9, 6, 7, 2);
        int ans = Integer.MAX_VALUE;
        ans = Math.min(getAns(s, list1), ans);
        ans = Math.min(getAns(s, list2), ans);
        ans = Math.min(getAns(s, list3), ans);
        ans = Math.min(getAns(s, list4), ans);
        ans = Math.min(getAns(s, list5), ans);
        ans = Math.min(getAns(s, list6), ans);
        ans = Math.min(getAns(s, list7), ans);
        ans = Math.min(getAns(s, list8), ans);
        return ans;
    }

    private static int getAns(List<List<Integer>> s, List<Integer> list) {
        int k = 0, ans = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ans += Math.abs(s.get(i).get(j) - list.get(k++));
            }
        }
        return ans;
    }
}
