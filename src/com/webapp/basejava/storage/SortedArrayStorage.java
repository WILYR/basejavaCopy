package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insert(Resume resume) {
        int j = Arrays.binarySearch(storage, 0, sizeStorage, resume);
        if (j < 0) {
            j = -j - 1;
        }
        System.arraycopy(storage, j, storage, j + 1, sizeStorage - j);
        storage[j] = resume;
    }

    @Override
    protected void remove(int indexUuid) {
        System.out.println("Resume " + storage[indexUuid] + " delete");
        System.arraycopy(storage, indexUuid + 1, storage, indexUuid, sizeStorage - indexUuid - 1);
    }

    @Override
    protected int getResumeIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, sizeStorage, searchKey);
    }
}
