package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_138 {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        Node t = head;
        int index = 0;
        while (t != null) {
            list.add(new Node(t.val));
            map.put(t, index++);
            t = t.next;
        }
        t = head;
        index = 0;
        map.values().forEach(System.out::println);
        while (t != null) {
            if (t.random != null){
                Node n = list.get(index);
                n.random = list.get(map.get(t.random));
            }
            index++;
            t = t.next;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
