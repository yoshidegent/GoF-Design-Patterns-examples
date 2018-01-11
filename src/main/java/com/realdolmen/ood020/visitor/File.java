package com.realdolmen.ood020.visitor;

public class File extends FileSystemComponent {
    private int size;

    public File(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFile(this);
    }

    @Override
    public void add(FileSystemComponent fileSystemComponent) {
    }

    @Override
    public void remove(FileSystemComponent fileSystemComponent) {
    }

    @Override
    public FileSystemComponent get(int i) {
        return this;
    }
}
