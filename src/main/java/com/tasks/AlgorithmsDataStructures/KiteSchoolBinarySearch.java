package com.tasks.AlgorithmsDataStructures;

public class KiteSchoolBinarySearch {

    // Бинарный поиск, каждый массив делим на 2 и смтреть элемент боьше или меньше, если меньщше то идем направо
    // Сложность B(og n)
    public static void main(String[] args) {
        // Бинарный поиск
        // Массив
        int[] arr = {23,54,65,76,87};
        // Число, которое мы ищем
        int search = 87;
        // Индекс элемента, в котором хранится наше число. Если такого элемента нет, индекс будет равен -1
        int index = search(arr, search); // Вызываем метод search и передаем массив и число, которое ищем
        // Выводим индекс
        System.out.println(index);
    }

    static int search(int[] arr, int search){
        // Указываем границу массива, в котором ищем наше число
        // Начало границы
        int start = 0;
        // Конец границы
        int end = arr.length - 1;
        // Создали переменную, чтобы смотреть сколько раз цикл будет повторяться
        int i = 0;
        // Цикл, условие которого означает что сумма начала и конца будет больше 0
        while((start + end) > 0) {
            // Делим на два сумму границ, чтобы получить середину нашего массива
            int mid = (start + end) / 2; //2
            // Проверяем, элемент который находится в середине хранит число, которое мы ищем
            if (arr[mid] == search) {
                return mid; // Если да, то возвращаем индекс
            } else {
                // Если нет, то проверяем число которое мы ищем больше или меньше элемента который в середине
                if (arr[mid] < search) {
                    // Если элемент, который мы ищем больше элемента который в середине
                    // то начало границы устанавливаем за следующим элементом, который в середине
                    start = mid + 1;
                } else {
                    // Если элемент, который мы ищем меньше элемента который в середине
                    // то конец границы устанавливаем за предыдщуем элементом, который в середине
                    end = mid - 1;
                }
            }
            // Выводим итерацию(сколько раз повторялся цикл)
            System.out.println("Iteration: "+i);
            // Увеличиваем переменную на единицу
            i++;
        }
        // Если программа дошла до этой строки, значит искомое число не было найдено
        // И мы возвращаем какое-то число чтобы дать понять, что элемента c искомым числом не существует
        return -1;
    }
}