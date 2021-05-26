package graph.search.path;


import graph.api.GraphApi;
import graph.search.api.PathSearch;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DFSPathSearch implements PathSearch {
    private Boolean[] marked;
    private Integer[] path;
    private int baseVertex;

    public DFSPathSearch(GraphApi graph, int baseVertex) {
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

    @Override
    public boolean hasPathTo(int inputVertex) {
        return marked[inputVertex];
    }

    @Override
    public Iterable<Integer> pathTo(int inputVertex) {
        if (!hasPathTo(inputVertex)) return null;
        Deque<Integer> queue = new LinkedList<>();
        int index = inputVertex;
        for (; ; ) {
            queue.addFirst(index);
            if (index == baseVertex) break;
            index = path[index];
        }
        return queue;
    }
}
