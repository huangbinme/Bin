package com.experiment.UF;

import com.util.CommonConfigConstant;
import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) throws IOException {
        //String fileName = "tinyUF.txt";
        String fileName = "largeUF.txt";
        //String fileName = "mediumUF.txt";
        Path path = Paths.get(CommonConfigConstant.algsDataFilesRootDir+"//"+fileName);
        System.out.println(String.format("Processing file [%s]",path.toAbsolutePath().toString()));
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

//        UnionFind uf = new QuickFind(n);
//        Demo.cal(inputNodePair,uf);
//
//        UnionFind uf2 = new QuickUnion(n);
//        Demo.cal(inputNodePair,uf2);

        UnionFind uf3 = new WeightedQuickUnion(n);
        Demo.cal(inputNodePair,uf3);
    }

    public static void cal(List<List<Integer>> inputNodePair, UnionFind uf){
        StopWatch stopWatch = StopWatch.createStarted();
        inputNodePair.stream()
                .forEach(integers -> {
                    if(uf.notConnected(integers.get(0),integers.get(1))){
                        uf.union(integers.get(0),integers.get(1));
                    }
                });
        stopWatch.stop();
        System.out.println(String.format("Result number is [%s] by [%s], time is [%s] MICROSECONDS", uf.count(),uf.getClass().getName(),stopWatch.getTime(TimeUnit.MICROSECONDS)));
    }
}
