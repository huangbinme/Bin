package com.graph.search;

import com.graph.api.GraphApi;

import java.util.*;

public class DfsPathSearch {
    private Boolean[] marked;
    private Integer[] path;
    private int baseVertex;

    public DfsPathSearch(GraphApi graph, int baseVertex) {
        this.marked = new Boolean[graph.vertexCount()];
        this.baseVertex = baseVertex;
        Arrays.fill(marked, false);
        this.path = new Integer[graph.vertexCount()];
        dfs(graph, baseVertex);
    }

    private void dfs(GraphApi graph, int vertex) {
        this.marked[vertex] = true;
        List<Integer> integerList = graph.getAdjacentVertices(vertex);
        for (int i = 0; i < integerList.size(); i++) {
            Integer v = integerList.get(i);
            if (!marked(v)) {
                path[v] = vertex;
                dfs(graph, v);
            }
        }
    }

    private boolean marked(int inputVertex) {
        return this.marked[inputVertex];
    }

    public boolean hasPathTo(int inputVertex) {
        return marked[inputVertex];
    }

    public Iterable<Integer> pathTo(int inputVertex) {
        if (!hasPathTo(inputVertex)) return null;
        Deque<Integer> deque = new LinkedList<>();
        int index = inputVertex;
        for (; ; ) {
            deque.addFirst(index);
            if (index == baseVertex) break;
            index = path[index];
        }
        return deque;
    }
}
