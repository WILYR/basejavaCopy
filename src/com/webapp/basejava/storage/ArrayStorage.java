package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insert(Resume resume) {
        storage[sizeStorage] = resume;
    }

    @Override
    protected void remove(int indexUuid) {
        System.out.println("Resume " + storage[indexUuid] + " delete");
        System.arraycopy(storage, indexUuid + 1, storage, indexUuid, sizeStorage - indexUuid - 1);
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
