class Cat:
    """
    Базовий клас, що описує звичайного кота.
    """
    def __init__(self, name, age, breed):
        # Ініціалізація атрибутів об'єкта
        self.name = name    # Публічний атрибут
        self.age = age
        self._breed = breed # Захищений атрибут (single underscore convention)

    def meow(self):
        """Метод, що імітує голос кота."""
        print(f"{self.name} каже: Мяу!")

    def eat(self, food):
        """Метод годування."""
        print(f"{self.name} їсть {food}.")

    def sleep(self):
        """Метод сну."""
        print(f"{self.name} лягає спати.")

    def get_info(self):
        """Повертає рядок з інформацією про кота."""
        return f"Кіт: {self.name}, Вік: {self.age}, Порода: {self._breed}"