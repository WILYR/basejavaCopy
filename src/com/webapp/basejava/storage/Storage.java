package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

public interface Storage {

    public void clear();

    public void save(Resume r);

    public Resume get(String uuid);

    public void delete(String uuid);

    public Resume[] getAll();

    public int size();

    public void update(Resume resume);

}
