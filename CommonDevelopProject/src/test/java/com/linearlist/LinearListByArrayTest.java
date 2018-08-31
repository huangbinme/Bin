package com.linearlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinearListByArrayTest {

    @Test
    public void size() {
        LinearListByArray llb = new LinearListByArray();
        llb.add(1);
        llb.add(2);
        llb.add("Hello1");
        llb.add("Hello2");
        Assert.assertEquals(llb.size(),4);
    }

    @Test
    public void print() {
        LinearListByArray llb = new LinearListByArray();
        llb.add(1);
        llb.add(2);
        llb.print();
    }

    @Test
    public void add() {
        LinearListByArray llb = new LinearListByArray();
        llb.add(1);
        llb.add("Hello");
        Assert.assertEquals(llb.find(0),1);
        Assert.assertEquals(llb.find(1).toString(),"Hello");
    }

    @Test
    public void addByIndex() {
        LinearListByArray llb = new LinearListByArray();
        llb.add("hello!",0);
        Assert.assertEquals(llb.find(0).toString(),"hello!");
        llb.add("hello!",10);//Will throw error exception
        llb.add(2,1);
        llb.add(1000);
        llb.add(1001);
        llb.add(1002);
        llb.add(1003);
        llb.add(1004);
        llb.add(1005);
        llb.add(1006);
        llb.add(1007);
        llb.add(9999,4);
        Assert.assertEquals(llb.find(4),9999);
    }

    @Test
    public void find() {
        LinearListByArray llb = new LinearListByArray();
        llb.add(1);
        llb.add("Hello");
        llb.add("Hello1");
        llb.add("Hello2");
        llb.add(6);
        llb.add(10086);
        Assert.assertEquals(llb.find(4),6);
        llb.find(999);
    }

    @Test
    public void delete() {
        LinearListByArray llb = new LinearListByArray(1000);
        llb.add(0);
        llb.add(1);
        llb.add(2);
        llb.add(3);
        llb.add(4);
        llb.add(5);
        llb.add(6);
        llb.delete(0);
        Assert.assertEquals(llb.find(0),1);
        llb.delete(999);//Will throw error exception
        llb.delete(5);
        Assert.assertEquals(llb.size(),5);
    }
}