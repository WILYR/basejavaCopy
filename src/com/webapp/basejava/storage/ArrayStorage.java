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
        sizeStorage--;
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
}
