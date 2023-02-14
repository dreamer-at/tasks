package com.tasks.AlishevJavaCollectionsCourses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlishevHashCodeAndEqualsMethods {

    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        // Integer x = 1;
        // x.equals();

        // Object object = new Object();
        // object.equals(); // сравнивает обьекты между собой, принимает на вход ссылку на обьект, адрес в памяти
        // String строки сравнивают через equals, а не через == (выдаст разные участки памяти)

        Person person1 = new Person(1, "Mike");
        Person person2 = new Person(1, "Mike");
        // person1.equals(); // Если мы просто даже создали класс любой как например Person, он может реализовывать методы
        // person1.hashCode(); // equals() и hashCode(), потому что все классы в Java наследуются от класса Object
        // equals() и hashCode() в Object реализованы так что если обьекты разные, то для всех разных обьектов
        // они возвращают только то что эти обьекты "разные"
        // чтобы equals() и hashCode() работали с нашими обьектами и возвращали правильный результат их нужно переопределять

     /* set.add("Hello"); // реализация правильная когда мы указываем в <key, value> Integer, String и т.д.,
        set.add("Hello");*/ // правильная реализация потому что в String, Integer внутри этих классов уже реализованы
        // методы hashCode() и equals(),

        // Когда мы через обьекты, как например Person передаем обьекты а в обьектах <key, value> то далее map или set
        // не распознает одинаковые значение внутри или нет, на это нам нужны методы hasCode() и equals()
        /*Person person1 = new Person(1, "Mike");
        Person person2 = new Person(1, "Katy");*/

        map.put(person1, "123");
        map.put(person2, "123");

        set.add(person1);
        set.add(person2);

        System.out.println(map);
        System.out.println(set);

        /*map.put(1, "Один");
        map.put(1, "Другое значение");

        set.add(1);
        set.add(1);

        boolean x = 1 == 2; // сравнение чисел которые добавляем в качестве ключей в Map или Set

        System.out.println(map); // выведет 1но уникальное значение от ключа
        System.out.println(set); // выведет 1но уникальное значение*/
    }
}

class Person {
    // Чтобы equals() и hashCode() работали, нужно определить их в нашем классе, так же как например в классах обертках
    // String, Integer и т.д. создали наш класс и на наши поля переопределили методы
    // Например в String или Integer классе они реализованы (equals, hashCode) и поэтому Map and Set работают
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // "==" вот так 2 строки сравнивать нельзя, потому что нам нужно сравнивать значения строк а не адрес в памяти
    // "==" сравнивает адреса в памяти, и адреса могут бывть разными если сравнивать строки то только через false
    // String нужно сравнивать через equals

    // hashCode() and equals() если адреса в памяти обьектов равны, например Person person1 = new Person(1, "Mike");
    // Person person2 = new Person(1, "Mike");, имеют две разные переменные которые ссылаются на 2 разных адреса в heap
    // или памяти
    // Переопределяем equals() и hashCode() класса Object
    // Если вы создаете и присваиваете локальную переменную примитивного типа, то все данные полностью хранятся на стеке.
    // Если же вы создаете объект, то ссылка хранится на стеке, сам же объект уже создается в куче.
    // При создании массива примитивных типов происходит то же самое что и с объектами: ссылка на массив храниться на стеке, а сам массив в куче.
    // Однако начиная с Java 6 Update 14 можно включить так называемый Escape-Analysis, который будет размещать объекты не покидающие метода тоже на стеке.
    // Сделать это можно выставив параметр -XX:+DoEscapeAnalysis. Но он будет работать только в -server моде. В Java 6 Update 18 данную опцию отключили,
    // а в Java 6 Update 21 вернули и сделали по умолчанию. Таким образом в вашей JVM запущенной на сервере данная оптимизация уже работает, если вы используете java6u21 и выше.
    // Размещение объектов и примитивов на стеке несказанно упрощает жизнь сборщику мусора.
    // Пользуйтесь этим - создавайте небольшие маложивущие immutable объекты вместо часто изменяемых долгоживущих.

    // Теперь мы сравниваем не как от класса Object просто обьекты, адреса, а именно по полям нашего обьекта
    @Override// Получаем обьект и сравниваем эти 2 обьекта
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override // Наш обьект получает hashCode, сжимается и конвертируется в целое число
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
