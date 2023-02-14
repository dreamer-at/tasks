package com.tasks.SourceCodeChannel.FileIO.backup;

import java.io.File;

public class FIleClass {

    public static void main(String[] args) {
        String path = "F:/ARCH.txt";
        File file = new File(path);

        System.out.println("File name" + file.getName() + "\n");

        System.out.println("File Path" + file.getPath());
        System.out.println("File Absolutely Path" + file.getAbsolutePath() + "\n");

        System.out.println("File Parent Directory" + file.getParent());
        System.out.println("File Length" + file.length() + " bytes" + "\n");

        System.out.println("File exists");
    }
}