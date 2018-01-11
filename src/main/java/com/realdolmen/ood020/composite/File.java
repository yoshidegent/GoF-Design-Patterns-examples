package com.realdolmen.ood020.composite;

public class File extends FileSystemComponent {

    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getFileCount() {
        return 1;
    }

    @Override
    public int getDirCount() {
        return 0;
    }

    @Override
    public void add(FileSystemComponent fileSystemComponent) {
    }

    @Override
    public void remove(FileSystemComponent fileSystemComponent) {
    }

    @Override
    public FileSystemComponent get(String i) {
        return this;
    }

    @Override
    public String toString() {
        return String.format("FILE: %s (%s)", super.name, this.getSize());
    }
}
