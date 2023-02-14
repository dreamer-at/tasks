package com.tasks.SourceCodeChannel.FileIO.backup;

import java.io.FileReader;
import java.io.IOException;

public class FileSymbolRead {

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("file.txt")) {
            int symbol;

            while ((symbol = reader.read()) != -1) {
                System.out.println((char) symbol);
            }
        } catch (IOException ex) {
            System.out.println("Input error");
        }
    }
}
