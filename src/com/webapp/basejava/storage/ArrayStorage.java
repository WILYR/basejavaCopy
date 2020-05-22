package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    public void clear() {
        Arrays.fill(storage, 0, sizeStorage, null);
        sizeStorage = 0;
        System.out.println("\nStorage was cleared");
    }

    public void save(Resume r) {
        if (sizeStorage == storage.length) {
            System.out.println("\nResume base is overdraw");
        } else if (getUuidIndex(r.getUuid()) == -1) {
            storage[sizeStorage] = r;
            System.out.println("Resume " + r + " save");
            sizeStorage++;
        }
    }

    public Resume get(String uuid) {
        Resume resume = null;
        int indexUuid = getUuidIndex(uuid);
        if (indexUuid != -1) {
            resume = storage[indexUuid];
        }
        System.out.print("\nGet " + resume + ": ");
        return resume;
    }

    private int getUuidIndex(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String uuid) {
        int indexUuid = getUuidIndex(uuid);
        if (indexUuid != -1) {
            System.out.println("Resume " + storage[indexUuid] + " delete");
            System.arraycopy(storage, indexUuid + 1, storage, indexUuid, sizeStorage - indexUuid - 1);
            sizeStorage--;
        } else {
            System.out.println("Delete Error!");
        }
    }

    public Resume[] getAll() {
        System.out.println("\nGet All");
        return Arrays.copyOf(storage, sizeStorage);
    }

    public int size() {
        System.out.print("Size: ");
        return sizeStorage;
    }

    public void update(Resume resume) {
        int index = getUuidIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
            System.out.println("Resume " + (index + 1) + " successfully update with " + storage[index]);
        } else {
            System.out.println("Update Error!");
        }
    }
}
