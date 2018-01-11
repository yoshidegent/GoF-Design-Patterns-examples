package com.realdolmen.ood020.visitor;

public class Client {

    public static void main(String[] args) {
        SizeVisitor sizeVisitor = new SizeVisitor();
        CountVisitor countVisitor = new CountVisitor();
        PrintVisitor printVistor = new PrintVisitor();

        FileSystemComponent fileSystem = new Directory();
        Directory directory = new Directory();
        File file = new File(100);
        fileSystem.add(directory);
        directory.add(file);
        directory.add(file);
        directory.add(file);
        Directory directory2 = new Directory();
        directory.add(directory2);
        directory2.add(file);
        directory2.add(file);

        fileSystem.accept(countVisitor);
        System.out.println("File count: " + countVisitor.getFileCount());
        System.out.println("Dir count: " + countVisitor.getDirCount());
        fileSystem.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getSize());
    }
}
