package com.webapp.basejava.storage;

import com.webapp.basejava.exeption.ExistStorageException;
import com.webapp.basejava.exeption.NotExistStorageException;
import com.webapp.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract void clearRealization();

    protected abstract void saveRealization(Resume resume, Object key);

    protected abstract Object getKey(String uuid);

    protected abstract Resume getRealization(Object key);

    protected abstract void deleteRealization(Object key);

    protected abstract void updateRealization(Resume resume, Object key);

    protected abstract boolean isExist(Object key);

    public void clear() {
        clearRealization();
        System.out.println("\nStorage was cleared");
    }

    public void save(Resume resume) {
        Object key = getKey(resume.getUuid());
        saveRealization(resume, key);
    }

    public Resume get(String uuid) {
        Object key = getKey(uuid);
        return getRealization(key);
    }

    public void delete(String uuid) {
        Object key = getKey(uuid);
        deleteRealization(key);
    }

    public void update(Resume resume) {
        Object key = getKey(resume.getUuid());
        updateRealization(resume, key);
    }

    public Object notExistKey(String uuid) {
        Object key = getKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    public Object ExistKey(String uuid) {
        Object key = getKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }
}
