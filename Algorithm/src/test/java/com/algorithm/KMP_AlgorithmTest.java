package com.algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class KMP_AlgorithmTest {

    KMP_Algorithm kmpAlgorithm = new KMP_Algorithm();

    @Test
    public void testGetLPS() {
        Assert.assertEquals(test("ababcabcabababd", "ababd"), Arrays.asList(10));
        Assert.assertEquals(test("abcdefg", "cde"), Arrays.asList(2));
        Assert.assertEquals(test("abcdefgh", "xyz"), Arrays.asList(-1));
        Assert.assertEquals(test("abcdef", ""), Arrays.asList(-1));
        Assert.assertEquals(test("abcdef", "abcdef"), Arrays.asList(0));
        Assert.assertEquals(test("ab", "abc"), Arrays.asList(-1));
        Assert.assertEquals(test("a".repeat(100000) + "b", "a".repeat(1000) + "b"), Arrays.asList(99000));
        Assert.assertEquals(test("aaaaa", "aa"), Arrays.asList(0, 1, 2, 3));
        Assert.assertEquals(test("ababcababcabc", "ababc"), Arrays.asList(0, 5));
        Assert.assertEquals(test("abcabcabc", "abc"), Arrays.asList(0, 3, 6));
        Assert.assertEquals(test("abababab", "aba"), Arrays.asList(0, 2, 4));
        Assert.assertEquals(test("abcdefg", "xyz"), Arrays.asList(-1));
    }

    private List<Integer> test(String s1, String s2) {
        return kmpAlgorithm.contains(s1, s2);
    }
}