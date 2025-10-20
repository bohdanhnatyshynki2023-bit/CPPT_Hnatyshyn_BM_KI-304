package KI_304.Hnatyshyn.Lab3;


import java.io.IOException;

/**
 * Клас CatDriver виконує основну програму для демонстрації функціональності класу Cat.
 */
public class ExperimentalCatDriver {
    /**
     * Головний метод, який запускає програму.
     *
     * @param args Аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            ExperimentalCat experimentalCat = new ExperimentalCat(
                    new Breed("Лабораторний"),
                    new HealthStatus(100.0),
                    new MoodStatus(100.0),
                    "Тестик",
                    2,
                    4.5
            );

            System.out.println("Початковий стан: " + experimentalCat.getInfo());

            experimentalCat.conductExperiment("Поведінковий тест");
            System.out.println("Рівень стресу: " + experimentalCat.getStressLevel());
            System.out.println("Особлива поведінка: " + experimentalCat.specificBehavior());

            experimentalCat.recover();
            System.out.println("Стан після відновлення: " + experimentalCat.getInfo());

            experimentalCat.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
