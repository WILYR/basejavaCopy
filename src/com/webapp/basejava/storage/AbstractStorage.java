package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract void clearImplementation();

    protected abstract void saveImplementation(Resume r, Object key);

    protected abstract Object getKey(String uuid);

    protected abstract Resume getImplementation(Object key);

    protected abstract void deleteImplementation(Object key);

    protected abstract void updateImplementation(Resume r, Object key);

    public void clear() {
        clearImplementation();
        System.out.println("\nStorage was cleared");
    }

    public void save(Resume r) {
        Object key = getKey(r.getUuid());
        saveImplementation(r, key);
    }

    public Resume get(String uuid) {
        Object key = getKey(uuid);
        return getImplementation(key);
    }

    public void delete(String uuid) {
        Object key = getKey(uuid);
        deleteImplementation(key);
    }

    public void update(Resume resume) {
        Object key = getKey(resume.getUuid());
        updateImplementation(resume, key);
    }

}
