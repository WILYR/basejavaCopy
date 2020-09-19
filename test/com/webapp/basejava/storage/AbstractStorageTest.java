package com.webapp.basejava.storage;

import com.webapp.basejava.exeption.ExistStorageException;
import com.webapp.basejava.exeption.NotExistStorageException;
import com.webapp.basejava.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractStorageTest {

    protected Storage storage;

    private static final Resume r1 = new Resume("uuid1", "Name1");
    private static final Resume r2 = new Resume("uuid2", "Name2");
    private static final Resume r3 = new Resume("uuid3", "Name3");

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(r1);
        storage.save(r2);
        storage.save(r3);
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(r1, storage.get(r1.getUuid()));
        Assert.assertEquals(r2, storage.get(r2.getUuid()));
        Assert.assertEquals(r3, storage.get(r3.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void getAll() throws Exception {
        List<Resume> expectedResumes = storage.getAllSorted();
        Assert.assertEquals(3, expectedResumes.size());
        Assert.assertEquals(expectedResumes, Arrays.asList(r1, r2, r3));
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        int sizeUntilDelete = storage.size();
        storage.delete("uuid2");
        Assert.assertEquals(sizeUntilDelete - 1, storage.size());
        storage.get("uuid2");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void update() throws Exception {
        Resume r4 = new Resume("uuid4");
        storage.save(r4);
        storage.update(r4 = r1);
        Assert.assertTrue(r4 == storage.get("uuid1"));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(new Resume("uuid5"));
    }

    @Test
    public void save() throws Exception {
        Resume r4 = new Resume("uuid4");
        storage.save(r4);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(r4, storage.get(r4.getUuid()));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(r1);
    }

}