package com.solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_690 {
    int ans = 0;

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        dfs(map, map.get(id));
        return ans;
    }

    private void dfs(Map<Integer, Employee> map, Employee employee) {
        if (employee == null) return;
        ans += employee.importance;
        for (Integer integer : employee.subordinates) {
            dfs(map, map.get(integer));
        }
    }
}
