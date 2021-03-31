package com.graph.search.path;

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

public class BFSPathSearchTest {
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
    public void testHasPathTo() {
        BFSPathSearch bfsPathSearch = new BFSPathSearch(graph,0);
        Assert.assertEquals(bfsPathSearch.hasPathTo(0),true);
        Assert.assertEquals(bfsPathSearch.hasPathTo(3),true);
        Assert.assertEquals(bfsPathSearch.hasPathTo(2),true);
        Assert.assertEquals(bfsPathSearch.hasPathTo(6),true);
        Assert.assertEquals(bfsPathSearch.hasPathTo(5),true);
        Assert.assertEquals(bfsPathSearch.hasPathTo(7),false);
        Assert.assertEquals(bfsPathSearch.hasPathTo(9),false);
    }

    @Test
    public void testPathTo() {
        BFSPathSearch search = new BFSPathSearch(graph,0);
        System.out.println(search.pathTo(0));
        System.out.println(search.pathTo(1));
        System.out.println(search.pathTo(3));
        Assert.assertEquals(search.pathTo(7),null);
        System.out.println(search.pathTo(6));
    }
}