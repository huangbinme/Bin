package graph.graph.weighted.undirectional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MST {

    private double weight;

    private Iterable<Edge> edges;

    public MST(EdgeWeightedGraph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.naturalOrder());
        List<Edge> edges = new ArrayList<>();
        double weightCount = 0;
        int nodeCount = 1;
        boolean[] mark = new boolean[graph.V()];
        for (Edge edge : graph.adj(0)) {
            queue.add(edge);
        }
        mark[0] = true;
        while (nodeCount != graph.V()) {
            while (!queue.isEmpty() && mark[queue.peek().either()] && mark[queue.peek().other(queue.peek().either())]) {
                queue.poll();
            }
            if (queue.isEmpty()) break;
            Edge e = queue.poll();
            int target = mark[e.either()] ? e.other(e.either()) : e.either();
            for (Edge edge : graph.adj(target)) {
                queue.add(edge);
            }
            weightCount += e.getWeight();
            mark[target] = true;
            nodeCount++;
            edges.add(e);
        }
        this.weight = weightCount;
        this.edges = edges;
    }

    public Iterable<Edge> edges() {
        return this.edges;
    }

    public double weight() {
        return weight;
    }
}
