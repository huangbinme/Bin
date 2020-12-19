package com.algorithm.find.api;

public interface ST<Key extends  Comparable,Value> {
    void put(Key k,Value v);
    Value get(Key k);
    void delete(Key k);
    boolean contains(Key k);
}
