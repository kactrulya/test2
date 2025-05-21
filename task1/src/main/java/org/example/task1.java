package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите n (размер массива): ");
        int n = scanner.nextInt();

        System.out.print("Введите m (длину интервала): ");
        int m = scanner.nextInt();

        List<Integer> path = findCircularPath(n, m);
        System.out.println("Полученный путь: " + path.toString().replaceAll("[\\[\\],]", ""));

        scanner.close();
    }

    public static List<Integer> findCircularPath(int n, int m) {
        List<Integer> path = new ArrayList<>();
        List<Integer> circularArray = new ArrayList<>();

        // Создаем круговой массив [1, 2, 3, ..., n]
        for (int i = 1; i <= n; i++) {
            circularArray.add(i);
        }

        int current = 0; // Начинаем с первого элемента

        do {
            // Добавляем текущий элемент в путь
            path.add(circularArray.get(current));

            // Вычисляем следующий интервал
            current = (current + m - 1) % n;

        } while (current != 0); // Пока не вернемся к первому элементу

        return path;
    }
}