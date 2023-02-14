package com.tasks.AlishevJavaCollectionsCourses;

import java.util.*;

public class AlishevComparable {

    public static void main(String[] args) {
        List<ComparablePerson> peopleList = new ArrayList<>();
        // если мы хотим использовать наши классы, обьекты в качестве дженерик типов для коллекций например для TreeSet
        // мы должны в классе, обьекты переопределить методы сортировки например для TreeSet, хранит естественный порядок
        // и выдаст ошибку о том что наш обьект не реализует интерфейс Comparable
        Set<ComparablePerson> peopleSet = new TreeSet<>();

        addElements(peopleList);
        addElements(peopleSet);

        Collections.sort(peopleList);

        System.out.println(peopleList);
        System.out.println(peopleSet);
    }

    private static void addElements(Collection collection) {
        collection.add(new ComparablePerson(4, "George"));
        collection.add(new ComparablePerson(3, "Katy"));
        collection.add(new ComparablePerson(2, "Tom"));
        collection.add(new ComparablePerson(2, "Tom"));
        collection.add(new ComparablePerson(1, "Bob"));
        collection.add(new ComparablePerson(1, "Bob"));
    }
}
// Comparator - сравнение 2х обьектов между собой
// Comparable - годный, пригодный для сравнения, сравнение текщего обьекта с каким либо другим обьектом
// implements Comparable<ComparablePerson> указываем интерфейсу что будем сравнивать
class ComparablePerson  implements Comparable<ComparablePerson>{
    private int id;
    private String name;

    public ComparablePerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComparablePerson that = (ComparablePerson) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ComparablePerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(ComparablePerson o) {
        if (this.name.length() > o.getName().length()) {
            return 1;
        } else if (this.name.length() < o.getName().length()) {
            return -1;
        } else {
            return 0;
        }
    }

    /*@Override
    public int compareTo(ComparablePerson o) {
        if (this.id > o.getId()) {
            return 1;
        } else if (this.id < o.getId()) {
            return -1;
        } else {
            return 0;
        }
    }*/
}
