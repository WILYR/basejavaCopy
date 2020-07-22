package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void getColl();

    protected abstract void saveColl();

    protected abstract void clearColl();

    protected abstract void deleteColl();

    protected abstract void getAllColl();

    protected abstract void SizeColl();

    protected abstract void updateColl();

    @Override
    public void clear() {

    }

    @Override
    public void save(Resume r) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void update(Resume resume) {

    }
}
