package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThroneInheritance {

    Map<String, Person> map;

    Person king;

    public ThroneInheritance(String kingName) {
        king = new Person(kingName);
        map = new HashMap<>();
        map.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person parent = map.get(parentName);
        Person child = new Person(childName);
        List<Person> sub = parent.sub;
        if (sub == null) {
            sub = new ArrayList<>();
            sub.add(child);
            parent.sub = sub;
        } else {
            sub.add(child);
        }
        map.put(childName, child);
    }

    public void death(String name) {
        map.get(name).alive = false;
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        dfs(king, ans);
        return ans;
    }

    private void dfs(Person king, List<String> ans) {
        if (king == null) return;
        addIfAlive(ans, king);
        if (king.sub == null) return;
        for (int i = 0; i < king.sub.size(); i++) {
            dfs(king.sub.get(i), ans);
        }
    }

    public void addIfAlive(List<String> ans, Person p) {
        if (p.alive) ans.add(p.name);
    }

    public static class Person {
        String name;
        boolean alive;
        List<Person> sub;

        public Person(String name) {
            this.name = name;
            this.alive = true;
        }
    }
}
