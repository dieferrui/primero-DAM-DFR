# Determinar el mayor y el menor número entre los tres

var_loop = True
while var_loop == True:
    print("Introduzca tres números reales: A, B y C")
    var_a = float(input())
    var_b = float(input())
    var_c = float(input())
    var_loop = True

    if var_a == var_b or var_a == var_c or var_b == var_c:
        print("Alguno de los caracteres son iguales, introduzca de nuevo.")
        continue
    else:
        var_loop = False

if var_a > var_b:
    if var_b > var_c:
        print("A es el mayor y C el menor.")
    elif var_a > var_c:
        print("A es el mayor y B el menor.")
    else:
        print("C es el mayor y B el menor.")
elif var_a > var_c:
    print("B es el mayor y C el menor.")
elif var_b > var_c:
    print("B es el mayor y A el menor.")
else:
    print("C es el mayor y A el menor")
