package graph.graph.weighted.undirectional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EdgeWeightedGraph {

    private int V;

    private int E;

    private Map<Integer, List<Edge>> map;

    public EdgeWeightedGraph(int V) {
        this.map = new HashMap<>();
        for (int i = 0; i < V; i++) {
            this.map.put(i, new ArrayList<>());
        }
        this.V = V;
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(Edge e) {
        int x = e.either(), y = e.other(x);
        map.get(x).add(e);
        map.get(y).add(e);
        this.E++;
    }

    public Iterable<Edge> adj(int v) {
        return map.get(v);
    }

    public Iterable<Edge> edges(int v) {
        List<Edge> list = new ArrayList<>();
        for (Map.Entry<Integer, List<Edge>> entry : this.map.entrySet()) {
            Integer key = entry.getKey();
            for (Edge edge : entry.getValue()) {
                if(edge.either() > key){
                    list.add(edge);
                }
            }
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<Edge>> entry : this.map.entrySet()) {
            sb.append(entry.getKey()).append(" -> ");
            for (Edge edge : entry.getValue()) {
                sb.append("[").append(edge.other(entry.getKey())).append(", ").append(edge.getWeight()).append("]");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
