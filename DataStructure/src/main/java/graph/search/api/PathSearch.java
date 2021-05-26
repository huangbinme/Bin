package graph.search.api;

public interface PathSearch {
    Iterable<Integer> pathTo(int inputVertex);

    boolean hasPathTo(int inputVertex);
}
