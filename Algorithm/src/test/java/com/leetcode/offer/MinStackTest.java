package com.leetcode.offer;

import org.testng.annotations.Test;

public class MinStackTest {
    @Test
    public void testPush() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.min();
        stack.pop();
        stack.top();
        stack.min();
    }
}