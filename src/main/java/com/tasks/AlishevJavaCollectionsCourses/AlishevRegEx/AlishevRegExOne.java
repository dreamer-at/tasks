package com.tasks.AlishevJavaCollectionsCourses.AlishevRegEx;

public class AlishevRegExOne {
// RegExLib.com
    public static void main(String[] args) {
        /*
            \\d - одна цифра, специальный символ проверка на 1но число
            \\w - одна английская буква
            \\w = [a-zA-Z]
              + - 1 или более цифр
              * - 0 или более цифра
              ? - 0 или 1 символов до \\d, до начала основного паттерна, перед ?
              (x|y|z) - сравнение или, перед ? может быть или + или -
              [a-zA-Z] - от a до z(a или b или c), от A до Z, весь алфавит букв upper and lower case, большие и маленькие
              [0-9] - от 0 до 9, все возможные цифры, 0 или 1 или 2 или 3 например
              [^abc] - хотим все символы кроме [abc]
              {2} - 2 символ до {\\d{2}}
              {2,} - 2 или более символов (\\d{2,})
              {2,4} - 2 или более символов (\\d{2,4})
         */

        String a = "-98493194"; // Выдаст false потому что патерн RegEx на проверку цифры "1"
        String b = "834793874";
        String с = "+31989874";
        System.out.println(a.matches("(-|\\+)?\\d*"));
        System.out.println(b.matches("(-|\\+)?\\d*"));
        System.out.println(с.matches("(-|\\+)?\\d*"));

        String d = "333gdsdl111adlfkjhbgmfsm10982093"; // 1я буква или большая или маленькая
        System.out.println(d.matches("[a-zA-Z31]\\d+"));// и 3 и 1 помимо всех букв

        String e = "zzzsdf";
        System.out.println(e.matches("[^abc]*"));

        String url = "http://wwww.google.com";
        String url2 = "http://www.yandex.ru";
        System.out.println(url.matches("http://www\\..*\\.(com|ru)"));
        System.out.println(url2.matches("http://www\\..*\\.(com|ru)"));

        String f = "123";
        System.out.println(f.matches("\\d{3}"));

    }
}
