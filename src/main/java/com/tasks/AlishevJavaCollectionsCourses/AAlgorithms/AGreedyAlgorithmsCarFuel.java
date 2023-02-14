package com.tasks.AlishevJavaCollectionsCourses.AAlgorithms;

public class AGreedyAlgorithmsCarFuel {

    public static void main(String[] args) {
        int[] stations = {0, 200, 375, 550, 750, 950};

        System.out.println(minStops(stations, 400));
    }

    // returns -1 if it's impossible to get from A to B
    public static int minStops(int[] stations, int capacity) {
        int result = 0; // Оптимальное количество остановок с заправкой по пути
        int currentStop = 0; // Остановка на которой находится машина

        // currentStop никогда не будет больше чем индекс последнего элемента в массиве
        while (currentStop < stations.length - 1) {
            int nextStop = currentStop;

            while (nextStop < stations.length - 1 &&
                    stations[nextStop + 1] - stations[currentStop] <= capacity) {
                nextStop++;
            }

            if(currentStop == nextStop) {
                return -1;
            }

            if(nextStop < stations.length -1) {
                result++;
            }
            currentStop = nextStop;
        }
        return result;
    }
}
