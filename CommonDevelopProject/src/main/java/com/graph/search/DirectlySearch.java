package com.graph.search;

import com.graph.api.GraphApi;
import com.graph.search.api.Search;

public class DirectlySearch implements Search {

    private final Integer baseVertex;
    private final GraphApi baseGraph;

    public DirectlySearch(GraphApi graph, int baseVertex) {
        this.baseGraph = graph;
        this.baseVertex = baseVertex;
    }

    @Override
    public boolean marked(int inputVertex) {
        return baseGraph.getAdjacentVertices(baseVertex).contains(inputVertex);
    }

    @Override
    public int count() {
        return baseGraph.getAdjacentVertices(baseVertex).size();
    }
}
