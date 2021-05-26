package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        levelList.add(1);
        addToResult(result, levelList);
        for (int i = 1; i < numRows; i++) {
            levelList = dp(levelList);
            addToResult(result, levelList);
        }
        return result;
    }

    private List<Integer> dp(List<Integer> levelList) {
        List<Integer> levelListCopy = new ArrayList<>();
        levelListCopy.add(1);
        for (int i = 1; i < levelList.size(); i++) {
            levelListCopy.add(i, levelList.get(i - 1) + levelList.get(i));
        }
        levelListCopy.add(1);
        return levelListCopy;
    }

    private void addToResult(List<List<Integer>> result, List<Integer> levelList) {
        List<Integer> levelListCopy = new ArrayList<>(levelList);
        result.add(levelListCopy);
    }

}
