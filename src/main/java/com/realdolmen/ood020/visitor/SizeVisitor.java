package com.realdolmen.ood020.visitor;

public class SizeVisitor implements Visitor {
    private double size = 0.0;

    @Override
    public void visitFile(File file) {
        size += file.getSize();
    }

    @Override
    public void visitDir(Directory directory) {
        // Do nothing, directory doesn't have a size
    }

    public double getSize() {
        return size;
    }
}
