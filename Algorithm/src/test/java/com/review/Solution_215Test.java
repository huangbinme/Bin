package com.review;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_215Test {

    @Test
    public void testFindKthLargest() throws IOException {
        Solution_215 solution215 = new Solution_215();
        List<String> list = Files.readAllLines(Path.of("/Users/bin/Desktop/1.input"));
        List<Integer> collect = Arrays.stream(list.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        int[] array = collect.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(solution215.findKthLargest(array, 8000));
    }
}