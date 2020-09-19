package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> storage = new ArrayList<>();

    protected Object getKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected Resume doGet(Object key) {
        return storage.get((Integer) key);
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        storage.add(resume);
    }

    @Override
    protected void doClear() {
        storage.clear();
    }

    @Override
    protected void doDelete(Object key) {
        storage.remove(((Integer) key).intValue());
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    public List<Resume> doGetAllSorted() {
        return storage;
    }

    public int size() {
        return storage.size();
    }

    protected void doUpdate(Resume resume, Object key) {
        storage.set((Integer) key, resume);
    }

}
