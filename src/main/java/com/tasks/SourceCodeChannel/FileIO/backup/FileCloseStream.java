package com.tasks.SourceCodeChannel.FileIO.backup;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileCloseStream {

    public static void main(String[] args) {

        /*String text = "Some text";
        byte[] buffer = text.getBytes();



        try (FileOutputStream stream = new FileOutputStream("/com.company.SourceCodeChannel/file.txt")) {
            for (byte eachBufferElement : buffer) {
                stream.write(eachBufferElement);
            }
        } catch (IOException ex) {
            System.out.println("Input / Output error");

        }*/

        String text = "Some text";
        byte[] buffer = text.getBytes();

        FileOutputStream stream = null;

        try {
            stream = new FileOutputStream("com.company.SourceCodeChannel/file.txt");
            for (byte eachBufferElement : buffer) {
                stream.write(eachBufferElement);
            }

        } catch (IOException exception) {
            System.out.println("Input / Output error");

        } finally {
            try {
                if (stream != null)
                    stream.close();
            } catch (IOException exception) {
                System.out.println("Error of closing file 'txt'!");
            }
        }
    }
}
