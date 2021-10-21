package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WordDictionaryTest {

    @Test
    public void testAddWord() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        System.out.println(dictionary.search("a"));
    }
}