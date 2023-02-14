package com.tasks.SourceCodeChannel.FileIO.backup;

import java.io.FileInputStream;
import java.io.IOException;

public class FileRead {

    public static void main(String[] args) {

        try (FileInputStream stream = new FileInputStream("file.txt")){
            int symbol;

            while ((symbol = stream.read()) != -1) {
                System.out.println((char) symbol);
            }
        } catch (IOException ex) {
            System.out.println("Input error");
        }
    }
}
