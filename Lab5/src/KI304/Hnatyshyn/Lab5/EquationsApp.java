package KI304.Hnatyshyn.Lab5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас-драйвер для тестування роботи з файлами класу ExpressionCalculator.
 *
 * @author Гнатишин Богдан
 * @version 1.0 (для Лаб 5)
 */
public class EquationsApp {

    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Введення та обчислення
            System.out.print("Введіть значення x (в градусах): ");
            double x = scanner.nextDouble();
            calculator.calculate(x);
            System.out.println("Результат обчислення: " + calculator.getResult());

            // 2. Запис у файли
            calculator.writeResTxt("textResult.txt");
            System.out.println("Результат записано у textResult.txt");

            calculator.writeResBin("binaryResult.bin");
            System.out.println("Результат записано у binaryResult.bin");

            // 3. Читання з файлів для перевірки
            // Читаємо з бінарного
            calculator.readResBin("binaryResult.bin");
            System.out.println("Результат, зчитаний з binaryResult.bin: " + calculator.getResult());

            // Читаємо з текстового
            calculator.readResTxt("textResult.txt");
            System.out.println("Результат, зчитаний з textResult.txt: " + calculator.getResult());

        } catch (CalcException | InputMismatchException | IOException e) {
            System.out.println("Виникла помилка: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Роботу програми завершено.");
        }
    }
}