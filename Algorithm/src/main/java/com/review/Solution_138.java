package com.review;

import java.util.HashMap;
import java.util.Map;

public class Solution_138 {
    public Node copyRandomList(Node head) {
        Node mockHead = new Node(-1), move = mockHead;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node copy = new Node(head.val);
            map.put(head, copy);
            move.next = copy;
            move = move.next;
            head = head.next;
        }
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node oldN = entry.getKey(), newN = entry.getValue();
            if(oldN.random != null){
                newN.random = map.get(oldN.random);
            }
        }
        return mockHead.next;
    }
}
