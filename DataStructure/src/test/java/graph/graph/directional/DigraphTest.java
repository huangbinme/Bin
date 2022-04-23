package graph.graph.directional;

import graph.graph.unweighted.directional.Digraph;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class DigraphTest {

    @Test
    public void testReverse() throws IOException {
        String file = "/Users/bin/Downloads/algs4-data/tinyDG.txt";
        List<String> list = FileUtils.readLines(FileUtils.getFile(file), Charset.defaultCharset());
        Digraph digraph = new Digraph(Integer.parseInt(list.get(0)));
        for (int i = 2; i < list.size(); i++) {
            int v = Integer.parseInt(list.get(i).trim().split("\\s+")[0]);
            int w = Integer.parseInt(list.get(i).trim().split("\\s+")[1]);
            digraph.addEdge(v, w);
        }
        System.out.println(digraph);
        System.out.println(digraph.reverse());
    }
}