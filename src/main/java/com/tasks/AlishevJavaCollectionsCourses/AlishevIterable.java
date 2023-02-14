package com.tasks.AlishevJavaCollectionsCourses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlishevIterable {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


        Iterator<Integer> iterator = list.iterator();
        // До java 5 было так
        // iterator хранит в себе указатель на элемент обьекта, двигается на 1 еденицу вправо
        int idx = 0;
        while (iterator.hasNext()) {
            if(idx == 1)
                iterator.remove();
            System.out.println(iterator.next());
            idx++;
        }
        System.out.println(list);

        // iterator в ArrayList появился в java 5
       /* for(int x : list) {
            list.remove(1); // не можем изменять наш list во время выполнения foreach
            System.out.println(x);
        }*/
    }
}
