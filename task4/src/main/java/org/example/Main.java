package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filePath = "numbers.txt";  // Файл ищется в корне проекта

        try {
            // Читаем числа из файла
            Scanner scanner = new Scanner(new File(args[0]));
            int[] nums = readNumbers(scanner);
            scanner.close();

            // Вычисляем минимальное количество ходов
            int moves = calculateMinMoves(nums);

            // Выводим результат
            System.out.println(moves);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден! Положите numbers.txt в папку с проектом.");
        }
    }

    // Читаем числа из файла в массив
    private static int[] readNumbers(Scanner scanner) {
        int[] nums = new int[100]; // Начальный размер
        int count = 0;

        while (scanner.hasNextInt()) {
            if (count == nums.length) {
                nums = Arrays.copyOf(nums, nums.length * 2); // Увеличиваем массив при необходимости
            }
            nums[count++] = scanner.nextInt();
        }

        return Arrays.copyOf(nums, count); // Обрезаем до реального размера
    }

    // Считаем минимальное количество ходов
    private static int calculateMinMoves(int[] nums) {
        if (nums.length == 0) return 0;

        // Сортируем массив
        Arrays.sort(nums);

        // Берём медиану (серединный элемент)
        int median = nums[nums.length / 2];

        // Считаем сумму разниц с медианой
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}