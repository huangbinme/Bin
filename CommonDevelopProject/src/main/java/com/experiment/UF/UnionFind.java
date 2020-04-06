package com.experiment.UF;

public interface UnionFind {
    boolean notConnected(int p, int q);
    boolean connected(int p, int q);
    void union(int p, int q);
    int count();
}
