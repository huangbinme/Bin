package com.leetcode;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer integer;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        if (iterator.hasNext()) {
            integer = iterator.next();
        }
        this.iterator = iterator;
    }

    public Integer peek() {
        return integer;
    }

    @Override
    public Integer next() {
        int nextV = integer.intValue();
        if (iterator.hasNext()) {
            integer = iterator.next();
        } else {
            integer = null;
        }
        return nextV;
    }

    @Override
    public boolean hasNext() {
        return integer != null;
    }
}
