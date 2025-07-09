package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TrieTest {

    @Test
    public void testInsert() {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));
        t.insert("app");
    }
}