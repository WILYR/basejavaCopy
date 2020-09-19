package com.webapp.basejava;

import com.webapp.basejava.model.Resume;
import com.webapp.basejava.storage.ArrayStorage;


public class MainTestArrayStorage {
    private static final ArrayStorage STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");

        STORAGE.save(r1);
        System.out.println(STORAGE.get(r1.getUuid()));
        STORAGE.update(r1);
        //STORAGE.delete(r2.getUuid());
        STORAGE.save(r2);
        STORAGE.save(r3);

        System.out.println(STORAGE.get(r1.getUuid()));
        System.out.println(STORAGE.size());
        //System.out.println(STORAGE.get("dummy"));

        printAll();
        STORAGE.delete(r2.getUuid());
        printAll();
        STORAGE.clear();
        printAll();

        System.out.println(STORAGE.size());
    }

    static void printAll() {
        for (Resume r : STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
