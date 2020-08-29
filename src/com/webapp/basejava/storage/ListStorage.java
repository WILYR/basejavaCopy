package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> storage = new ArrayList<>();
    //private final Resume Resume_1 = new Resume("uuid1");

    protected Object getKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected Resume getRealization(Object key) {
        return storage.get((Integer) key);
    }

    @Override
    protected void saveRealization(Resume resume, Object key) {
        storage.add(resume);
    }

    @Override
    protected void clearRealization() {
        storage.clear();
    }

    @Override
    protected void deleteRealization(Object key) {
        storage.remove(key);
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    public Resume[] getAll() {
        Resume[] allStorage = storage.toArray(new Resume[storage.size()]);
        return allStorage;
    }

    public int size() {
        return storage.size();
    }

    protected void updateRealization(Resume resume, Object key) {
        storage.set((Integer) key, resume);
    }

}
