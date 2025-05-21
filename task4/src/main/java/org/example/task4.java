package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {

        String inputFile = "task4/numbers.txt";


        if (args.length > 0) {
            inputFile = args[0];
        }

        try {

            Scanner scanner = new Scanner(new File(inputFile));
            int[] nums = readNumbers(scanner);
            scanner.close();


            int minMoves = calculateMinMoves(nums);


            System.out.println(minMoves);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + inputFile);

        }
    }

    private static int[] readNumbers(Scanner scanner) {

        int[] temp = new int[100];
        int count = 0;

        while (scanner.hasNextInt()) {
            if (count == temp.length) {

                temp = Arrays.copyOf(temp, temp.length * 2);
            }
            temp[count++] = scanner.nextInt();
        }


        return Arrays.copyOf(temp, count);
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