package com.realdolmen.ood020.visitor;

public class CountVisitor implements Visitor {
    private int fileCount = 0;
    private int dirCount = 0;

    @Override
    public void visitFile(File file) {
        fileCount++;
    }

    @Override
    public void visitDir(Directory directory) {
        dirCount++;
    }

    public int getFileCount() {
        return fileCount;
    }

    public int getDirCount() {
        return dirCount;
    }
}
