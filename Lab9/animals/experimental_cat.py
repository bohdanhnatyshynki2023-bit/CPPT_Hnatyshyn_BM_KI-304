from .cat import Cat

class ExperimentalCat(Cat):
    """
    Похідний клас 'Піддослідний кіт', що успадковує клас Cat.
    """
    def __init__(self, name, age, breed, experiment_number, superpower):
        # Виклик конструктора базового класу (Cat)
        super().__init__(name, age, breed)
        
        # Унікальні атрибути піддослідного кота
        self.experiment_number = experiment_number
        self.superpower = superpower

    # Перевизначення методу (Polymorphism)
    def meow(self):
        print(f"Піддослідний {self.name} (Об'єкт #{self.experiment_number}) видає дивний звук!")

    def use_superpower(self):
        """Унікальний метод піддослідного кота."""
        print(f"{self.name} використовує суперсилу: {self.superpower}!")

    # Розширення методу get_info
    def get_info(self):
        base_info = super().get_info()
        return f"{base_info} | Експеримент №{self.experiment_number}, Сила: {self.superpower}"