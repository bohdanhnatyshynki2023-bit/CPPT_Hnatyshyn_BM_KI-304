package KI_304.Hnatyshyn.Lab2;

/**
 * Клас MoodStatus представляє настрій кота.
 * Містить рівень настрою та методи для його зміни і отримання.
 */
public class MoodStatus {
    private double mood;

    /**
     * Конструктор за замовчуванням, який задає початковий рівень настрою в 50%.
     */
    public MoodStatus() {
        this.mood = 50.0;
    }

    /**
     * Конструктор, який дозволяє встановити початковий рівень настрою.
     * @param mood Початковий рівень настрою.
     */
    public MoodStatus(double mood) {
        this.mood = mood;
    }

    /**
     * Метод для підвищення рівня настрою на певну величину.
     * @param amount Кількість, на яку підвищується настрій.
     */
    public void improveMood(double amount) {
        mood += amount;
        if (mood > 100.0) mood = 100.0; // Настрій не може бути більше 100%
    }

    /**
     * Метод для зниження рівня настрою на певну величину.
     * @param amount Кількість, на яку знижується настрій.
     */
    public void decreaseMood(double amount) {
        mood -= amount;
        if (mood < 0.0) mood = 0.0; // Настрій не може бути менше 0%
    }

    /**
     * Метод для отримання поточного рівня настрою.
     * @return Поточний рівень настрою.
     */
    public double getMood() {
        return mood;
    }

    @Override
    public String toString() {
        return "MoodStatus{" +
                "mood=" + mood +
                '}';
    }
}