package com.webapp.basejava.storage;

import com.webapp.basejava.exeption.StorageException;
import com.webapp.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int sizeStorage = 0;

    protected abstract void remove(int index);

    protected abstract void insert(Resume resume, int index);

    protected abstract Object getKey(String uuid);

    public int size() {
        return sizeStorage;
    }

    @Override
    public Resume doGet(Object key) {
        System.out.print("\nGet " + storage[(Integer) key] + ": ");
        return storage[(Integer) key];
    }

    public List<Resume> doGetAllSorted() {
        System.out.println("\nGet All");
        List<Resume> list = Arrays.asList(Arrays.copyOfRange(storage, 0, sizeStorage));
        return list;
    }

    @Override
    public void doClear() {
        Arrays.fill(storage, 0, sizeStorage, null);
        sizeStorage = 0;
    }

    @Override
    public void doSave(Resume resume, Object key) {
        if (sizeStorage == STORAGE_LIMIT) {
            throw new StorageException("Storage overdraw", resume.getUuid());
        } else {
            insert(resume, (Integer) key);
            System.out.println("Resume " + resume + " save");
            sizeStorage++;
        }
    }

    @Override
    public void doDelete(Object key) {
        System.out.println("Resume " + storage[(Integer) key] + " delete");
        remove((Integer) key);
        storage[sizeStorage - 1] = null;
        sizeStorage--;
    }

    @Override
    public void doUpdate(Resume resume, Object key) {
        storage[(Integer) key] = resume;
        System.out.println("Resume " + ((Integer) key + 1) + " successfully update with " + storage[(Integer) key]);
    }

    @Override
    protected boolean isExist(Object key) {
        return (Integer) key >= 0;
    }
}
