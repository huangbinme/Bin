package com.graph;


import com.algorithm.Constant;
import com.graph.graph.Graph;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GraphTest {

    @Test
    public void testVertexCount() {
    }

    @Test
    public void testEdgeCount() {
    }

    @Test
    public void testAddEdge() {
    }

    @Test
    public void testGetAdjacentVertices() {
    }

    @Test
    public void testPrintGraph() {
    }

    @Test
    public void test() throws IOException {
        List<String> list = Files.lines(Paths.get(Constant.EXPERIMENT_FILE_ROOT, "tinyG.txt")).collect(Collectors.toList());
        int vertexCount = Integer.parseInt(list.get(0));
        int edgeCount = Integer.parseInt(list.get(1));
        List<Integer[]> addEdgeList = list.subList(2, list.size()).stream()
                .map(s -> {
                    Integer[] ints = new Integer[2];
                    ints[0] = Integer.valueOf(s.split(" ")[0]);
                    ints[1] = Integer.valueOf(s.split(" ")[1]);
                    return ints;
                })
                .collect(Collectors.toList());
        Graph graph = new Graph(vertexCount);
        addEdgeList.forEach(integers -> graph.addEdge(integers[0], integers[1]));
        Assert.assertEquals(graph.edgeCount(), edgeCount);
        System.out.println(graph.printGraph());
    }

    @Test
    public void test2() throws IOException {
        List<String> list = Files.lines(Paths.get(Constant.EXPERIMENT_FILE_ROOT, "tinyG.txt")).collect(Collectors.toList());
        int vertexCount = Integer.parseInt(list.get(0));
        int edgeCount = Integer.parseInt(list.get(1));
        List<Integer[]> addEdgeList = list.subList(2, list.size()).stream()
                .map(s -> {
                    Integer[] ints = new Integer[2];
                    ints[0] = Integer.valueOf(s.split(" ")[0]);
                    ints[1] = Integer.valueOf(s.split(" ")[1]);
                    return ints;
                })
                .collect(Collectors.toList());
        Graph graph = new Graph(vertexCount);
    }
}