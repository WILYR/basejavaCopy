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

    protected abstract int getResumeIndex(String uuid);

    public int size() {
        System.out.print("Size: ");
        return sizeStorage;
    }

    public Resume get(String uuid) {
        int index = getResumeIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        System.out.print("\nGet " + storage[index] + ": ");
        return storage[index];
    }

    public Resume[] getAll() {
        System.out.println("\nGet All");
        return Arrays.copyOf(storage, sizeStorage);
    }

    public void clear() {
        Arrays.fill(storage, 0, sizeStorage, null);
        sizeStorage = 0;
        System.out.println("\nStorage was cleared");
    }

    public void save(Resume r) {
        if (sizeStorage == STORAGE_LIMIT) {
            throw new StorageException("Storage overdraw", r.getUuid());
        } else if (getResumeIndex(r.getUuid()) > 0) {
            throw new ExistStorageException(r.getUuid());
        }
        insert(r, getResumeIndex(r.getUuid()));
        System.out.println("Resume " + r + " save");
        sizeStorage++;
    }

    public void delete(String uuid) {
        int index = getResumeIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        System.out.println("Resume " + storage[index] + " delete");
        remove(index);
        sizeStorage--;
    }

    public void update(Resume resume) {
        int index = getResumeIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        storage[index] = resume;
        System.out.println("Resume " + (index + 1) + " successfully update with " + storage[index]);
    }
}
