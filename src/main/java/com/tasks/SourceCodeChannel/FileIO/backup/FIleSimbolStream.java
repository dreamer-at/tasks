package com.tasks.SourceCodeChannel.FileIO.backup;

import java.io.FileWriter;
import java.io.IOException;

public class FIleSimbolStream {

    public static void main(String[] args) {

        String text = "Hello World";
        char[] chars = new char[text.length()];
        text.getChars(0, chars.length, chars, 0);

         try (FileWriter writer = new FileWriter("file.txt")) {
             for (char eachChar : chars) {
                 writer.write(eachChar);
             }
         } catch (IOException ex) {
             System.out.println("Output error");
         }

    }
}
