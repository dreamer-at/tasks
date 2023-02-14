package com.tasks.SourceCodeChannel.FileIO.backup;

import java.io.File;

public class FileCatalogs {

    public static void main(String[] args) {

        String path = "";
        File directory = new File(path);

        if (directory.isDirectory()) {
            String[] content = directory.list();

            if (content != null) {
               for (String eachFile : content) {
                   File file = new File(path + "/" + eachFile);
                   System.out.println(file.isDirectory() ? (eachFile + " is directory") : (eachFile + " is file"));
               }
            }
        }

       /* File directory = new File("");

        if(!directory.exists()) {
            System.out.println(directory.mkdir() ? "Successfully " : "Failed");
        } else {
            System.out.println("Already exists");
        }*/
    }
}
