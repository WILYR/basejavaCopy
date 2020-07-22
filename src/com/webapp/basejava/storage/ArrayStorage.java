package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insert(Resume resume, int index) {
        storage[sizeStorage] = resume;
    }

    @Override
    protected void remove(int index) {
        storage[index] = storage[sizeStorage - 1];
    }

    @Override
    protected int getResumeIndex(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void getColl() {

    }

    @Override
    protected void saveColl() {

    }

    @Override
    protected void clearColl() {

    }

    @Override
    protected void deleteColl() {

    }

    @Override
    protected void getAllColl() {

    }

    @Override
    protected void SizeColl() {

    }

    @Override
    protected void updateColl() {

    }
}
