package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int loop = list.size() / 2;
        int left = 0;
        int right = list.size() - 1;
        for (int i = 0; i < loop; i++) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
