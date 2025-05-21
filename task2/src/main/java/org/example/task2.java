package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {

        String circleFile = "file1.txt";
        String pointsFile = "file2.txt";


        if (args.length >= 2) {
            circleFile = args[0];
            pointsFile = args[1];
        }

        try {

            Scanner circleScanner = new Scanner(new File(circleFile));
            double centerX = circleScanner.nextDouble();
            double centerY = circleScanner.nextDouble();
            double radius = circleScanner.nextDouble();
            circleScanner.close();


            if (radius <= 0) {
                System.out.println("радиус должен быть положительным");
                return;
            }


            Scanner pointsScanner = new Scanner(new File(pointsFile));
            while (pointsScanner.hasNextDouble()) {
                double pointX = pointsScanner.nextDouble();
                double pointY = pointsScanner.nextDouble();


                double dx = pointX - centerX;
                double dy = pointY - centerY;
                double distanceSquared = dx * dx + dy * dy;
                double radiusSquared = radius * radius;

                if (Math.abs(distanceSquared - radiusSquared) < 1e-9) {
                    System.out.println(0); // На окружности
                } else if (distanceSquared < radiusSquared) {
                    System.out.println(1); // Внутри
                } else {
                    System.out.println(2); // Снаружи
                }
            }
            pointsScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Проверьте:");
            System.out.println("1. Что файлы " + circleFile + " и " + pointsFile + " существуют");
            System.out.println("2. Что они лежат в корне проекта (рядом с папкой 'src')");
            System.out.println("3. Формат данных в файлах корректный");
        }
    }
}