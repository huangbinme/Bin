package com.structure.stack;

public class LinkListStackTest {
    public static void main(String[] args) {
        LinkListStackTest.pushAndPopDemo();
        LinkListStackTest.reverseDemo();
    }

    public static void reverseDemo(){
        System.out.println("reverseDemo is present");
        LinkListStack<Integer> LinkListQueue = new LinkListStack();
        LinkListQueue.push(1);
        LinkListQueue.push(2);
        LinkListQueue.push(3);
        LinkListQueue.push(4);
        LinkListQueue.push(5);
        LinkListQueue.push(6);
        System.out.println(LinkListQueue);
        LinkListQueue.reverse();
        System.out.println(LinkListQueue);
    }

    public static void pushAndPopDemo(){
        LinkListStack<Integer> linkListStack = new LinkListStack();
        linkListStack.push(1);
        System.out.println(linkListStack);
        linkListStack.push(2);
        System.out.println(linkListStack);
        linkListStack.push(3);
        System.out.println(linkListStack);
        linkListStack.push(4);
        System.out.println(linkListStack);
        linkListStack.push(5);
        System.out.println(linkListStack);
        linkListStack.push(6);
        System.out.println(linkListStack);
        linkListStack.pop();
        System.out.println(linkListStack);
        linkListStack.pop();
        System.out.println(linkListStack);
        linkListStack.pop();
        System.out.println(linkListStack);
        linkListStack.pop();
        System.out.println(linkListStack);
        linkListStack.pop();
        System.out.println(linkListStack);
        linkListStack.pop();
        System.out.println(linkListStack);
    }
}