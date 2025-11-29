package KI_304.Hnatyshyn.Lab2;

/**
 * Клас HealthStatus представляє стан здоров'я кота.
 * Містить рівень здоров'я та методи для його зміни і отримання.
 */
public class HealthStatus {
    private double health;

    /**
     * Конструктор за замовчуванням, який задає максимальний рівень здоров'я.
     */
    public HealthStatus() {
        this.health = 100.0;
    }

    /**
     * Конструктор, який дозволяє встановити початковий рівень здоров'я.
     * @param health Початковий рівень здоров'я.
     */
    public HealthStatus(double health) {
        this.health = health;
    }

    /**
     * Метод для збільшення рівня здоров'я на певну величину.
     * @param amount Кількість, на яку збільшується здоров'я.
     */
    public void increaseHealth(double amount) {
        health += amount;
        if (health > 100.0) health = 100.0; // Здоров'я не може бути більше 100%
    }

    /**
     * Метод для зменшення рівня здоров'я на певну величину.
     * @param amount Кількість, на яку зменшується здоров'я.
     */
    public void decreaseHealth(double amount) {
        health -= amount;
        if (health < 0.0) health = 0.0; // Здоров'я не може бути менше 0%
    }

    /**
     * Метод для встановлення рівня здоров'я.
     * @param health Новий рівень здоров'я.
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * Метод для отримання поточного рівня здоров'я.
     * @return Поточний рівень здоров'я.
     */
    public double getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "HealthStatus{" +
                "health=" + health +
                '}';
    }
}
