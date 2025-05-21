package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class task4 {

    public static void main(String[] args) {
        String filePath = "numbers.txt";

        try {

            Scanner scanner = new Scanner(new File(args[0]));
            int[] nums = readNumbers(scanner);
            scanner.close();


            int moves = calculateMinMoves(nums);


            System.out.println(moves);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден! Положите numbers.txt в папку с проектом.");
        }
    }


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


    private static int calculateMinMoves(int[] nums) {
        if (nums.length == 0) return 0;


        Arrays.sort(nums);


        int median = nums[nums.length / 2];


        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}