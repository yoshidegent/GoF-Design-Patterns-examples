package com.realdolmen.ood020.visitor;

public interface FileSystem {
    void accept(Visitor visitor);

    void add(FileSystemComponent fileSystemComponent);
    void remove(FileSystemComponent fileSystemComponent);
    FileSystemComponent get(int i);
}
