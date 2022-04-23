package graph.graph.unweighted.directional;

import java.util.ArrayList;
import java.util.List;

public class DirectedCycle {

    private boolean hasCycle = false;
    private List<Integer> list;

    public DirectedCycle(Digraph digraph) {
        List<Integer> list = new ArrayList<>();
        boolean[] mark = new boolean[digraph.E()];
        for (int i = 0; i < digraph.E(); i++) {
            dfs(i, digraph, list, mark);
            if (hasCycle) {
                this.list = list;
                break;
            }
        }
    }

    private boolean dfs(int E, Digraph digraph, List<Integer> list, boolean[] mark) {
        if (mark[E] && list.size() > 1) return true;
        mark[E] = true;
        list.add(E);
        for (Integer integer : digraph.adj(E)) {
            boolean ans = dfs(integer, digraph, list, mark);
            if (ans) {
                this.hasCycle = true;
                return true;
            }
        }
        mark[E] = false;
        list.remove(list.size() - 1);
        return false;
    }

    public boolean hasCycle() {
        return this.hasCycle;
    }

    public Iterable<Integer> cycle() {
        return hasCycle ? this.list : null;
    }
}
