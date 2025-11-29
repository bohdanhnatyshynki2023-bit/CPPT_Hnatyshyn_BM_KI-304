package KI304.Hnatyshyn.Lab5;

import java.io.*;
import java.util.Scanner;

/**
 * Клас для обчислення виразу y = cos(x)/sin(x) та запису/читання результату
 * з текстових та бінарних файлів.
 *
 * @author Гнатишин Богдан
 * @version 2.0 (оновлено для Лаб 5)
 */
public class ExpressionCalculator {

    // Мала величина для порівняння з нулем (допуск)
    private static final double EPSILON = 1e-9;
    // Коефіцієнт для переведення градусів в радіани
    private static final double DEGREES_TO_RADIANS = Math.PI / 180.0;

    // Результат обчислення
    private double result;

    /**
     * Обчислює вираз y = cos(x)/sin(x) (ctg(x)) та зберігає результат.
     *
     * @param x значення змінної x в градусах
     * @throws CalcException якщо виникає помилка ділення на нуль (sin(x) = 0)
     */
    public void calculate(double x) throws CalcException {

        // Використовуємо константу
        double rad = x * DEGREES_TO_RADIANS;
        double sinX = Math.sin(rad);

        // Використовуємо константу
        if (Math.abs(sinX) < EPSILON) {
            // Генерація власного виключення
            throw new CalcException("Помилка: sin(x) = 0, ділення на нуль неможливе.");
        }

        double cosX = Math.cos(rad);
        this.result = cosX / sinX;

        // Перевірка, чи результат є числом
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            throw new CalcException("Помилка: результат не є числом (NaN) або нескінченний.");
        }
    }

    /**
     * Повертає збережений результат обчислення.
     * @return результат обчислення
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Записує результат у текстовий файл.
     * Використовує PrintWriter, як рекомендовано в методичних вказівках[cite: 70].
     *
     * @param fName ім'я файлу
     * @throws FileNotFoundException
     */
    public void writeResTxt(String fName) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f", result); // Запис у текстовому форматі
        f.close();
    }

    /**
     * Читає результат з текстового файлу.
     * Використовує Scanner, як рекомендовано в методичних вказівках[cite: 60, 63].
     *
     * @param fName ім'я файлу
     */
    public void readResTxt(String fName) {
        try {
            File f = new File(fName);
            if (f.exists()) {
                Scanner s = new Scanner(f);
                result = s.nextDouble(); // Читання текстового формату
                s.close();
            } else {
                throw new FileNotFoundException("Файл " + fName + " не знайдено.");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Записує результат у бінарний файл.
     * Використовує DataOutputStream, як рекомендовано в методичних вказівках[cite: 95, 110].
     *
     * @param fName ім'я файлу
     * @throws IOException
     */
    public void writeResBin(String fName) throws IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result); // Запис у двійковому форматі
        f.close();
    }

    /**
     * Читає результат з бінарного файлу.
     * Використовує DataInputStream, як рекомендовано в методичних вказівках[cite: 79, 90].
     *
     * @param fName ім'я файлу
     * @throws IOException
     */
    public void readResBin(String fName) throws IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble(); // Читання двійкового формату
        f.close();
    }
}