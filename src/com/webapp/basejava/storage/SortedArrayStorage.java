package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insert(Resume resume, int index) {
        int insertIndex = -index - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, sizeStorage - insertIndex);
        storage[insertIndex] = resume;
    }

    @Override
    protected void remove(int index) {
        System.arraycopy(storage, index + 1, storage, index, sizeStorage - index - 1);
    }

    private Comparator<Resume> ResumeComparator = Comparator.comparing(Resume::getUuid);

    @Override
    protected Object getKey(String uuid) {
        Resume searchKey = new Resume(uuid, "Name");
        return Arrays.binarySearch(storage, 0, sizeStorage, searchKey, ResumeComparator);
    }

}
