package KI304.HNATYSHYN.Lab6;

/**
 * Головний клас-драйвер.
 */
public class Main {
    public static void main(String[] args) {
        // Створюємо конвеєр для об'єктів типу Item
        Conveyor<Item> myConveyor = new Conveyor<>();

        // 1. Додавання елементів (мінімум 2 різних класи: Detail та Box)
        myConveyor.add(new Detail("Шестерня", 0.5));
        myConveyor.add(new Box("Інструменти", 12.5));
        myConveyor.add(new Detail("Гвинт", 0.05)); // Найлегший елемент
        myConveyor.add(new Box("Запчастини", 5.0));

        // 2. Вивід вмісту
        System.out.println("\n--- Всі об'єкти на конвеєрі ---");
        myConveyor.printAll();

        // 3. Пошук мінімуму (Згідно варіанту 4 - мінімальний елемент)
        Item minItem = myConveyor.findMin();
        System.out.println("\n--- Мінімальний елемент (найлегший) ---");
        if (minItem != null) {
            System.out.println("Знайдено: " + minItem);
        }

        // 4. Видалення елементу
        System.out.println("\n--- Видалення другого елементу ---");
        myConveyor.remove(1); // Видаляємо "Інструменти"
        
        System.out.println("Оновлений список:");
        myConveyor.printAll();
    }
}