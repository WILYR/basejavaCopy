package com.webapp.basejava.storage;

import com.webapp.basejava.exeption.ExistStorageException;
import com.webapp.basejava.exeption.NotExistStorageException;
import com.webapp.basejava.exeption.StorageException;
import com.webapp.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int sizeStorage = 0;

    protected abstract void remove(int indexUuid);

    protected abstract void insert(Resume resume, int index);

    protected abstract Object getKey(String uuid);

    public int size() {
        System.out.print("Size: ");
        return sizeStorage;
    }

    @Override
    public Resume getImplementation(Object key) {
        if ((Integer) key < 0) {
            throw new NotExistStorageException(storage[(Integer) key].getUuid());
        }
        System.out.print("\nGet " + storage[(Integer) key] + ": ");
        return storage[(Integer) key];
    }

    public Resume[] getAll() {
        System.out.println("\nGet All");
        return Arrays.copyOf(storage, sizeStorage);
    }

    @Override
    public void clearImplementation() {
        Arrays.fill(storage, 0, sizeStorage, null);
        sizeStorage = 0;
    }

    @Override
    public void saveImplementation(Resume r, Object key) {
        if (sizeStorage == STORAGE_LIMIT) {
            throw new StorageException("Storage overdraw", r.getUuid());
        } else if ((Integer) getKey(r.getUuid()) > 0) {
            throw new ExistStorageException(r.getUuid());
        }
        insert(r, (Integer) key);
        System.out.println("Resume " + r + " save");
        sizeStorage++;
    }

    @Override
    public void deleteImplementation(Object key) {
        if ((Integer) key < 0) {
            throw new NotExistStorageException(storage[(Integer) key].getUuid());
        }
        System.out.println("Resume " + storage[(Integer) key] + " delete");
        remove((Integer) key);
        sizeStorage--;
    }

    @Override
    public void updateImplementation(Resume r, Object key) {
        if ((Integer) key < 0) {
            throw new NotExistStorageException(r.getUuid());
        }
        storage[(Integer) key] = r;
        System.out.println("Resume " + ((Integer) key + 1) + " successfully update with " + storage[(Integer) key]);
    }
}
