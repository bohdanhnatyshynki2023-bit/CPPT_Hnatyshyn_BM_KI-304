package KI_304.Hnatyshyn.Lab2;
import java.io.IOException;

/**
 * Клас Cat представляє кішку з параметрами здоров'я, настрою, віку, ваги і породи.
 * Містить методи для взаємодії з об'єктом кішки, включаючи годування, гру, перевірку стану здоров'я і настрою, та інші.
 */
public class Cat {
    private Breed breed;
    private HealthStatus healthStatus;
    private MoodStatus moodStatus;
    private Logger logger;
    private String name;
    private int age;
    private double weight;

    /**
     * Конструктор за замовчуванням. Створює кішку з попередньо встановленими параметрами.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public Cat() throws IOException {
        this.name = "Мурзик";
        this.breed = new Breed();
        this.healthStatus = new HealthStatus();
        this.moodStatus = new MoodStatus();
        this.age = 1;
        this.weight = 3.0;

        this.logger = new Logger("cat_log.txt");

        logger.log(String.format("Кота %s створено.", this.toString()));
    }

    /**
     * Конструктор з параметрами. Створює кішку з заданими параметрами.
     * @param breed Порода кота.
     * @param healthStatus Статус здоров'я кота.
     * @param moodStatus Настрій кота.
     * @param name Ім'я кота.
     * @param age Вік кота.
     * @param weight Вага кота.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public Cat(Breed breed, HealthStatus healthStatus, MoodStatus moodStatus, String name, int age, double weight) throws IOException {
        this.breed = breed;
        this.healthStatus = healthStatus;
        this.moodStatus = moodStatus;
        this.name = name;
        this.age = age;
        this.weight = weight;

        this.logger = new Logger("cat_log.txt");

        logger.log(String.format("Кота %s створено.", this.toString()));
    }

    /**
     * Метод для годування кота.
     * @param foodAmount Кількість їжі.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public void feed(double foodAmount) throws IOException {
        weight += foodAmount * 0.1;
        healthStatus.increaseHealth(foodAmount * 0.05);
        moodStatus.improveMood(foodAmount * 2);

        logger.log(String.format("Кота нагодовано. Нова вага: %s кг", weight));
        System.out.printf("Кота нагодовано. Нова вага: %s кг\n", weight);
    }

    /**
     * Метод для гри з котом.
     * @param duration Тривалість гри у хвилинах.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public void play(int duration) throws IOException {
        weight -= duration * 0.005;
        healthStatus.increaseHealth(duration * 0.1);
        moodStatus.improveMood(duration * 2);

        logger.log(String.format("Погралися з котом протягом %s хвилин", duration));
        System.out.printf("Погралися з котом протягом %s хвилин\n", duration);
    }

    /**
     * Метод для відвідування ветеринара.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public void visitVet() throws IOException {
        healthStatus.setHealth(100);
        moodStatus.decreaseMood(30);

        logger.log("Відвідано ветеринара. Здоров'я відновлено, але настрій погіршився");
        System.out.println("Відвідано ветеринара. Здоров'я відновлено, але настрій погіршився");
    }

    /**
     * Метод для перевірки здоров'я кота.
     * @return Рівень здоров'я у відсотках.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public double checkHealth() throws IOException {
        double health = healthStatus.getHealth();

        logger.log(String.format("Перевірено здоров'я: %s", health));
        System.out.printf("Перевірено здоров'я: %s\n", health);
        return health;
    }

    /**
     * Метод для перевірки настрою кота.
     * @return Рівень настрою у відсотках.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public double checkMood() throws IOException {
        double mood = moodStatus.getMood();

        logger.log(String.format("Перевірено настрій: %s", mood));
        System.out.printf("Перевірено настрій: %s\n", mood);
        return mood;
    }

    /**
     * Метод для зміни імені кота.
     * @param newName Нове ім'я.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public void changeName(String newName) throws IOException {
        String oldName = this.name;
        this.name = newName;

        logger.log(String.format("Змінено ім'я з %s на %s", oldName, newName));
        System.out.printf("Змінено ім'я з %s на %s\n", oldName, newName);
    }

    /**
     * Метод для святкування дня народження кота.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public void celebrateBirthday() throws IOException {
        age++;
        moodStatus.improveMood(50);

        logger.log(String.format("Відсвятковано день народження. Новий вік: %s років", age));
        System.out.printf("Відсвятковано день народження. Новий вік: %s років\n", age);
    }

    /**
     * Метод для вилізання на дерево.
     * @return true, якщо кіт успішно виліз на дерево, false - якщо ні.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public boolean climbTree() throws IOException {
        if (moodStatus.getMood() > 50 && healthStatus.getHealth() > 70) {
            moodStatus.improveMood(20);
            healthStatus.decreaseHealth(5);

            logger.log("Кіт успішно виліз на дерево");
            System.out.println("Кіт успішно виліз на дерево");
            return true;
        } else {
            logger.log("Кіт не зміг вилізти на дерево. Потрібен кращий настрій або здоров'я");
            System.out.println("Кіт не зміг вилізти на дерево. Потрібен кращий настрій або здоров'я");
            return false;
        }
    }

    /**
     * Метод для сну кота.
     * @param hours Кількість годин сну.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public void sleep(int hours) throws IOException {
        healthStatus.increaseHealth(hours * 5);
        moodStatus.improveMood(hours * 3);

        logger.log(String.format("Кіт проспав %s годин", hours));
        System.out.printf("Кіт проспав %s годин\n", hours);
    }

    /**
     * Метод для коректного закриття логера.
     * @throws IOException якщо виникає помилка під час закриття лог-файлу.
     */
    public void closeLogger() throws IOException {
        logger.close();
    }

    /**
     * Метод для отримання інформації про кота.
     * @return Рядок з інформацією про кота.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public String getInfo() throws IOException {
        String info = "Кіт: " + name + ", Порода: " + breed.getName() +
                ", Вік: " + age + " років, Вага: " + weight + " кг, " +
                "Здоров'я: " + checkHealth() + "%, " +
                "Настрій: " + checkMood() + "%";

        logger.log(String.format("Інформація про %s", info));
        return info;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "breed=" + breed +
                ", healthStatus=" + healthStatus +
                ", moodStatus=" + moodStatus +
                ", logger=" + logger +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}

