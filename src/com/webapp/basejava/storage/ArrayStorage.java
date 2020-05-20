package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    public void clear() {
        Arrays.fill(storage, 0, sizeStorage, null);
        sizeStorage = 0;
    }

    public void save(Resume r) {
        if (sizeStorage == storage.length) {
            System.out.println("\nResume base is overdraw");
        } else {
            if (isResumeInStorage(r) == -1) {
                storage[sizeStorage] = r;
                sizeStorage++;
            }
        }
    }

    public int isResumeInStorage(Resume resume) {
        int link = -1;
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i] == resume) {
                link = i;
                break;
            }
        }
        return link;
    }

    public Resume get(String uuid) {
        Resume resume = null;
        if (checkStorageSize()) {
            int indexUuid = isResumeUUidInBase(uuid);
            if(indexUuid != -1) {
                resume = storage[indexUuid];
            }
        }
        return resume;
    }

    public int isResumeUUidInBase(String uuid) {
        int indexUUid = -1;
        for (int i = 0; i < sizeStorage; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                 indexUUid = i;
            }
        }
        return indexUUid;
    }

    public boolean checkStorageSize() {
        if (sizeStorage == 0) {
            System.out.println("\nStorage without resume");
            return false;
        } else {
            return true;
        }
    }

    public void delete(String uuid) {
        if (checkStorageSize()) {
            int indexUuid = isResumeUUidInBase(uuid);
            if(indexUuid != -1) {
                storage[indexUuid] = null;
            }
            while (indexUuid < sizeStorage - 1) {
                storage[indexUuid] = storage[indexUuid + 1];
                indexUuid++;
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

    public void update(Resume resume) {
        if (checkStorageSize()) {
            int resumeIndex = isResumeInStorage(resume);
            if(resumeIndex != -1) {
                storage[resumeIndex] = resume;
            }
        }
    }
}
