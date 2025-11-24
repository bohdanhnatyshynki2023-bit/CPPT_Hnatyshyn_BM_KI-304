import sys

# Імпорт класів із нашого пакету animals
from animals.cat import Cat
from animals.experimental_cat import ExperimentalCat

def main():

    # 1. Створення об'єкта базового класу
    print(">>> Створюємо звичайного кота:")
    simple_cat = Cat("Мурчик", 3, "Британець")
    print(simple_cat.get_info())
    simple_cat.meow()
    simple_cat.eat("рибу")
    print("-" * 30)

    # 2. Створення об'єкта похідного класу
    print(">>> Створюємо піддослідного кота:")
    # Передаємо параметри і для кота, і для експерименту
    super_cat = ExperimentalCat(
        name="Барсик-X", 
        age=5, 
        breed="Мейн-кун", 
        experiment_number=404, 
        superpower="Нічний зір та левітація"
    )

    # Перевірка успадкованих методів
    print(super_cat.get_info())
    
    # Перевірка перевизначеного методу
    super_cat.meow()
    
    # Перевірка унікального методу
    super_cat.use_superpower()
    
    # Перевірка успадкованого методу
    super_cat.sleep()

if __name__ == "__main__":
    main()