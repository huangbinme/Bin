package com.review;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import java.util.Comparator;

public class Allocator {
    private final TreeSet<Interval> free;
    private final Map<Integer, Integer> used;
    public Allocator(int N) {
        this.free = new TreeSet<>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.l != b.l) return a.l - b.l;
                return a.r - b.r;
            }
        });
        this.used = new HashMap<>();
        this.free.add(new Interval(0, N - 1));
    }

    public int alloc(int size) {
        Interval best = null;
        int bestRem = Integer.MAX_VALUE;
        for (Interval iv : free) {
            int len = iv.r - iv.l + 1;
            if (len >= size) {
                int rem = len - size;
                if (rem < bestRem) {
                    bestRem = rem;
                    best = iv;
                } else if (rem == bestRem) {
                    if (iv.l > best.l) {
                        best = iv;
                    }
                }
            }
        }
        if (best == null) return -1;

        free.remove(best);
        int addr;

        if (size == 1) {
            addr = best.l;
            if (best.l + 1 <= best.r) {
                free.add(new Interval(best.l + 1, best.r));
            }
        } else {
            int startMax = best.r - size + 1;
            int aligned = startMax - (startMax % size);
            if (aligned < best.l) {
                aligned = best.l;
            }
            addr = aligned;

            if (best.l <= addr - 1) {
                free.add(new Interval(best.l, addr - 1));
            }
            int end = addr + size - 1;
            if (end < best.r) {
                free.add(new Interval(end + 1, best.r));
            }
        }

        used.put(addr, size);
        return addr;
    }

    public void free(int address) {
        Integer size = used.remove(address);
        if (size == null) return;

        int l = address;
        int r = address + size - 1;
        Interval cur = new Interval(l, r);

        Interval lower = free.floor(cur);
        if (lower != null && lower.r + 1 == cur.l) {
            cur.l = lower.l;
            cur.r = Math.max(cur.r, lower.r);
            free.remove(lower);
        }

        Interval higher = free.ceiling(cur);
        while (higher != null && higher.l == cur.r + 1) {
            cur.r = Math.max(cur.r, higher.r);
            free.remove(higher);
            higher = free.ceiling(cur);
        }

        free.add(cur);
    }

    private static class Interval {
        int l;
        int r;

        Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}