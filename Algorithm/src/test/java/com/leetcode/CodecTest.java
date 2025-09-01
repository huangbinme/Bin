package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CodecTest {

    @Test
    public void testDeserialize() {
        Codec codec = new Codec();
        TreeNode deserialize = codec.deserialize("1,2,N,N,3,4,N,N,5,N,N");
    }
}