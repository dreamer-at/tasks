package com.tasks.AlishevJavaCollectionsCourses.AlishevRegEx;

import java.util.Arrays;

public class AlishevRegExTwo {
    public static void main(String[] args) {
        String a = "Hello there hey";
        String[] words = a.split(" "); // Берет массив строк и делит эту строку по входящим критериям, тут например
        // делит строку на пробелах
        System.out.println(Arrays.toString(words));

        String b = "Hello there hey";
        String modifiedString = b.replace(" ", ".");
        System.out.println(modifiedString);

        String c = "1231232dffdsfsf211331313sdfdsfs";
        String repNum = c.replaceAll("\\d+", "-");
        System.out.println(repNum);
    }
}
