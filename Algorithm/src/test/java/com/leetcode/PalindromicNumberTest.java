package com.leetcode;

import org.junit.Test;

public class PalindromicNumberTest {

    @Test
    public void isPalindrome() {
        Long start = System.currentTimeMillis();
        PalindromicNumber obj = new PalindromicNumber();
        System.out.println(obj.isPalindrome(-12332431));
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}