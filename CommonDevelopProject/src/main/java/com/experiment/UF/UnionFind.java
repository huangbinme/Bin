package com.experiment.UF;

public class UnionFind {
    private int[] ids;
    private int count;

    public void union(int p, int q) {
        int pPathId = find(p);
        int qPathID = find(q);
        if(pPathId==qPathID){
            return;
        }
        for (int i = 0; i < ids.length; i++) {
            if(ids[i]==qPathID){
                ids[i] = pPathId;
            }
        }
        count--;
    }

    public int find(int p) {
        return ids[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public boolean notConnected(int p, int q) {
        return !connected(p, q);
    }

    public int count() {
        return this.count;
    }

    public UnionFind(int n) {
        count = n;
        this.ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }
}
