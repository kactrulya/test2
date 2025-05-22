package org.example;

import java.util.ArrayList;
import java.util.List;

public class task1 {
    public static void main(String[] args) {

        if (args.length >= 2) {

            try {
                int n = Integer.parseInt(args[0]);
                int m = Integer.parseInt(args[1]);

                if (n <= 0 || m <= 0) {
                    System.out.println("Ошибка: n и m должны быть положительными числами!");
                    return;
                }

                List<Integer> path = findCircularPath(n, m);
                System.out.println("Полученный путь: " + path.toString().replaceAll("[\\[\\],]", ""));
                return;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: аргументы должны быть целыми числами!");
            }
        }




        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            if (n <= 0 || m <= 0) {
                System.out.println("Ошибка: n и m должны быть положительными числами!");
                return;
            }

            List<Integer> path = findCircularPath(n, m);
            System.out.println("Полученный путь: " + path.toString().replaceAll("[\\[\\],]", ""));

        } catch (Exception e) {
            System.out.println("Ошибка ввода: введите два целых положительных числа через пробел");
        }
    }

    public static List<Integer> findCircularPath(int n, int m) {
        List<Integer> path = new ArrayList<>();
        List<Integer> circularArray = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            circularArray.add(i);
        }

        int current = 0;

        do {
            path.add(circularArray.get(current));
            current = (current + m - 1) % n;
        } while (current != 0);

        return path;
    }
}