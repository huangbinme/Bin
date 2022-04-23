package graph.graph.unweighted.directional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Digraph {

    private int V = 0;

    private int E = 0;

    private Map<Integer, List<Integer>> map;

    public Digraph(int V) {
        this.V = V;
        this.map = new HashMap<>();
        for (int i = 0; i < V; i++) {
            this.map.put(i, new ArrayList<>());
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        this.map.get(v).add(w);
        this.E++;
    }

    public Iterable<Integer> adj(int v) {
        return map.get(v);
    }

    public Digraph reverse() {
        Digraph digraph = new Digraph(this.V);
        for (Map.Entry<Integer, List<Integer>> entry : this.map.entrySet()) {
            for (Integer integer : entry.getValue()) {
                digraph.addEdge(integer, entry.getKey());
            }
        }
        return digraph;
    }

    @Override
    public String toString() {
        return "Digraph{" +
                "V=" + V +
                ", E=" + E +
                ", map=" + map +
                '}';
    }
}
