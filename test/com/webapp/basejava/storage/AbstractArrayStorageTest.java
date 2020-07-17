package com.webapp.basejava.storage;

import com.webapp.basejava.exeption.NotExistStorageException;
import com.webapp.basejava.exeption.StorageException;
import com.webapp.basejava.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {

    private Storage storage;

    private static final Resume r1 = new Resume("uuid1");
    private static final Resume r2 = new Resume("uuid2");
    private static final Resume r3 = new Resume("uuid3");

    public AbstractArrayStorageTest(Storage storage) {
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
        getTest(r1);
        getTest(r2);
        getTest(r3);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void getAll() throws Exception {
        Resume[] expectedResumes = storage.getAll();
        Assert.assertEquals(3, expectedResumes.length);
        Assert.assertEquals(r1, expectedResumes[0]);
        Assert.assertEquals(r2, expectedResumes[1]);
        Assert.assertEquals(r3, expectedResumes[2]);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void save() throws Exception {
        Resume r4 = new Resume("uuid4");
        storage.save(r4);
        Assert.assertEquals(4, storage.size());
        getTest(r4);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void delete() throws Exception {
        int sizeUntilDelete = storage.size();
        storage.delete("uuid2");
        storage.get("uuid2");
        Assert.assertFalse(sizeUntilDelete - 1 == storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void update() throws Exception {
        Resume r4 = new Resume("uuid4");
        storage.save(r4);
        r4 = r1;
        storage.update(r4);
        storage.get("uuid4");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void updateNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void storageException() throws Exception {
        storage.clear();
        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
            storage.save(new Resume());
            Assert.fail();
        } catch (StorageException e) {
            throw new StorageException("Storage overdraw", r1.getUuid());
        }
    }

    public void getTest(Resume r) {
        Assert.assertNotNull(storage.get(r.getUuid()));
        Assert.assertEquals(r, storage.get(r.getUuid()));
    }
}