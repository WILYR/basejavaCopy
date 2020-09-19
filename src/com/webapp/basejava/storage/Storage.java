package com.webapp.basejava.storage;

import com.webapp.basejava.model.Resume;

import java.util.List;

public interface Storage {

    void clear();

    void save(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    List<Resume> getAllSorted();

    int size();

    void update(Resume resume);

}
