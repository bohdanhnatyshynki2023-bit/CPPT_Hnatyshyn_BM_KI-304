import os
import struct
import sys
import math

# Функція для запису результату у текстовий файл
def writeResTxt(fName, result):
    try:
        # Відкриваємо файл у режимі запису тексту ('w')
        with open(fName, 'w') as f:
            f.write(str(result))
    except IOError as e:
        print(f"Помилка при записі у текстовий файл: {e}")
        sys.exit(1)

# Функція для зчитування результату з текстового файлу
def readResTxt(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            # Відкриваємо файл у режимі читання тексту ('r')
            with open(fName, 'r') as f:
                result = float(f.read()) # Перетворюємо рядок назад у число
        else:
            raise FileNotFoundError(f"Файл {fName} не знайдено.")
    except FileNotFoundError as e:
        print(e)
        sys.exit(1)
    except ValueError as e:
        print(f"Помилка перетворення даних: {e}")
        sys.exit(1)
    return result

# Функція для запису результату у бінарний файл
def writeResBin(fName, result):
    try:
        # Відкриваємо файл у режимі запису бінарних даних ('wb')
        with open(fName, 'wb') as f:
            # Використовуємо struct.pack для перетворення числа у байти.
            # 'd' означає double (8 байт), що є стандартом для float у Python
            f.write(struct.pack('d', result))
    except IOError as e:
        print(f"Помилка при записі у бінарний файл: {e}")
        sys.exit(1)

# Функція для зчитування результату з бінарного файлу
def readResBin(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            # Відкриваємо файл у режимі читання бінарних даних ('rb')
            with open(fName, 'rb') as f:
                # Зчитуємо 8 байт (розмір double) і розпаковуємо
                # unpack повертає кортеж, тому беремо нульовий елемент [0]
                result = struct.unpack('d', f.read(8))[0]
        else:
            raise FileNotFoundError(f"Файл {fName} не знайдено.")
    except FileNotFoundError as e:
        print(e)
        sys.exit(1)
    except struct.error as e:
        print(f"Помилка розпакування бінарних даних: {e}")
        sys.exit(1)
    return result

# Функція обчислення (Варіант 4: y = cos(x) / sin(x))
def calculate(x):
    # Перевірка на ділення на нуль (sin(x) = 0)
    sin_val = math.sin(x)
    if sin_val == 0:
        raise ValueError("Помилка обчислення: sin(x) дорівнює 0 (ділення на нуль).")
    
    return math.cos(x) / sin_val

# Головна частина програми
if __name__ == "__main__":
    try:
        # Введення даних
        data = float(input("Введіть значення x (у радіанах): "))
        
        # Обчислення
        result = calculate(data)
        print(f"Обчислений результат: {result}")
        
        # Імена файлів
        txt_file = "result_var4.txt"
        bin_file = "result_var4.bin"
        
        # Запис у файли
        writeResTxt(txt_file, result)
        writeResBin(bin_file, result)
        print("Результати успішно записано у файли.")
        
        # Зчитування з файлів для перевірки
        print(f"Зчитано з текстового файлу: {readResTxt(txt_file)}")
        print(f"Зчитано з бінарного файлу:  {readResBin(bin_file)}")
        
    except ValueError as e:
        print(f"Помилка вхідних даних або обчислення: {e}")
    except Exception as e:
        print(f"Виникла непередбачувана помилка: {e}")