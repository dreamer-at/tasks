package com.tasks.AlishevJavaCollectionsCourses.AAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class AGreedyAlgorithmsFractionalKnapsackProblem {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);

        final Item[] items = {item1, item2, item3};

        // Сортировка элементов по их удельному весу O(N * log(N)), Quicksort
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());

        System.out.println(Arrays.toString(items));

        final int W = 7;

        int weightSoFar = 0;
        double valueSoFar = 0;
        int currentItem = 0;

        // Пока текущий предмет < кол-во предметов и вес != 7, то есть пока в рюкзаке есть свободное место
        while (currentItem < items.length && weightSoFar != W) {
            // берем обьект целиком, если "накопленный вес который мы уже положили в рюкзак + вес очередного предмета"
            // меньше < чем вместимость нашего рюкзака, то мы можем взять следующий предмет целиком
                if(weightSoFar + items[currentItem].getWeight() < W) {
                    valueSoFar += items[currentItem].getValue();
                    weightSoFar += items[currentItem].getWeight();
                } else {
                    // берем только часть обьекта
                    // (W - weightSoFar) - сколько веса мы можем взять, и / на полный вес обекта -
                    // (double) items[currentItem].getValue()), это все умножаем на полную ценность обьекта -
                    // * items[currentItem].getValue() == в итоге получаем частичную ценность обьекта, часть обьекта
                    // которую мы взяли и эту Ценность прибавили к значению valueSoFar
                    valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight())
                            * items[currentItem].getValue();

                    // Заполняем наш рюкзак и выходим из цикла
                    weightSoFar += W; // Полный рюкзак
                }
                currentItem++;
        }
        System.out.println("Ценность наилучшего набора: " + valueSoFar);
    }
}

class Item {
    private int weight;
    private int value;

    public Item (int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public double valuePerUnitOfWeight() {
        return value / (double) weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return " {w = " + weight + ", v = " + value + "} ";
    }
}
