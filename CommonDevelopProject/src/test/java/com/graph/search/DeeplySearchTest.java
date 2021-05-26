package com.graph.search;

import com.algorithm.Constant;
import com.graph.api.GraphApi;
import com.graph.graph.Graph;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class DeeplySearchTest {

    GraphApi graph;

    @BeforeTest
    public void initGraph() throws IOException {
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
        this.graph = new Graph(vertexCount);
        addEdgeList.forEach(integers -> graph.addEdge(integers[0], integers[1]));
    }

    @Test
    public void testMarked() {
        DeeplySearch deeplySearch = new DeeplySearch(graph,0);
        Assert.assertEquals(deeplySearch.marked(0),true);
        Assert.assertEquals(deeplySearch.marked(1),true);
        Assert.assertEquals(deeplySearch.marked(4),true);
        Assert.assertEquals(deeplySearch.marked(3),true);
        Assert.assertEquals(deeplySearch.marked(7),false);
        Assert.assertEquals(deeplySearch.marked(10),false);
    }

    @Test
    public void testCount() {
        DeeplySearch deeplySearch = new DeeplySearch(graph,0);
        Assert.assertEquals(deeplySearch.count(),7);
        DeeplySearch deeplySearch2 = new DeeplySearch(graph,10);
        Assert.assertEquals(deeplySearch2.count(),4);
    }
}