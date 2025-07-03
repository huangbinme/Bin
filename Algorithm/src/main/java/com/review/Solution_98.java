package com.review;

import java.util.*;

public class Solution_98 {

    private Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean l = isValidBST(root.left);
        if (!l) return false;
        if (pre != null && pre >= root.val) return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0;
            while (num != 0) {
                count += (num % 10);
                num /= 10;
            }
            if (count == i) return i;
        }
        return -1;
    }

    public int minSwaps(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] copy = new Integer[nums.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = nums[i];
            map.put(nums[i], i);
        }
        Arrays.sort(copy, (Integer a, Integer b) -> {
            int aNumBit = getNumBit(a), bNumBit = getNumBit(b);
            return aNumBit != bNumBit ? aNumBit - bNumBit : a - b;
        });
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!copy[i].equals(nums[i])) {
                int replace = map.get(copy[i]);
                swap(replace, i, nums);
                map.put(nums[i], i);
                map.put(nums[replace], replace);
                ans++;
            }
        }
        return ans;
    }

    public void swap(int i, int j, int[] ints) {
        int t = ints[i];
        ints[i] = ints[j];
        ints[j] = t;
    }

    public int getNumBit(int i) {
        int ans = 0;
        while (i != 0) {
            ans += (i % 10);
            i /= 10;
        }
        return ans;
    }

    public int minMoves(String[] matrix) {
        String[][] matrixCopy = convert(matrix);
        boolean[][] visit = new boolean[matrixCopy.length][matrixCopy[0].length];
        int[][] ans = new int[matrixCopy.length][matrixCopy[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = -1;
            }
        }
        Map<String, List<int[]>> doorMap = new HashMap<>();
        buildDoor(doorMap, matrixCopy);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        List<int[]> connectPoint = getConnectPoint(0, 0, matrixCopy, doorMap);
        for (int[] ints : connectPoint) {
            queue.offer(ints);
        }
        visit[0][0] = true;
        ans[0][0] = 0;
        while (!queue.isEmpty() && ans[matrix.length - 1][matrix[0].length() - 1] == -1) {
            int[] poll = queue.poll();
            if (visit[poll[0]][poll[1]]) continue;
            ans[poll[0]][poll[1]] = poll[2];
            visit[poll[0]][poll[1]] = true;
            List<int[]> next = getConnectPoint(poll[0], poll[1], matrixCopy, doorMap);
            for (int[] ints : next) {
                ints[2] += ans[poll[0]][poll[1]];
                if (!visit[ints[0]][ints[1]]) queue.offer(ints);
            }
        }
        return ans[matrix.length - 1][matrix[0].length() - 1];
    }

    private List<int[]> getConnectPoint(int i, int j, String[][] matrixCopy, Map<String, List<int[]>> doorMap) {
        List<int[]> list = new ArrayList<>();
        if (inbound(i - 1, j, matrixCopy) && !matrixCopy[i - 1][j].equals("#")) {
            list.add(new int[]{i - 1, j, 1});
        }
        if (inbound(i + 1, j, matrixCopy) && !matrixCopy[i + 1][j].equals("#")) {
            list.add(new int[]{i + 1, j, 1});
        }
        if (inbound(i, j + 1, matrixCopy) && !matrixCopy[i][j + 1].equals("#")) {
            list.add(new int[]{i, j + 1, 1});
        }
        if (inbound(i, j - 1, matrixCopy) && !matrixCopy[i][j - 1].equals("#")) {
            list.add(new int[]{i, j - 1, 1});
        }
        if (!matrixCopy[i][j].equals(".") && !matrixCopy[i][j].equals("#")) {
            List<int[]> door = doorMap.get(matrixCopy[i][j]);
            if (door.size() > 1) {
                for (int[] ints : door) {
                    if (ints[0] == i && ints[1] == j) continue;
                    list.add(new int[]{ints[0], ints[1], 0});
                }
            }
        }
        return list;
    }

    public boolean inbound(int i, int j, String[][] matrixCopy) {
        return i >= 0 && i < matrixCopy.length && j >= 0 && j < matrixCopy[0].length;
    }

    private void buildDoor(Map<String, List<int[]>> map, String[][] matrixCopy) {
        for (int i = 0; i < matrixCopy.length; i++) {
            for (int j = 0; j < matrixCopy[0].length; j++) {
                if (!matrixCopy[i][j].equals(".") && !matrixCopy[i][j].equals("#")) {
                    List<int[]> list = map.computeIfAbsent(matrixCopy[i][j], k -> new ArrayList<>());
                    list.add(new int[]{i, j});
                }
            }
        }
    }

    private String[][] convert(String[] matrix) {
        String[][] newMatrix = new String[matrix.length][matrix[0].length()];
        for (int i = 0; i < matrix.length; i++) {
            String s = matrix[i];
            for (int j = 0; j < s.length(); j++) {
                newMatrix[i][j] = String.valueOf(s.charAt(j));
            }
        }
        return newMatrix;
    }
}
