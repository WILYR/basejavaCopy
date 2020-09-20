package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.*;

public class MapStorageAnother extends AbstractStorage {
    private Map<String, Resume> treeMap = new TreeMap<>();

    @Override
    protected void doClear() {
        treeMap.clear();
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        treeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected Object getKey(String uuid) {
        return treeMap.get(uuid);
    }

    @Override
    protected Resume doGet(Object key) {
        return (Resume) key;
    }

    @Override
    protected void doDelete(Object key) {
        treeMap.remove(((Resume) key).getUuid());
    }

    @Override
    protected void doUpdate(Resume resume, Object key) {
        treeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
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
