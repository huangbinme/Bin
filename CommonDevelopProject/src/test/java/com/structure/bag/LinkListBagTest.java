package com.structure.bag;

import java.util.Random;

public class LinkListBagTest {
    public static void main(String[] args) {
        LinkListBag<Integer> linkListStack = new LinkListBag();
        linkListStack.add(1);
        linkListStack.add(2);
        linkListStack.add(3);
        linkListStack.add(4);
        linkListStack.add(5);
        linkListStack.add(6);
        for(Integer result : linkListStack){
            System.out.println(result);
        }

        System.out.println("Present RandomBag");
        System.out.println(linkListStack.getObjByRandomBag());
        System.out.println(linkListStack.getObjByRandomBag());
        System.out.println(linkListStack.getObjByRandomBag());
        System.out.println(linkListStack.getObjByRandomBag());
        System.out.println(linkListStack.getObjByRandomBag());
        System.out.println(linkListStack.getObjByRandomBag());
    }
}