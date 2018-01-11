package com.realdolmen.ood020.composite;

public class Client {

    private FileSystem root;

    Client() {
        root = new Directory("root");
    }

    private void init() {
        root.add(new Directory("dir1"));
        root.add(new Directory("dir2"));
        root.add(new Directory("dir3"));
        root.add(new Directory("dir4"));
        root.add(new Directory("dir5"));
        root.add(new Directory("dir6"));

        FileSystem dir1 = root.get("dir1");
        dir1.add(new Directory("dir1.1"));
        dir1.add(new Directory("dir1.2"));
        dir1.add(new Directory("dir1.3"));
        dir1.add(new File("file1.1.txt", 100));
        dir1.add(new File("file1.2.txt", 100));

        FileSystem dir1_1 = dir1.get("dir1.1");
        dir1_1.add(new File("file1.1.1.txt", 200));
        dir1_1.add(new File("file1.1.2.txt", 200));
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.init();

        System.out.println("File count: " + client.getRoot().getFileCount());
        System.out.println("Dir count: " + client.getRoot().getDirCount());
        System.out.println("Total size: " + client.getRoot().getSize());
    }

    public FileSystem getRoot() {
        return root;
    }
}
