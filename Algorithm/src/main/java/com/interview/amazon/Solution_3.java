package com.interview.amazon;

import java.util.*;

public class Solution_3 {

    public static int getMaxServers1(List<Integer> powers) {
        Map<Integer, Integer> map = new HashMap<>();//Get number frequency
        for (int i = 0; i < powers.size(); i++) {
            Integer n = powers.get(i);
            map.merge(n, 1, Integer::sum);
        }
        List<int[]> list = new ArrayList<>();//int[0]:number, int[1]:frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));//sort by number value
        int ans = list.get(0)[1], sub = list.get(0)[1];//init ans by first number
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] - list.get(i - 1)[0] > 1) {
                sub = list.get(i)[1];//if cur number minus previous num greater than 1, it needs to be new head of sub server
            } else {
                //if cur number minus previous num equals to 1, there are 2 situations
                if (list.get(i)[1] == 1) {
                    //cur number frequency is 1, it needs to be new head of sub server
                    ans = Math.max(ans, sub + 1);
                    sub = 1;
                } else {
                    sub += list.get(i)[1];
                }
            }
            ans = Math.max(ans, sub);
        }
        return ans;
    }

    public static int getMaxServers(List<Integer> powers) {
        powers.sort(Comparator.naturalOrder());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < powers.size(); i++) {
            hashMap.put(powers.get(i), hashMap.getOrDefault(powers.get(i), 0) + 1);
        }

        Integer[] arr = hashMap.keySet().toArray(new Integer[0]);
        int n = arr.length - 1;
        int power = arr[n--];

        int maxRes = hashMap.get(power);
        while (n >= 0) {
            int tempRes = hashMap.get(power);
            while (n >= 0 && arr[n] == power - 1 && hashMap.get(arr[n]) >= 2) {
                tempRes += hashMap.get(arr[n]);
                power = arr[n--];
            }
            if (n >= 0 && arr[n] == power - 1) {
                tempRes += hashMap.get(arr[n]);
            }
            maxRes = Math.max(tempRes, maxRes);
            if (n >= 0) {
                power = arr[n--];
            }
        }
        return maxRes;
    }

    public static void main(String[] args) {
        List<Integer> powers = Arrays.asList(4, 3, 5, 1, 2, 2, 1);
        List<Integer> powers1 = Arrays.asList(3, 7, 5, 1, 5);
        List<Integer> powers3 = Arrays.asList(2, 2, 3, 2, 1, 2, 2);
//        System.out.println(getMaxServers(powers));//5
//        System.out.println(getMaxServers(powers1));//2
//        System.out.println(getMaxServers(powers3));//7
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(4, 3, 5, 1, 2, 2, 1));
        lists.add(Arrays.asList(1, 1, 1, 1));
        lists.add(Arrays.asList(10, 20, 30));
        lists.add(Arrays.asList(2, 2, 2, 3, 3, 4));
        lists.add(Arrays.asList(1, 2, 3, 4, 5));
        lists.add(Arrays.asList(5, 4, 3, 2, 1));
        lists.add(Arrays.asList(7));
        lists.add(Arrays.asList(1, 3, 1, 3, 1, 3));
        lists.add(Arrays.asList(100, 101, 102, 1, 2, 3));
        lists.add(Arrays.asList(1, 1, 2, 2, 3, 3, 4));
        lists.add(Arrays.asList(2, 3, 3, 4, 4, 5, 2));
        lists.add(Arrays.asList(1, 2, 2, 3, 3, 4, 4, 5));
        lists.add(Arrays.asList(5, 6, 7, 6, 5, 4, 3, 4, 5));
        lists.add(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4));
        lists.add(Arrays.asList(1, 1, 3, 3, 3, 3));
        lists.add(Arrays.asList(1, 3, 5, 3, 1, 5, 3, 5));
        lists.add(Arrays.asList(2, 2, 5, 5, 5));
        lists.add(Arrays.asList(2, 4, 4, 4, 4));
        lists.add(Arrays.asList(7, 9, 9, 9));
        lists.add(Arrays.asList(4, 5, 5, 6, 7, 7, 8, 8, 9, 10));
        lists.add(Arrays.asList(5, 5, 6, 7, 7));
        lists.add(Arrays.asList(5, 6));
        lists.add(Arrays.asList(5, 6, 7));
        lists.add(Arrays.asList(1, 2, 5, 6, 6, 7, 8, 9, 9, 1));
        lists.add(Arrays.asList(2, 3, 5, 5, 6, 7, 8, 1, 2, 3));
        lists.add(Arrays.asList(4, 55, 5, 4, 3, 55, 6, 7, 6));
        lists.add(Arrays.asList(2, 2, 1, 2, 3, 4, 5));
        lists.add(Arrays.asList(5, 5, 5, 4, 1, 1, 1, 2, 3, 3, 3));
        lists.add(Arrays.asList(1, 2, 2, 2, 3, 4, 4, 4, 5, 5));
        lists.add(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 5, 6));
        lists.add(Arrays.asList(2, 2, 3, 4, 4, 5, 6, 6, 6, 7));
        lists.add(Arrays.asList(1, 2, 3, 4, 5, 5, 5, 4, 3, 2));
        lists.add(Arrays.asList(10, 10, 11, 12, 12, 12, 11, 10, 9, 9));
        lists.add(Arrays.asList(1, 2, 3));
        lists.add(Arrays.asList(1, 1, 2, 3));
        lists.add(Arrays.asList(2, 3, 4));
        lists.add(Arrays.asList(1, 2, 2, 3));
        lists.add(Arrays.asList(1, 2, 3, 4));
        lists.add(Arrays.asList(1, 1, 2, 3));
        lists.add(Arrays.asList(2, 3, 4));
        lists.add(Arrays.asList(2, 2, 3, 4));
        lists.add(Arrays.asList(5, 6, 7, 8));
        lists.add(Arrays.asList(10, 11, 12, 13, 14));
        for (List<Integer> list : lists) {
            Integer ans = getMaxServers(list);
            Integer ans2 = getMaxServers1(list);
            System.out.println(list.toString() + ", ans is : " + ans);
            if (!ans.equals(ans2)) {
                System.out.println(list);
                System.out.println(ans + "|" + ans2);
                System.out.println("--------------");
            }
        }
    }

    public static int maxCredits(List<Integer> inventory, int dispatch1, int dispatch2, int skips) {
        int n = inventory.size();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < n; i++) {
            int cost;
            int r = inventory.get(i);
            r = r % (dispatch1 + dispatch2) == 0 ? dispatch1 + dispatch2 : r % (dispatch1 + dispatch2);
            cost = r <= dispatch1 ? 0 : r / dispatch1;
            cost -= (r % dispatch1 == 0 ? 1 : 0);
            queue.add(cost);
        }
        int res = 0;
        while (!queue.isEmpty() && skips >= queue.peek()) {
            skips -= queue.poll();
            res++;

        }
        return res;
    }
}
