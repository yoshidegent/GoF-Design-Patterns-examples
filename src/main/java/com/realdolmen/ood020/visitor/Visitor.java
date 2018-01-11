package com.realdolmen.ood020.visitor;

public interface Visitor {
    void visitFile(File file);
    void visitDir(Directory directory);
}
