package com.realdolmen.ood020.composite;

import java.util.HashSet;
import java.util.Set;

public class Directory extends FileSystemComponent {
    private Set<FileSystemComponent> content;

    public Directory(String name) {
        super(name);
        content = new HashSet<>();
    }

    @Override
    public int getSize() {
        int size = 0;
        for(FileSystemComponent component : content) {
            size += component.getSize();
        }
        return size;
    }

    @Override
    public int getFileCount() {
        int count = 0;
        for(FileSystemComponent fileSystemComponent : content) {
            count += fileSystemComponent.getFileCount();
        }
        return count;
    }

    @Override
    public int getDirCount() {
        int count = 1;
        for(FileSystemComponent fileSystemComponent : content) {
            count += fileSystemComponent.getDirCount();
        }
        return count;
    }

    @Override
    public void add(FileSystemComponent fileSystemComponent) {
        content.add(fileSystemComponent);
    }

    @Override
    public void remove(FileSystemComponent fileSystemComponent) {
        content.remove(fileSystemComponent);
    }

    @Override
    public FileSystemComponent get(String name) {
        return content.stream()
                .filter(component -> name.equals(component.name))
                .findAny()
                .orElse(null);
    }

    @Override
    public String toString() {
        return String.format("DIR: %s", super.name);
    }
}
