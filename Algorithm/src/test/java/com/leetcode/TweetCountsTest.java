package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TweetCountsTest {

    @Test
    public void testGetTweetCountsPerFrequency() {
        TweetCounts counts = new TweetCounts();
        counts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60);
    }
}