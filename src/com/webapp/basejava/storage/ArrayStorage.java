package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    public void clear() {
        Arrays.fill(storage,0, sizeStorage, null);
        sizeStorage = 0;
    }

    public void save(Resume r) {
        if(sizeStorage == storage.length - 1) {
            System.out.println("\nResume base is overdraw");
        } else {
            boolean isResumeInBase = false;
            for (int i = 0; i < sizeStorage; i++) {
                if (storage[i] == r) {
                    System.out.println("\nResume already save in storage");
                    isResumeInBase = true;
                    break;
                }
            }
            if(!isResumeInBase) {
                storage[sizeStorage] = r;
                sizeStorage++;
            }
        }
    }

    public Resume get(String uuid) {
        Resume resume = null;
        if(sizeStorage == 0) {
            System.out.println("\nStorage without resume");
        } else {
            for (int i = 0; i < sizeStorage; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    resume = storage[i];
                }
            }
        }
        return resume;
    }

    public void delete(String uuid) {
        if(sizeStorage == 0) {
            System.out.println("\nStorage without resume");
        } else {
            int count = 0;
            for (int i = 0; i < sizeStorage; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    storage[i] = null;
                    count = i;
                }
            }
            int i = count;
            while (i < sizeStorage - 1) {
                storage[i] = storage[i + 1];
                i++;
            }
            sizeStorage--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, sizeStorage);
    }

    public int size() {
        return sizeStorage;
    }

    public void update(Resume resume, String updateUuid) {
        if(sizeStorage == 0) {
            System.out.println("\nStorage without resume");
        } else {
            resume.setUuid(updateUuid);
        }
    }
}
