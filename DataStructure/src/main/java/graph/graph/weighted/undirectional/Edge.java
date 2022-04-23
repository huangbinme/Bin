package graph.graph.weighted.undirectional;

public class Edge implements Comparable<Edge> {

    private int v;

    private int w;

    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int v) {
        if (v == this.v) {
            return this.w;
        } else if (v == this.w) {
            return this.v;
        } else {
            throw new RuntimeException("Inconsistent edge");
        }
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight > o.getWeight()) {
            return 1;
        } else if (this.weight < o.getWeight()) {
            return -1;
        } else {
            return 0;
        }
    }
}
