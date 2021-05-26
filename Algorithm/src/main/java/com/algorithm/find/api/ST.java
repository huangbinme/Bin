package com.algorithm.find.api;

public interface ST<Key extends Comparable,Value> {
    void put(Key k,Value v);
    Value get(Key k);
    void delete(Key k);
    boolean contains(Key k);
    boolean isEmpty();
    int size();
    Key min();
    Key max();
    void deleteMin();
    void deleteMax();
    Iterable<Key> keys();
}
