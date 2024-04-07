package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ThroneInheritanceTest {

    @Test
    public void testBirth() {
        ThroneInheritance t = new ThroneInheritance("king");
        t.birth("king","clyde");
        t.birth("clyde","shannon");
        t.birth("shannon","scott");
        t.birth("king","keith");
        t.birth("clyde","joseph");
        System.out.println(t.getInheritanceOrder());
    }
}