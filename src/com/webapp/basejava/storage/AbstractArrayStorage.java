package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int sizeStorage = 0;

    public int size() {
        System.out.print("Size: ");
        return sizeStorage;
    }

    public Resume get(String uuid) {
        Resume resume = null;
        int indexUuid = getResumeIndex(uuid);
        if (indexUuid != -1) {
            resume = storage[indexUuid];
        }
        System.out.print("\nGet " + resume + ": ");
        return resume;
    }

    protected abstract int getResumeIndex(String uuid);

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
            System.out.println("\nResume base is overdraw");
        } else if (getResumeIndex(r.getUuid()) == -1) {
            insert(r, -1);
            System.out.println("Resume " + r + " save");
            sizeStorage++;
        } else {
            System.out.println("Error! " + r + " couldn't save");
        }
    }

    protected abstract void insert(Resume resume, int index);

    public void delete(String uuid) {
        int indexUuid = getResumeIndex(uuid);
        if (indexUuid != -1) {
            System.out.println("Resume " + storage[indexUuid] + " delete");
            remove(indexUuid);
        } else {
            System.out.println("Error! " + uuid + " couldn't delete");
        }
    }

    protected abstract void remove(int indexUuid);

    public void update(Resume resume) {
        int index = getResumeIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
            System.out.println("Resume " + (index + 1) + " successfully update with " + storage[index]);
        } else {
            System.out.println("Error! " + resume + " couldn't update");
        }
    }
}
