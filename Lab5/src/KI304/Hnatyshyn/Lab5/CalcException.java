package KI304.Hnatyshyn.Lab5;

/**
 * Клас-виключення для обробки помилок обчислення.
 */
public class CalcException extends ArithmeticException {
    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(message);
    }
}