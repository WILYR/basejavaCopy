package com.webapp.basejava.storage;

import com.webapp.basejava.exeption.ExistStorageException;
import com.webapp.basejava.exeption.NotExistStorageException;
import com.webapp.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract void clearSet();

    protected abstract void saveSet(Resume resume, Object key);

    protected abstract Object getKey(String uuid);

    protected abstract Resume getSet(Object key);

    protected abstract void deleteSet(Object key);

    protected abstract void updateSet(Resume resume, Object key);

    protected abstract boolean isExist(Object key);

    public void clear() {
        clearSet();
        System.out.println("\nStorage was cleared");
    }

    public void save(Resume resume) {
        Object key = notExistKey(resume.getUuid());
        saveSet(resume, key);
    }

    public Resume get(String uuid) {
        Object key = ExistKey(uuid);
        return getSet(key);
    }

    public void delete(String uuid) {
        Object key = ExistKey(uuid);
        deleteSet(key);
    }

    public void update(Resume resume) {
        Object key = ExistKey(resume.getUuid());
        updateSet(resume, key);
    }

    private Object notExistKey(String uuid) {
        Object key = getKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    private Object ExistKey(String uuid) {
        Object key = getKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }
}
