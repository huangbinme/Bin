package com.leetcode;

import java.util.*;

public class Solution {
    int ans = 0;


    public int numWays(int n, int[][] relation, int k) {
        dfs(n, relation, k, 0, 0);
        return ans;
    }

    private void dfs(int n, int[][] relation, int k, int passCount, int cur) {
        if (passCount == k) {
            if (cur == n - 1) ans++;
            return;
        }
        for (int i = 0; i < relation.length; i++) {
            if (relation[i][0] == cur) {
                dfs(n, relation, k, passCount + 1, relation[i][1]);
            }
        }
    }

    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public int majorityElement(int[] nums) {
        int count = 0, ele = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                ele = nums[i];
            } else {
                count = nums[i] == ele ? count + 1 : count - 1;
                ele = count == 0 ? -1 : ele;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele) sum++;
        }
        return sum > nums.length / 2 ? ele : -1;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                sb.append(chars[j]);
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(strs[i]);
            map.put(sb.toString(), list);
        }
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
    }

    public boolean isOneBitCharacter(int[] bits) {
        int step = 0, count = 0;
        while (step < bits.length) {
            if (bits[step] == 0) {
                step++;
                count = 1;
            } else {
                step += 2;
                count = 2;
            }
        }
        return count == 1;
    }

    public int minTimeToType(String word) {
        int ans = 0;
        char cur = 'a';
        for (int i = 0; i < word.length(); i++) {
            int num = Math.abs(word.charAt(i) - cur);
            if (num <= 13) {
                ans += num;
            } else {
                ans += 26 - num;
            }
            cur = word.charAt(i);
        }
        ans += word.length();
        return ans;
    }

    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0) {
                    ans += matrix[i][j];
                    min = Math.min(min, matrix[i][j]);
                } else {
                    list.add(matrix[i][j]);
                }
            }
        }
        if (list.size() != 0) {
            if (list.size() % 2 == 0) {
                for (Integer integer : list) {
                    ans += Math.abs(integer);
                }
            } else {
                list.sort(Comparator.naturalOrder());
                int last = list.get(list.size() - 1);
                if (Math.abs(min) < Math.abs(last)) {
                    ans -= min;
                    ans += min * -1;
                    ans += last * -1;
                } else {
                    ans += last;
                }
                for (int i = 0; i < list.size() - 1; i++) {
                    ans += Math.abs(list.get(i));
                }
            }
        }
        return ans;
        //34
    }
}
