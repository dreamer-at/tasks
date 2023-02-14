package com.tasks.SourceCodeChannel.FileIO.backup;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {

    public static void main(String[] args) {

        String text = "Hello World";
        byte[] bytes = text.getBytes();

        try (FileOutputStream stream = new FileOutputStream("file.txt")) {
            for (byte eachByte : bytes) {
                stream.write(eachByte);
            }
        } catch (IOException ex) {
            System.out.println("Out error");
        }
    }
}
