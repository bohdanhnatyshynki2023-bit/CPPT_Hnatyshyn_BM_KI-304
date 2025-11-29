package KI_304.Hnatyshyn.Lab2;

import java.io.IOException;

/**
 * Клас CatDriver виконує основну програму для демонстрації функціональності класу Cat.
 */
public class CatDriver {
    /**
     * Головний метод, який запускає програму.
     *
     * @param args Аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            // Створення нового кота з параметрами
            Cat cat = new Cat(
                    new Breed("Сфінкс"),
                    new HealthStatus(100.0),
                    new MoodStatus(30.0),
                    "Рижик",
                    1,
                    5
            );

            // Взаємодії з котом
            cat.feed(0.5);
            cat.play(10);
            cat.visitVet();
            cat.checkHealth();
            cat.checkMood();
            cat.changeName("Фіолетік");
            cat.celebrateBirthday();
            cat.climbTree();
            cat.sleep(1);
            cat.getInfo();

            // Закриття лог-файлу
            cat.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}