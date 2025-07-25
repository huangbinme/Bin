package com.algorithm;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Base62Test {

    @Test
    public void testEncode() {
        System.out.println(Base62.encode(2323435));
        System.out.println(Base62.decode("9KqL"));
    }
}