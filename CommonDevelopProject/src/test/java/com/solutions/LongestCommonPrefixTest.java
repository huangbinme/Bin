package com.solutions;

import org.junit.Test;

public class LongestCommonPrefixTest {

    @Test
    public void longestCommonPrefix() {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        System.out.print(obj.longestCommonPrefix(new String[]{"","",""}).length());

    }
}