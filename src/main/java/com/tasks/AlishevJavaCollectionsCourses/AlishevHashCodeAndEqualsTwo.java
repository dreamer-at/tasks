package com.tasks.AlishevJavaCollectionsCourses;

import java.util.HashMap;
import java.util.HashSet;

public class AlishevHashCodeAndEqualsTwo {

    public static void main(String[] args) {
        HashMap<AlishevHashEqualsTwoPerson, String> map = new HashMap<>();
        HashSet<AlishevHashEqualsTwoPerson> set = new HashSet<>();

        AlishevHashEqualsTwoPerson person1 = new AlishevHashEqualsTwoPerson(1, "Mike");
        AlishevHashEqualsTwoPerson person2 = new AlishevHashEqualsTwoPerson(1, "Mike");

        map.put(person1, "123");
        map.put(person2, "123");

        set.add(person1);
        set.add(person2);

        System.out.println(map);
        System.out.println(set);

    }
}
