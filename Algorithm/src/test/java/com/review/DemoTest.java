package com.review;

import org.testng.annotations.Test;

import java.util.Deque;

import static org.testng.Assert.*;

public class DemoTest {

    @Test
    public void testSolution1() {
        Demo demo = new Demo();
        System.out.println(demo.solution1("011100"));
        System.out.println(demo.solution1("1"));
        System.out.println(demo.solution1("10"));
        System.out.println(demo.solution1("111"));
    }
}