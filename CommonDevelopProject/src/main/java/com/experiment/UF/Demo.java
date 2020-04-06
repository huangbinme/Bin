package com.experiment.UF;

import com.util.CommonConfigConstant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) throws IOException {
        String fileName = "tinyUF.txt";
        //String fileName = "largeUF.txt";
        Path path = Paths.get(CommonConfigConstant.algsDataFilesRootDir+"//"+fileName);
        List<String> stringList = Files.lines(path).map(String::trim).collect(Collectors.toList());
        Integer n = Integer.valueOf(stringList.get(0));
        List<List<Integer>> inputNodePair =  stringList.stream()
                .skip(1)
                .map(str -> {
                    List<Integer> integers = new ArrayList<>();
                    int p = Integer.valueOf(str.split(" ")[0]);
                    int q = Integer.valueOf(str.split(" ")[1]);
                    integers.add(p);
                    integers.add(q);
                    return integers;
                })
                .collect(Collectors.toList());
        System.out.println(String.format("Init N number is [%s]",n));
        UnionFind unionFind = new UnionFind(n);
        inputNodePair.stream()
                .forEach(integers -> {
                    if(unionFind.notConnected(integers.get(0),integers.get(1))){
                        unionFind.union(integers.get(0),integers.get(1));
                    }
                });
        System.out.println(String.format("Result component number is [%s]",unionFind.count()));
    }
}
