package com;

import java.util.*;

public class InMemoryDB {
    static class Value {
        String val;
        Long expireAt; // null means no expiration

        Value(String val, Long expireAt) {
            this.val = val;
            this.expireAt = expireAt;
        }

        boolean isExpired(long timestamp) {
            return expireAt != null && timestamp >= expireAt;
        }
    }

    // DB: key -> field -> value
    Map<String, Map<String, Value>> db = new HashMap<>();
    Map<Long, Map<String, Map<String, Value>>> backups = new TreeMap<>();

    public void setAt(String key, String field, String value, long timestamp) {
        db.putIfAbsent(key, new HashMap<>());
        db.get(key).put(field, new Value(value, null));
    }

    public void setAtWithTTL(String key, String field, String value, long timestamp, long ttl) {
        db.putIfAbsent(key, new HashMap<>());
        db.get(key).put(field, new Value(value, timestamp + ttl));
    }

    public String getAt(String key, String field, long timestamp) {
        if (!db.containsKey(key)) return "";
        Value v = db.get(key).get(field);
        if (v == null || v.isExpired(timestamp)) return "";
        return v.val;
    }

    public String deleteAt(String key, String field, long timestamp) {
        if (!db.containsKey(key)) return "false";
        Value v = db.get(key).get(field);
        if (v == null || v.isExpired(timestamp)) return "false";
        db.get(key).remove(field);
        if (db.get(key).isEmpty()) db.remove(key);
        return "true";
    }

    public String scanAt(String key, long timestamp) {
        if (!db.containsKey(key)) return "";
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Value> entry : db.get(key).entrySet()) {
            if (!entry.getValue().isExpired(timestamp)) {
                res.add(entry.getKey() + "(" + entry.getValue().val + ")");
            }
        }
        Collections.sort(res);
        return String.join(", ", res);
    }

    public String scanByPrefixAt(String key, String prefix, long timestamp) {
        if (!db.containsKey(key)) return "";
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Value> entry : db.get(key).entrySet()) {
            if (entry.getKey().startsWith(prefix) && !entry.getValue().isExpired(timestamp)) {
                res.add(entry.getKey() + "(" + entry.getValue().val + ")");
            }
        }
        Collections.sort(res);
        return String.join(", ", res);
    }

    public int backup(long timestamp) {
        Map<String, Map<String, Value>> snapshot = new HashMap<>();
        for (Map.Entry<String, Map<String, Value>> e : db.entrySet()) {
            Map<String, Value> fields = new HashMap<>();
            for (Map.Entry<String, Value> f : e.getValue().entrySet()) {
                Value v = f.getValue();
                if (!v.isExpired(timestamp)) {
                    fields.put(f.getKey(), new Value(v.val, v.expireAt));
                }
            }
            if (!fields.isEmpty()) snapshot.put(e.getKey(), fields);
        }
        backups.put(timestamp, snapshot);
        return snapshot.size();
    }

    public void restore(long nowTimestamp, long timestampToRestore) {
        Map.Entry<Long, Map<String, Map<String, Value>>> entry = ((TreeMap<Long, Map<String, Map<String, Value>>>) backups).floorEntry(timestampToRestore);
        if (entry == null) return;

        Map<String, Map<String, Value>> restored = new HashMap<>();
        for (Map.Entry<String, Map<String, Value>> e : entry.getValue().entrySet()) {
            Map<String, Value> fields = new HashMap<>();
            for (Map.Entry<String, Value> f : e.getValue().entrySet()) {
                Value v = f.getValue();
                Long newExpire = v.expireAt == null ? null : nowTimestamp + (v.expireAt - entry.getKey());
                fields.put(f.getKey(), new Value(v.val, newExpire));
            }
            restored.put(e.getKey(), fields);
        }
        db = restored;
    }
}

