package com.algorithm.graph;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SPFATest {

    @Test
    public void testGetShortestDistance() {
        SPFA spfa = new SPFA();
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.put(0, Map.of(1, 6, 2, 5, 3, 5));
        graph.put(1, Map.of(4, -1));
        graph.put(2, Map.of(1, -2, 4, 1));
        graph.put(3, Map.of(2, -2, 5, -1));
        graph.put(4, Map.of(6, 3));
        graph.put(5, Map.of(6, 3));
        int[] shortestDistance = spfa.getShortestDistance(graph, 7, 0);
        Assert.assertEquals(shortestDistance, new int[]{0, 1, 3, 5, 0, 4, 3});
    }
}