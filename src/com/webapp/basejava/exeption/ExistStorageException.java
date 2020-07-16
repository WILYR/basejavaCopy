package com.webapp.basejava.exeption;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}
