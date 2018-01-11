package com.realdolmen.ood020.composite;

public interface FileSystem {
    int getSize();
    int getFileCount();
    int getDirCount();

    void add(FileSystemComponent fileSystemComponent);
    void remove(FileSystemComponent fileSystemComponent);
    FileSystemComponent get(String name);
}
