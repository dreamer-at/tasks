package com.tasks.SourceCodeChannel.SCCRegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SCCRegExMain {

    // Регулярные выражения представляют собой строку которая описывает некоторую
    // последовательность символов, описание этих символов есть шаблоны которые
    // используются для поиска совпадений в других последовательнастях символов
    // двумя главными классами для обработки RegEx есть классы Pattern ad Matcher
    // Регулярные выражения определяются в классе Pattern, а связь межу послеоватеностями
    // символами и шаблонами осуществляется в классе Matcher

    public static void main(String[] args) {

        // Будем искать символы от и до [a-z] именно нижнего регистра + в конце поиск одного или боьше символа
        Pattern pattern1 = Pattern.compile("[a-z]+");

        Matcher matcher1 = pattern1.matcher("a b c d 1 2 3 4");
        // Ищем совпадения matcher1 по find()
        System.out.println(matcher1.find());

        Matcher matcher2 = pattern1.matcher("A B C D 1 2 3 4");
        System.out.println(matcher2.find());

        Pattern pattern2 = Pattern.compile("[a-zA-z0-9]]");



    }
}
