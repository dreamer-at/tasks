package com.tasks.AlishevJavaCollectionsCourses;

public class AlishevHashEqualsTwoPerson {
    int id;
    String name;

    public AlishevHashEqualsTwoPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Зачем нам нужны 2 метода для проверки равенства наших полей
    // Используя эти 2 обьяекты мы сравниваем наши поля, наиболее быстрым способом
    // сравнивая через equals() без hashCode очень долго, если мы хотим быстро проверить обьекты на рвенство, то мы
    // испольуем hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlishevHashEqualsTwoPerson that = (AlishevHashEqualsTwoPerson) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }
    // В 1ю очередь метод hashCode() все проверяет на равенстов и очень быстро в большинстве случаев, но если
    // метод hashCode() не отработается, то в силу вступит метод equals(), который в любом случае медленее проверит
    // на равенство и вернет нам достоверный результат
    @Override // Обьект любой длины -> конвертируется в int(которое фикс-й длины), таким образом мы любому обьекту
    // сопоставляем целое число, если через equals, то нужно сравнивать каждый обьект, но через hashCode() мы сконвертировали
    // наши обьекты в int и сравнили эти int(целые числа) между собой поэтому hashCode() быстрее equals()
    // случай когда у 2х разных обьектов одинаковые хэш коды, называется коллизией == если случилась коллизия, то в силу вступает
    // метод equals()
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    /*
        Контракт hashCode() equals()
        1) У 2х проверяемых обьектов вызываем метод hashCode()
           если хэши разные => 2 обьекта точно разные.
        2) Если хэши одинаковые -> то вызываем equals()
        3) equals -> ответ 
    */
}
