package graph.graph.unweighted.undirectional;


import graph.api.GraphApi;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph implements GraphApi {

    private final int vertexCount;
    private int edgeCount = 0;
    private List<Integer>[] adjacentTable;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacentTable = new List[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjacentTable[i] = new LinkedList<>();
        }
    }

    @Override
    public int vertexCount() {
        return this.vertexCount;
    }

    @Override
    public int edgeCount() {
        return this.edgeCount;
    }

    @Override
    public void addEdge(int v1, int v2) {
        adjacentTable[v1].add(v2);
        adjacentTable[v2].add(v1);
        this.edgeCount++;
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        return adjacentTable[v];
    }

    @Override
    public String printGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < adjacentTable.length; i++) {
            stringBuilder.append(i + " -> ");
            stringBuilder.append("[" + adjacentTable[i].stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]");
            if (i != adjacentTable.length - 1) stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
