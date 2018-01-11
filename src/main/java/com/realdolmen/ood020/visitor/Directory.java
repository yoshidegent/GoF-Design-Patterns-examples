package com.realdolmen.ood020.visitor;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemComponent {
    private List<FileSystemComponent> content;

    public Directory() {
        content = new ArrayList<>();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDir(this);
        for(FileSystemComponent component : content) {
            component.accept(visitor);
        }
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
    public FileSystemComponent get(int i) {
        return content.get(i);
    }
}
