package KI_304.Hnatyshyn.Lab3;
/**
 * Інтерфейс Experimental, що визначає поведінку об'єктів, які можуть брати участь в експериментах.
 */
public interface Experimental {
    /**
     * Метод для проведення експерименту
     * @param experimentType тип експерименту
     * @return результат експерименту
     */
    boolean conductExperiment(String experimentType);

    /**
     * Метод для отримання рівня стресу
     * @return рівень стресу у відсотках
     */
    double getStressLevel();
}