package KI304.Hnatyshyn.Lab4;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас для обчислення виразу y = cos(x)/sin(x) та запису результату у файл.
 *
 * @author Гнатишин Богдан
 * @version 1.0
 */
public class ExpressionCalculator {

    // Мала величина для порівняння з нулем (допуск)
    private static final double EPSILON = 1e-9;
    // Коефіцієнт для переведення градусів в радіани
    private static final double DEGREES_TO_RADIANS = Math.PI / 180.0;

    /**
     * Обчислює вираз y = cos(x)/sin(x) (ctg(x)).
     *
     * @param x значення змінної x в градусах
     * @return результат обчислення виразу
     * @throws CalcException якщо виникає помилка ділення на нуль (sin(x) = 0)
     */
    public double calculate(double x) throws CalcException {

        // Використовуємо константу
        double rad = x * DEGREES_TO_RADIANS;

        double sinX = Math.sin(rad);

        // Використовуємо константу
        if (Math.abs(sinX) < EPSILON) {
            // Генерація власного виключення
            throw new CalcException("Помилка: sin(x) = 0, ділення на нуль неможливе.");
        }

        double cosX = Math.cos(rad);
        double result = cosX / sinX;

        // Перевірка, чи результат є числом (на випадок інших непередбачуваних помилок)
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            throw new CalcException("Помилка: результат не є числом (NaN) або нескінченний.");
        }

        return result;
    }

    /**
     * Записує результат обчислення у файл.
     *
     * @param result     результат обчислення
     * @param filePath   шлях до файлу для запису
     * @throws IOException якщо виникає помилка запису у файл
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Результат обчислення: " + result);
        }
    }
}