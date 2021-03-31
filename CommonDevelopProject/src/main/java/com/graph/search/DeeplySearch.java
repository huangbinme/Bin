package com.graph.search;

import com.graph.api.GraphApi;
import com.graph.search.api.Search;

import java.util.Arrays;
import java.util.List;

public class DeeplySearch implements Search {
    private Boolean[] marked;
    private int count = 0;

    public DeeplySearch(GraphApi graph, int baseVertex) {
        marked = new Boolean[graph.vertexCount()];
        Arrays.fill(marked, false);
        dfs(graph, baseVertex);
    }

    private void dfs(GraphApi graph, int vertex) {
        this.marked[vertex] = true;
        this.count++;
        List<Integer> integerList = graph.getAdjacentVertices(vertex);
        for (int i = 0; i < integerList.size(); i++) {
            if (!marked(integerList.get(i))) dfs(graph, integerList.get(i));
        }
    }

    @Override
    public boolean marked(int inputVertex) {
        return this.marked[inputVertex];
    }

    @Override
    public int count() {
        return this.count;
    }
}
