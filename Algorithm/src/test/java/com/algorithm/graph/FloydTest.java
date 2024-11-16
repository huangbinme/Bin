package com.algorithm.graph;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FloydTest {

    @Test
    public void testGetShortestDistance() {
        Floyd floyd = new Floyd();
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.put(0, Map.of(3, 7, 1, 3));
        graph.put(1, Map.of(0, 8, 2, 2));
        graph.put(2, Map.of(0, 5, 3, 1));
        graph.put(3, Map.of(0, 2));
        int[][] shortestDistance = floyd.getShortestDistance(graph, 4);
        Assert.assertEquals(shortestDistance[0], new int[]{0, 3, 5, 6});
        Assert.assertEquals(shortestDistance[1], new int[]{5, 0, 2, 3});
        Assert.assertEquals(shortestDistance[2], new int[]{3, 6, 0, 1});
        Assert.assertEquals(shortestDistance[3], new int[]{2, 5, 7, 0});
    }
}