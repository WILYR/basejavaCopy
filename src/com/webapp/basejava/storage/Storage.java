package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

public interface Storage {

    void clear();

    void save(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    int size();

    void update(Resume resume);

}
