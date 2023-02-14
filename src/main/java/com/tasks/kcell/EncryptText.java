package com.tasks.kcell;

import java.util.Base64;

public class EncryptText {

    public static void main(String[] args) {
        benchmark();
    }

    // кодируем строку с помощью кодировщика `Base64`
    private static void encodeBase64(String s) {
        var decode =  Base64.getEncoder().encodeToString(s.getBytes());
        System.out.println(decode);
    }

    // декодируем закодированные данные
    private static void decodeBase64(String s) {
        byte[] decodedBytes = Base64.getDecoder().decode(s);
        String decodedString = new String(decodedBytes);
        System.out.println(decodedString);
    }

    private static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время: " + elapsed + " ms");
    }

    private static void benchmark() {
        String s = "Переезжай в новую квартиру с одним чемоданом! Закажи опцию Smart Remont по выгодным условиям и получи квартиру с чистовой отделкой. Подробно по тел. 360 или https://clck.ru/Jd7C8 Переезжай в новую квартиру с одним чемоданом! Закажи опцию Smart Remont по выгодным условиям и получи квартиру с чистовой отделкой. Подробно по тел. 360 или https://clck.ru/Jd7C8 Переезжай в новую квартиру с одним чемоданом! Закажи опцию Smart Remont по выгодным условиям и получи квартиру с чистовой отделкой. Подробно по тел. 360 или https://clck.ru/Jd7C8 Переезжай в новую квартиру с одним чемоданом! Закажи опцию Smart Remont по выгодным условиям и получи квартиру с чистовой отделкой. Подробно по тел. 360 или https://clck.ru/Jd7C8 Переезжай в новую квартиру с одним чемоданом! Закажи опцию Smart Remont по выгодным условиям и получи квартиру с чистовой отделкой. Подробно по тел. 360 или https://clck.ru/Jd7C8";
        String e = "0J/QtdGA0LXQtdC30LbQsNC5INCyINC90L7QstGD0Y4g0LrQstCw0YDRgtC40YDRgyDRgSDQvtC00L3QuNC8INGH0LXQvNC" +
                "+0LTQsNC90L7QvCEg0JfQsNC60LDQttC4INC+0L/RhtC40Y4gU21hcnQgUmVtb250INC" +
                "/0L4g0LLRi9Cz0L7QtNC90YvQvCDRg9GB0LvQvtCy0LjRj9C8INC4INC" +
                "/0L7Qu9GD0YfQuCDQutCy0LDRgNGC0LjRgNGDINGBINGH0LjRgdGC0L7QstC+0Lkg0L7RgtC00LXQu9C60L7QuS4g0J" +
                "/QvtC00YDQvtCx0L3QviDQv9C+INGC0LXQuy4gMzYwINC40LvQuCBodHRwczovL2NsY2sucnUvSmQ3Qzgg0J" +
                "/QtdGA0LXQtdC30LbQsNC5INCyINC90L7QstGD0Y4g0LrQstCw0YDRgtC40YDRgyDRgSDQvtC00L3QuNC8INGH0LXQvNC" +
                "+0LTQsNC90L7QvCEg0JfQsNC60LDQttC4INC+0L/RhtC40Y4gU21hcnQgUmVtb250INC" +
                "/0L4g0LLRi9Cz0L7QtNC90YvQvCDRg9GB0LvQvtCy0LjRj9C8INC4INC" +
                "/0L7Qu9GD0YfQuCDQutCy0LDRgNGC0LjRgNGDINGBINGH0LjRgdGC0L7QstC+0Lkg0L7RgtC00LXQu9C60L7QuS4g0J" +
                "/QvtC00YDQvtCx0L3QviDQv9C+INGC0LXQuy4gMzYwINC40LvQuCBodHRwczovL2NsY2sucnUvSmQ3Qzgg0J" +
                "/QtdGA0LXQtdC30LbQsNC5INCyINC90L7QstGD0Y4g0LrQstCw0YDRgtC40YDRgyDRgSDQvtC00L3QuNC8INGH0LXQvNC" +
                "+0LTQsNC90L7QvCEg0JfQsNC60LDQttC4INC+0L/RhtC40Y4gU21hcnQgUmVtb250INC" +
                "/0L4g0LLRi9Cz0L7QtNC90YvQvCDRg9GB0LvQvtCy0LjRj9C8INC4INC" +
                "/0L7Qu9GD0YfQuCDQutCy0LDRgNGC0LjRgNGDINGBINGH0LjRgdGC0L7QstC+0Lkg0L7RgtC00LXQu9C60L7QuS4g0J" +
                "/QvtC00YDQvtCx0L3QviDQv9C+INGC0LXQuy4gMzYwINC40LvQuCBodHRwczovL2NsY2sucnUvSmQ3Qzgg0J" +
                "/QtdGA0LXQtdC30LbQsNC5INCyINC90L7QstGD0Y4g0LrQstCw0YDRgtC40YDRgyDRgSDQvtC00L3QuNC8INGH0LXQvNC" +
                "+0LTQsNC90L7QvCEg0JfQsNC60LDQttC4INC+0L/RhtC40Y4gU21hcnQgUmVtb250INC" +
                "/0L4g0LLRi9Cz0L7QtNC90YvQvCDRg9GB0LvQvtCy0LjRj9C8INC4INC" +
                "/0L7Qu9GD0YfQuCDQutCy0LDRgNGC0LjRgNGDINGBINGH0LjRgdGC0L7QstC+0Lkg0L7RgtC00LXQu9C60L7QuS4g0J" +
                "/QvtC00YDQvtCx0L3QviDQv9C+INGC0LXQuy4gMzYwINC40LvQuCBodHRwczovL2NsY2sucnUvSmQ3Qzgg0J" +
                "/QtdGA0LXQtdC30LbQsNC5INCyINC90L7QstGD0Y4g0LrQstCw0YDRgtC40YDRgyDRgSDQvtC00L3QuNC8INGH0LXQvNC" +
                "+0LTQsNC90L7QvCEg0JfQsNC60LDQttC4INC+0L/RhtC40Y4gU21hcnQgUmVtb250INC" +
                "/0L4g0LLRi9Cz0L7QtNC90YvQvCDRg9GB0LvQvtCy0LjRj9C8INC4INC" +
                "/0L7Qu9GD0YfQuCDQutCy0LDRgNGC0LjRgNGDINGBINGH0LjRgdGC0L7QstC+0Lkg0L7RgtC00LXQu9C60L7QuS4g0J" +
                "/QvtC00YDQvtCx0L3QviDQv9C+INGC0LXQuy4gMzYwINC40LvQuCBodHRwczovL2NsY2sucnUvSmQ3Qzg=";

        String s1 = "НИКОМУ НЕ ГОВОРИТЕ КОД! ВЫ РЕГИСТРИРУЕТЕСЬ на Kaspi.kz. Код:1645 CvKgcikChiJ";

        System.out.println("encodeBase64:");
        measureTime(() -> encodeBase64(s));

        System.out.println("decodeBase64:");
        measureTime(() -> decodeBase64(e));
    }
}
