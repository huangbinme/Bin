package com.structure.stack;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack(1);
        arrayStack.push(1);
        System.out.println(arrayStack);
        arrayStack.push(2);
        System.out.println(arrayStack);
        arrayStack.push(3);
        System.out.println(arrayStack);
        arrayStack.push(4);
        System.out.println(arrayStack);
        arrayStack.push(5);
        System.out.println(arrayStack);
        arrayStack.push(6);
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}