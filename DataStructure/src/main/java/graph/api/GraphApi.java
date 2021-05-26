package graph.api;

import java.util.List;

public interface GraphApi {
    int vertexCount();

    int edgeCount();

    void addEdge(int v1, int v2);

    List<Integer> getAdjacentVertices(int v);

    String printGraph();
}
