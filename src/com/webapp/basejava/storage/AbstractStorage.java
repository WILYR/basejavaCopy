package com.webapp.basejava.storage;

import com.webapp.basejava.exeption.ExistStorageException;
import com.webapp.basejava.exeption.NotExistStorageException;
import com.webapp.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract void doClear();

    protected abstract void doSave(Resume resume, Object key);

    protected abstract Object getKey(String uuid);

    protected abstract Resume doGet(Object key);

    protected abstract void doDelete(Object key);

    protected abstract void doUpdate(Resume resume, Object key);

    protected abstract boolean isExist(Object key);

    public void clear() {
        doClear();
        System.out.println("\nStorage was cleared");
    }

    public void save(Resume resume) {
        Object key = getKeyIfResumeNotExist(resume.getUuid());
        doSave(resume, key);
    }

    public Resume get(String uuid) {
        Object key = getKeyIfResumeExist(uuid);
        return doGet(key);
    }

    public void delete(String uuid) {
        Object key = getKeyIfResumeExist(uuid);
        doDelete(key);
    }

    public void update(Resume resume) {
        Object key = getKeyIfResumeExist(resume.getUuid());
        doUpdate(resume, key);
    }

    private Object getKeyIfResumeNotExist(String uuid) {
        Object key = getKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    private Object getKeyIfResumeExist(String uuid) {
        Object key = getKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }
}
