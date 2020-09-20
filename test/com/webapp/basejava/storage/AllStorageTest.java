package com.webapp.basejava.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ArrayStorageTest.class,
    ListStorageTest.class,
    MapStorageTest.class,
    SortedArrayStorageTest.class,
    MapStorageAnotherTest.class
})
public class AllStorageTest {
}
