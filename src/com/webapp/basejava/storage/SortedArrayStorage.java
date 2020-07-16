package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insert(Resume resume, int index) {
        int j = -index - 1;
        System.arraycopy(storage, j, storage, j + 1, sizeStorage - j);
        storage[j] = resume;
    }

    @Override
    protected void remove(int indexUuid) {
        System.arraycopy(storage, indexUuid + 1, storage, indexUuid, sizeStorage - indexUuid - 1);
    }

    @Override
    protected int getResumeIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, sizeStorage, searchKey);
    }
}
