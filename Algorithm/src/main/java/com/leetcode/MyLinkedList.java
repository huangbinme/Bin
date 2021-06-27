package com.leetcode;

public class MyLinkedList {
    Node head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new Node(0, null);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node node = head;
        for (int i = 0; i < index + 1; i++) {
            if (node.next == null) return -1;
            node = node.next;
        }
        return node.v;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node preHead = head.next;
        head.next = new Node(val, preHead);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(val, null);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            if (node == null) return;
            node = node.next;
        }
        Node tmp = node.next;
        Node newNode = new Node(val, tmp);
        node.next = newNode;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            if (node.next == null) return;
            node = node.next;
        }
        if (node.next == null) return;
        Node tmp = node.next.next;
        node.next = tmp;
    }

    public class Node {
        int v;
        Node next;

        public Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }
}
