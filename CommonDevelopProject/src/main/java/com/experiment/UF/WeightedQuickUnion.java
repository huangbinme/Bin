package com.experiment.UF;

public class WeightedQuickUnion implements UnionFind{
    private int[] ids;
    private int count;

    @Override
    public void union(int p, int q) {
        int pPathId = find(p);
        int qPathID = find(q);
        if (pPathId == qPathID) {
            return;
        }
        ids[qPathID] = pPathId;
        count--;
    }

    public int find(int p) {
        while (ids[p] != p) {
            p = ids[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public boolean notConnected(int p, int q) {
        return !connected(p, q);
    }

    @Override
    public int count() {
        return this.count;
    }

    public WeightedQuickUnion(int n) {
        count = n;
        this.ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }
}
