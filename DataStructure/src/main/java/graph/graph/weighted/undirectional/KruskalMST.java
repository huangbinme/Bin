package graph.graph.weighted.undirectional;

import java.util.*;

public class KruskalMST {

    private double weight;

    private List<Edge> edges;

    public KruskalMST(EdgeWeightedGraph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < graph.V(); i++) {
            for (Edge edge : graph.adj(i)) {
                if (edge.either() == i) {
                    queue.add(edge);
                }
            }
        }
        UF uf = new UF(graph.V());
        this.weight = 0;
        this.edges = new ArrayList<>();
        while (this.edges.size() != graph.V() - 1) {
            while (!queue.isEmpty() && uf.isConnected(queue.peek().either(), queue.peek().other(queue.peek().either())))
                queue.poll();
            if (queue.isEmpty()) break;
            Edge e = queue.poll();
            int x = e.either(), y = e.other(x);
            uf.connect(x, y);
            this.weight += e.getWeight();
            this.edges.add(e);
        }
    }

    public Iterable<Edge> edges() {
        return this.edges;
    }

    public double weight() {
        return this.weight;
    }

    public static class UF {

        private final int V;
        private Map<Integer, Set<Integer>> map;

        public UF(int V) {
            this.map = new HashMap<>();
            for (int i = 0; i < V; i++) {
                map.put(i, new HashSet<>());
            }
            this.V = V;
        }

        public void connect(int x, int y) {
            map.get(x).add(y);
            map.get(y).add(x);
        }

        public boolean isConnected(int x, int y) {
            boolean[] mark = new boolean[this.V];
            return dfs(x, y, mark);
        }

        private boolean dfs(int x, int y, boolean[] mark) {
            if (x == y) return true;
            if (mark[x]) return false;
            mark[x] = true;
            for (Integer integer : map.get(x)) {
                if (dfs(integer, y, mark)) return true;
            }
            return false;
        }
    }
}
