package com.review;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    Integer cur;

    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            cur = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cur;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer returnV = cur;
        cur = iterator.hasNext() ? iterator.next() : null;
        return returnV;
    }

    @Override
    public boolean hasNext() {
        return cur != null;
    }
}
