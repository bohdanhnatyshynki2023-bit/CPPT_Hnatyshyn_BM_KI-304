package KI304.HNATYSHYN.Lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * Параметризований клас "Конвеєр".
 * Реалізує варіант 4: пошук мінімального елементу.
 * @param <T> тип елементів на конвеєрі, який розширює Item (має вагу і порівнюється)
 */
public class Conveyor<T extends Item> {
    private List<T> items;

    /**
     * Конструктор для створення порожнього конвеєра.
     */
    public Conveyor() {
        items = new ArrayList<>();
    }

    /**
     * Додає елемент на конвеєр.
     * @param item об'єкт, який додається
     */
    public void add(T item) {
        items.add(item);
        System.out.println("Додано на конвеєр: " + item);
    }

    /**
     * Видаляє елемент з конвеєра за індексом.
     * @param index номер елементу (починаючи з 0)
     */
    public void remove(int index) {
        if (index >= 0 && index < items.size()) {
            T removed = items.remove(index);
            System.out.println("Знято з конвеєра: " + removed);
        }
    }

    /**
     * Повертає елемент за індексом.
     * @param index номер елементу
     * @return елемент типу T
     */
    public T get(int index) {
        return items.get(index);
    }

    /**
     * Виводить вміст конвеєра на екран.
     */
    public void printAll() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    /**
     * Знаходить мінімальний елемент у контейнері (найлегший).
     * @return об'єкт з найменшою вагою або null, якщо контейнер порожній.
     */
    public T findMin() {
        if (items.isEmpty()) {
            return null;
        }
        T min = items.get(0);
        for (T item : items) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }
}

// --- Допоміжні класи та інтерфейс (знаходяться в цьому ж файлі) ---

/**
 * Інтерфейс для об'єктів, що можуть бути на конвеєрі.
 */
interface Item extends Comparable<Item> {
    double getWeight();
}

/**
 * Клас Деталь.
 */
class Detail implements Item {
    private String name;
    private double weight;

    public Detail(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Item other) {
        return Double.compare(this.weight, other.getWeight());
    }

    @Override
    public String toString() {
        return "Деталь [Назва: " + name + ", Вага: " + weight + " кг]";
    }
}

/**
 * Клас Коробка.
 */
class Box implements Item {
    private String label;
    private double totalWeight;

    public Box(String label, double weight) {
        this.label = label;
        this.totalWeight = weight;
    }

    @Override
    public double getWeight() {
        return totalWeight;
    }

    @Override
    public int compareTo(Item other) {
        return Double.compare(this.totalWeight, other.getWeight());
    }

    @Override
    public String toString() {
        return "Коробка [Маркування: " + label + ", Вага: " + totalWeight + " кг]";
    }
}
