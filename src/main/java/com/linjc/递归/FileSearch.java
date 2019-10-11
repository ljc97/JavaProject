package com.linjc.递归;

import java.io.File;

public class FileSearch {
    public static void main(String[] args) {
        search("F:\\temp", "test");
    }

    private static void search(String directory, String fileName) {
        File file = new File(directory);
        if (!file.exists()) {
            throw new RuntimeException("文件路径不存在!");
        }
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                search(f.toString(), fileName);
            } else {
                if (f.getName().indexOf(fileName) > -1) {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
}
