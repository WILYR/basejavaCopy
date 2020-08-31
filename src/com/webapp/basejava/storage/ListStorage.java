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
    protected Resume getSet(Object key) {
        return storage.get((Integer) key);
    }

    @Override
    protected void saveSet(Resume resume, Object key) {
        storage.add(resume);
    }

    @Override
    protected void clearSet() {
        storage.clear();
    }

    @Override
    protected void deleteSet(Object key) {
        storage.remove(key);
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    public int size() {
        return storage.size();
    }

    protected void updateSet(Resume resume, Object key) {
        storage.set((Integer) key, resume);
    }

}
