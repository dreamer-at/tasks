package com.tasks.AlishevJavaCollectionsCourses;

import java.util.*;

public class AlishevComparatorSorting {

    public static void main(String[] args) {
        List<AlishevPerson> people = new ArrayList<>();
        people.add(new AlishevPerson(3, "Mike"));
        people.add(new AlishevPerson(2, "Katy"));
        people.add(new AlishevPerson(1, "Bob"));
        // в вызываевом обьекте AlishevPerson мы должны задать порядок на sort(), а то будет ругатся на sort()
        // или в качестве 2го аргумента самим задать порядок какой нам нужен
        Collections.sort(people, new Comparator<AlishevPerson>() {
            @Override
            public int compare(AlishevPerson o1, AlishevPerson o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else if (o1.getId() < o2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(people);

        List<String> animals = new ArrayList<>();
        animals.add("asdvd");
        animals.add("dog");
        animals.add("cat");
        animals.add("frog");
        animals.add("ab");
        animals.add("bird");
        animals.add("a");
        Collections.sort(animals, new StringLengthComparator());
        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);
        Collections.sort(numbers, new BackwardsIntegerComparator());
        System.out.println(numbers);
    }
}

class AlishevPerson {
    private int id;
    private String name;

    public AlishevPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AlishevPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

// сравниваем длину строк
class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
           return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}

// сравниваем целые числа
class BackwardsIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return 1;
        } else if (o1 < o2) {
            return -1;
        } else {
            return 0;
        }
    }
}
