package com.leetcode.offer;

import org.testng.annotations.Test;

public class TopVotedCandidateTest {

    @Test
    public void testQ() {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 0, 1, 1, 2}, new int[]{0,67,69,74,87});
        System.out.println(topVotedCandidate.q(4));
        System.out.println(topVotedCandidate.q(62));
        System.out.println(topVotedCandidate.q(100));
        System.out.println(topVotedCandidate.q(88));
    }
}