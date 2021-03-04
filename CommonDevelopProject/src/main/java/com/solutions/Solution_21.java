package com.solutions;

public class Solution_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        startToMerge(head,l1,l2);
        return removeHead(head);
    }

    private ListNode removeHead(ListNode head) {
        return head.next;
    }

    private void startToMerge(ListNode head, ListNode l1, ListNode l2) {
        ListNode head_tmp = head;
        ListNode l1_tmp = l1;
        ListNode l2_tpm = l2;
        while (l1_tmp!=null&&l2_tpm!=null){
            ListNode cur = null;
            if(l1_tmp.val <= l2_tpm.val){
                cur = l1_tmp;
                l1_tmp = l1_tmp.next;
            }else {
                cur = l2_tpm;
                l2_tpm = l2_tpm.next;
            }
            head_tmp.next = cur;
            head_tmp = head_tmp.next;
        }
        if(l1_tmp==null){
            head_tmp.next = l2_tpm;
        }else {
            head_tmp.next = l1_tmp;
        }
    }
}
