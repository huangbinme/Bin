package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution_138 {
    List<Node> oldNodes = new ArrayList<>();
    List<Node> newNodes = new ArrayList<>();

    public Node copyRandomList(Node head) {
        if(head==null) return null;
        setUpSets(head);
        setUpRandom();
        return linkThenReturn();
    }

    private Node linkThenReturn() {
        Node head = newNodes.get(0);
        for (int i = 0; i < newNodes.size()-1; i++) {
            newNodes.get(i).next = newNodes.get(i+1);
        }
        return head;
    }

    private void setUpRandom() {
        for (int i = 0; i < oldNodes.size(); i++) {
            Node random = oldNodes.get(i).random;
            if(random!=null){
                int randomIndex = oldNodes.indexOf(random);
                Node node = newNodes.get(i);
                node.random = newNodes.get(randomIndex);
            }
        }
    }

    private void setUpSets(Node head) {
        Node tmp = head;
        while (tmp!=null){
            oldNodes.add(tmp);
            newNodes.add(new Node(tmp.val));
            tmp = tmp.next;
        }
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
