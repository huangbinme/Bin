package com;

import java.util.*;

public class CloudStorageImpl implements CloudStorage {

    Map<String, InputFile> fileMap;

    Map<String, User> users;

    Map<String, Map<String, InputFile>> backups;

    public CloudStorageImpl() {
        fileMap = new HashMap<>();
        users = new HashMap<>();
        users.put("admin", new User("admin", -1));//Bug
        backups = new HashMap<>();
    }

    @Override
    public boolean addFile(String name, int size) {
        if (fileMap.containsKey(name)) {
            return false;
        }
        fileMap.put(name, new InputFile(name, size, "admin"));
        return true;
    }

    @Override
    public Optional<Integer> getFileSize(String name) {
        InputFile inputFile = fileMap.get(name);
        return inputFile == null ? Optional.empty() : Optional.of(inputFile.size);
    }

    @Override
    public Optional<Integer> deleteFile(String name) {
        InputFile entry = fileMap.remove(name);
        if (entry == null) return Optional.empty();
        User owner = users.get(entry.owner);
        if (owner != null) {
            owner.used -= entry.size;
        }
        return Optional.of(entry.size);
    }

    @Override
    public List<String> getNLargest(String prefix, int n) {
        List<InputFile> ans = new ArrayList<>();
        for (Map.Entry<String, InputFile> entry : fileMap.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                ans.add(new InputFile(entry.getKey(), entry.getValue().size, entry.getValue().owner));
            }
        }
        ans.sort((a, b) -> b.size != a.size ? b.size - a.size : a.name.compareTo(b.name));
        List<String> res = new ArrayList<>();
        for (int i = 0; i < Math.min(ans.size(), n); i++) {
            res.add(ans.get(i).name + "(" + ans.get(i).size + ")");
        }
        return res;
    }

    @Override
    public boolean addUser(String userId, int capacity) {
        if (users.containsKey(userId)) return false;
        users.put(userId, new User(userId, capacity));
        return true;
    }

    @Override
    public Optional<Integer> addFileBy(String userId, String name, int size) {
        if (fileMap.containsKey(name) || !users.containsKey(userId)) return Optional.empty();
        User user = users.get(userId);
        if (!userId.equals("admin") && user.used + size > user.capacity) return Optional.empty();
        fileMap.put(name, new InputFile(name, size, userId));
        user.used += size;
        return Optional.of(userId.equals("admin") ? -1 : user.capacity - user.used);
    }

    @Override
    public Optional<Integer> mergeUser(String userId1, String userId2) {
        if (!users.containsKey(userId1) || !users.containsKey(userId2) || userId1.equals(userId2))
            return Optional.empty();
        User u1 = users.get(userId1);
        User u2 = users.get(userId2);
        for (InputFile f : fileMap.values()) {
            if (f.owner.equals(userId2)) {
                f.owner = userId1;
                u1.used += f.size;
            }
        }
        u1.capacity += u2.capacity;
        users.remove(userId2);
        return Optional.of(u1.capacity - u1.used);
    }

    @Override
    public Optional<Integer> backupUser(String userId) {
        if (!users.containsKey(userId)) return Optional.empty();
        Map<String, InputFile> backup = new HashMap<>();
        for (Map.Entry<String, InputFile> entry : fileMap.entrySet()) {
            if (entry.getValue().owner.equals(userId)) {
                InputFile inputFile = entry.getValue();
                backup.put(entry.getKey(), new InputFile(inputFile.name, inputFile.size, inputFile.owner));
            }
        }
        backups.put(userId, backup);
        return Optional.of(backup.size());
    }

    @Override
    public Optional<Integer> restoreUser(String userId) {
        if (!users.containsKey(userId)) return Optional.empty();
        int restored = 0;
        Iterator<Map.Entry<String, InputFile>> iterator = fileMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, InputFile> entry = iterator.next();
            if (entry.getValue().owner.equals(userId)) {
                iterator.remove();
            }
        }
        User user = users.get(userId);
        user.used = 0;
        Map<String, InputFile> snapshot = backups.get(userId);
        if (snapshot != null) {
            for (InputFile f : snapshot.values()) {
                if (!fileMap.containsKey(f.name)) {
                    fileMap.put(f.name, new InputFile(f.name, f.size, f.owner));
                    user.used += f.size;
                    restored++;
                }
            }
        }
        if (user.name.equals("admin")) user.used = -1;
        return Optional.of(restored);
    }

    public static class InputFile {
        String name;
        int size;
        String owner;

        InputFile(String name, int size, String owner) {
            this.name = name;
            this.size = size;
            this.owner = owner;
        }
    }

    static class User {
        String name;
        int capacity;
        int used;

        User(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
            this.used = 0;
        }
    }
}
