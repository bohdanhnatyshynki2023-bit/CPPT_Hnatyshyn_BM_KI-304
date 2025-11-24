import sys 
diagnal = "@"
try:
    rows_num = int(input("Введіть розмір квадратної матриці: "))
    filler = input("Введіть символ-заповнювач: ")
except ValueError:
    print("Помилка: Розмір матриці має бути цілим числом.")
    sys.exit(1)

if len(filler) == 0:
    print("Не введено символ-заповнювач")
    sys.exit(1)
elif len(filler) > 1:
    print("Забагато символів-заповнювачів")
    sys.exit(1)


jagged_list = []

for i in range(rows_num):
    row = []
    for j in range(rows_num):
        if i >= j and i + j >= rows_num - 1:
            row.append(ord(filler))
        else :
            row.append(ord(' '))
            
    jagged_list.append(row)

print("\nРезультат виконання:")
for i in range(len(jagged_list)):
    for code in jagged_list[i]:
        print(chr(code), end=" ")
    print()