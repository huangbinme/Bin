package graph.graph.weighted.undirectional;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static org.testng.Assert.*;

public class KruskalMSTTest {

    @Test
    public void testWeight() throws IOException {
        String file = "/Users/bin/Downloads/algs4-data/mediumEWG.txt";
        List<String> list = FileUtils.readLines(FileUtils.getFile(file), Charset.defaultCharset());
        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(Integer.parseInt(list.get(0)));
        for (int i = 2; i < list.size(); i++) {
            String[] s = list.get(i).trim().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            double w = Double.parseDouble(s[2]);
            edgeWeightedGraph.addEdge(new Edge(x, y, w));
        }
        KruskalMST mst = new KruskalMST(edgeWeightedGraph);
        System.out.println(mst.weight());
    }
}