package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String[] permutation(String s) {
        String[] strings = s.split("");
        Arrays.sort(strings);
        s = String.join("", strings);
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visit = new boolean[s.length()];
        dfs(list, visit, sb, s, 0);
        String[] ans = new String[list.size()];
        return list.toArray(ans);
    }

    private void dfs(List<String> list, boolean[] visit, StringBuilder sb, String s, int index) {
        if (index == s.length()) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visit[i] || (i > 0 && !visit[i - 1] && s.charAt(i) == s.charAt(i - 1))) continue;
            sb.append(s.charAt(i));
            visit[i] = true;
            dfs(list, visit, sb, s, index + 1);
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (true) {
            if (slow == null || fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        return true;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (true) {
            if (slow == null || fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public String minNumber(int[] nums) {
        List<String> strings = Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toList());
        Collections.sort(strings, (a, b) -> {
            String strA = a + b;
            String strB = b + a;
            return strA.compareTo(strB);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
