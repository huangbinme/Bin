package graph.search.path;


import graph.api.GraphApi;
import graph.search.api.PathSearch;

import java.util.*;

public class BFSPathSearch implements PathSearch {
    private Boolean[] marked;
    private Integer[] path;
    private int baseVertex;

    public BFSPathSearch(GraphApi graph, int baseVertex) {
        this.marked = new Boolean[graph.vertexCount()];
        this.baseVertex = baseVertex;
        Arrays.fill(marked, false);
        this.path = new Integer[graph.vertexCount()];
        bfs(graph, baseVertex);
    }

    private void bfs(GraphApi graph, int vertex) {
        marked[vertex] = true;
        List<Integer> list = graph.getAdjacentVertices(vertex);
        Queue<Integer> queue = new LinkedList<>();
        list.forEach(integer -> {
            this.marked[integer] = true;
            path[integer] = baseVertex;
            queue.add(integer);
        });
        while (!queue.isEmpty()) {
            Integer integer = queue.remove();
            graph.getAdjacentVertices(integer).stream()
                    .filter(num -> !marked[num])
                    .forEach(num -> {
                        this.marked[num] = true;
                        path[num] = integer;
                        queue.add(num);
                    });
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
