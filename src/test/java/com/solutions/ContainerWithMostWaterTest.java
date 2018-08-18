package com.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {

    @Test
    public void maxArea() {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        System.out.print(obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}