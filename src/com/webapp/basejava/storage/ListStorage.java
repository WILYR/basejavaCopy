package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> storage = new ArrayList<>();
    private final Resume Resume_1 = new Resume("uuid1");

    @Override
    protected void getColl() {
        storage.get(storage.indexOf(Resume_1));
    }

    @Override
    protected void saveColl() {
        storage.add(Resume_1);
    }

    @Override
    protected void clearColl() {
        storage.clear();
    }

    @Override
    protected void deleteColl() {
        storage.remove(Resume_1);
    }

    @Override
    protected void getAllColl() {
        String[] allStorage = storage.toArray(new String[0]);
    }

    @Override
    protected void SizeColl() {
        storage.size();
    }

    @Override
    protected void updateColl() {
        storage.set(storage.indexOf(Resume_1), Resume_1);
    }
}
