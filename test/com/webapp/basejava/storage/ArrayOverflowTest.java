package com.webapp.basejava.storage;

import com.webapp.basejava.exeption.StorageException;
import com.webapp.basejava.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class ArrayOverflowTest extends AbstractArrayStorageTest {

    protected ArrayOverflowTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        storage.clear();
        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail("Resume base error");
        }
        storage.save(new Resume());
    }
}
