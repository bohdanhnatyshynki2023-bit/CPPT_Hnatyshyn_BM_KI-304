package KI_304.Hnatyshyn.Lab3;

/**
 * Клас Breed представляє породу кота.
 * Містить ім'я породи та методи для доступу до нього.
 */
public class Breed {
    private String name;

    /**
     * Конструктор за замовчуванням, який задає стандартну породу.
     */
    public Breed() {
        this.name = "Домашня короткошерста";
    }

    /**
     * Конструктор з параметром для задання конкретної породи.
     * @param name Ім'я породи.
     */
    public Breed(String name) {
        this.name = name;
    }

    /**
     * Метод для отримання імені породи.
     * @return Ім'я породи.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "name='" + name + '\'' +
                '}';
    }
}