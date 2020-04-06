package com.experiment.UF;

public class WeightedQuickUnion implements UnionFind{
    private int[] ids;
    private int[] treeHeight;
    private int count;

    @Override
    public void union(int p, int q) {
        int pPathId = find(p);
        int qPathID = find(q);
        if (pPathId == qPathID) {
            return;
        }
        if(treeHeight[pPathId]>treeHeight[qPathID]){
            ids[pPathId] = qPathID;
        }else {
            ids[qPathID] = pPathId;
            treeHeight[qPathID] = treeHeight[qPathID]+1;
        }
        count--;
    }

    public int find(int p) {
        while (ids[p] != p) {
            ids[p] = ids[ids[p]];//our purpose is to find root node, so we could compress path and let it point to parent node
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
        this.treeHeight = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }

        for (int i = 0; i < n; i++) {
            treeHeight[i] = 1;
        }
    }
}
