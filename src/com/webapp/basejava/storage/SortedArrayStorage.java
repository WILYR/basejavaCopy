package com.webapp.basejava.storage;

import com.sun.javafx.scene.control.TableColumnComparatorBase;
import com.webapp.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertByn(Resume value) {
        int j = Arrays.binarySearch(storage, 0, sizeStorage, value);
        if (j < 0) {
            j = -j - 1;
        }
        System.arraycopy(storage, j, storage, j + 1, sizeStorage - j);
        storage[j] = value;
        sizeStorage++;
    }

    @Override
    protected int getUuidIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, sizeStorage, searchKey);
    }
}
