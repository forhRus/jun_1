package task1;

import java.util.*;
import java.util.stream.Collectors;

/*
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        int lenth = 10;
        final int bound = 20;

        OptionalDouble average = Arrays.stream(new Integer[lenth])  //  Массив заданной длины
                .map(n -> n = random.nextInt(bound))  //  заполняем случайными числами в определённых границах
                .filter(n -> n % 2 == 0)  //  поток чётных чисел
                .mapToInt(Integer::intValue)  //  поток целочисленных чисел
                .average();   //  среднее

        System.out.println(average.getAsDouble());

    }
}