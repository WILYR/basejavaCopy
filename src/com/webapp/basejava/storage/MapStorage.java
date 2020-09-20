package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> treeMap = new TreeMap<>();

    @Override
    protected void doClear() {
        treeMap.clear();
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        treeMap.put((String) key, resume);
    }

    @Override
    protected Object getKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume doGet(Object key) {
        return treeMap.get(key);
    }

    @Override
    protected void doDelete(Object key) {
        treeMap.remove(key);
    }

    @Override
    protected void doUpdate(Resume resume, Object key) {
        treeMap.put((String) key, resume);
    }

    @Override
    protected boolean isExist(Object key) {
        return treeMap.containsKey(key);
    }

    @Override
    public List<Resume> doGetAllSorted() {
        return new ArrayList<>(treeMap.values());
    }

    @Override
    public int size() {
        return treeMap.size();
    }
}
