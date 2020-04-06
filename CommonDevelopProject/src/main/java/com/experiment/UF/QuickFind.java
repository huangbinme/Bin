package com.experiment.UF;

public class QuickFind implements UnionFind{
    private int[] ids;
    private int count;

    @Override
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

    public QuickFind(int n) {
        count = n;
        this.ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }
}
