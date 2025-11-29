package KI_304.Hnatyshyn.Lab3;

import java.io.IOException;

/**
 * Клас ExperimentalCat, який представляє кота, що бере участь у наукових експериментах.
 * Наслідує клас Cat та реалізує інтерфейс Experimental.
 */
public class ExperimentalCat extends Cat implements Experimental {
    private double stressLevel; // Рівень стресу кота
    private int experimentCount; // Кількість проведених експериментів
    private boolean isUnderExperiment; // Статус кота під час експерименту

    /**
     * Конструктор ExperimentalCat.
     *
     * @param breed порода кота
     * @param healthStatus статус здоров'я
     * @param moodStatus статус настрою
     * @param name ім'я кота
     * @param age вік кота
     * @param weight вага кота
     * @throws IOException якщо виникає помилка при роботі з логером
     */
    public ExperimentalCat(Breed breed, HealthStatus healthStatus, MoodStatus moodStatus,
                           String name, int age, double weight) throws IOException {
        super(breed, healthStatus, moodStatus, name, age, weight);
        this.stressLevel = 0.0;
        this.experimentCount = 0;
        this.isUnderExperiment = false;
    }

    /**
     * Метод для проведення експерименту з котом.
     *
     * @param experimentType тип експерименту
     * @return true, якщо експеримент успішно проведено, false – якщо ні
     */
    @Override
    public boolean conductExperiment(String experimentType) {
        try {
            if (healthStatus.getHealth() < 50 || stressLevel > 80) {
                logger.log("Експеримент скасовано через поганий стан здоров'я або високий рівень стресу");
                return false;
            }

            isUnderExperiment = true;
            experimentCount++;
            stressLevel += 10;
            healthStatus.decreaseHealth(5);
            moodStatus.decreaseMood(15);

            logger.log(String.format("Проведено експеримент типу: %s. Кількість експериментів: %d",
                    experimentType, experimentCount));

            isUnderExperiment = false;
            return true;
        } catch (IOException e) {
            System.err.println("Помилка при записі в лог: " + e.getMessage());
            return false;
        }
    }

    /**
     * Метод для отримання рівня стресу кота.
     *
     * @return поточний рівень стресу
     */
    @Override
    public double getStressLevel() {
        return stressLevel;
    }

    /**
     * Метод, що описує специфічну поведінку кота залежно від його участі в експерименті.
     *
     * @return текстовий опис поведінки кота
     */
    @Override
    public String specificBehavior() {
        if (isUnderExperiment) {
            return "Кіт знаходиться під наглядом в лабораторії";
        } else {
            return "Кіт відпочиває після експерименту";
        }
    }

    /**
     * Метод для відновлення стану кота після експерименту.
     *
     * @throws IOException якщо виникає помилка при роботі з логером
     */
    public void recover() throws IOException {
        stressLevel = Math.max(0, stressLevel - 20);
        healthStatus.increaseHealth(10);
        moodStatus.improveMood(15);
        logger.log("Проведено відновлення після експерименту");
    }

    /**
     * Метод для отримання текстового представлення об'єкта ExperimentalCat.
     *
     * @return рядкове представлення об'єкта
     */
    @Override
    public String toString() {
        return "ExperimentalCat{" +
                "stressLevel=" + stressLevel +
                ", experimentCount=" + experimentCount +
                ", isUnderExperiment=" + isUnderExperiment +
                "} " + super.toString();
    }
}
