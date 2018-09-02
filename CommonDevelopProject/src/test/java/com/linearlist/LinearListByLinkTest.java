package com.linearlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinearListByLinkTest {

    @Test
    public void print() {
        LinearListByLink list = new LinearListByLink();
        list.add(0);
        list.add("2");
        list.add(3);
        list.add(4);
        list.print();
    }

    @Test
    public void size() {
        LinearListByLink list = new LinearListByLink();
        list.add(0);
        Assert.assertEquals(list.size(),1);
        LinearListByLink list2 = new LinearListByLink();
        Assert.assertEquals(list2.size(),0);
        LinearListByLink list3 = new LinearListByLink();
        list3.add(0);
        list3.add(1);
        list3.add(2);
        Assert.assertEquals(list3.size(),3);
    }

    @Test
    public void find() {
        LinearListByLink list = new LinearListByLink();
        list.add(0);
        list.add(1);
        list.add(2);
        Assert.assertEquals(list.find(0),0);
        Assert.assertEquals(list.find(1),1);
        Assert.assertEquals(list.find(2),2);
        list.find(-1);//will throw outbound error
        list.find(999);//will throw outbound error
    }

    @Test
    public void add() {
        LinearListByLink list = new LinearListByLink();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add("4");
        list.add("5");
        Assert.assertEquals(list.find(0),0);
        Assert.assertEquals(list.find(5).toString(),"5");
    }

    @Test
    public void delete() {
        LinearListByLink list = new LinearListByLink();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add("4");
        list.add("5");
        list.delete(0);
        Assert.assertEquals(list.find(0),1);
        list.delete(4);
        Assert.assertEquals(list.find(3).toString(),"4");
        list.delete(2);
        Assert.assertEquals(list.find(2).toString(),"4");
        list.print();
        list.delete(0);
        list.delete(0);
        list.delete(0);
        list.add(999);
        Assert.assertEquals(list.find(0),999);
        list.delete(999);//will throw outbound error
    }
}