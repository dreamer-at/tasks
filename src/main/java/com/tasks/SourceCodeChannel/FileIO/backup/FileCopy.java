package com.tasks.SourceCodeChannel.FileIO.backup;

import java.io.*;

public class FileCopy {

    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("file.txt")){
            File directory = new File("");
            if(!directory.exists()) {
                directory.mkdir();
            }
            try (FileOutputStream outputStream = new FileOutputStream("")) {
                byte[] bytes = new byte[inputStream.available()];
                int length;

                while ((length = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, length);
                }

            } catch (IOException ex) {
                System.out.println("Output error");
            }
        } catch (IOException ex) {
            System.out.println("Input error");
        }
    }
}
