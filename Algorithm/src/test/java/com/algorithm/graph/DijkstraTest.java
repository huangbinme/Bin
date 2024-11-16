package com.algorithm.graph;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DijkstraTest {

    @Test
    public void testGetShortestDistance() {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.put(0, Map.of(1, 2, 3, 6));
        graph.put(1, Map.of(0, 2, 3, 2, 2, 3));
        graph.put(2, Map.of(1, 3, 3, 2));
        graph.put(3, Map.of(0, 6, 1, 2, 2, 2));
        Dijkstra dijkstra = new Dijkstra();
        int[] shortestDistance = dijkstra.getShortestDistance(graph, 4, 0);
        Assert.assertEquals(shortestDistance, new int[]{0, 2, 5, 4});
    }
}