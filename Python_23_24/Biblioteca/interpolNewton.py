"""
Funcion para calcular los coeficientes del polinomio interpolador en la forma de Newton. Funciona como la version para octave.
Devuelve los coeficientes ordenados en orden de potencia creciente.
"""
import numpy as np
from numpy import polynomial


def interpolNewton(x: np.ndarray, y: np.ndarray):
    if x.ndim > 1 or y.ndim > 1:
        raise Exception('Las dimensiones de x e y son incorrectas')

    n = np.size(x)
    if np.size(y) != n:
        raise Exception('Las dimensiones de x e y no coinciden')

    coefNewton = y.copy()
    for i in range(n):
        div = (x[i + 1:n] - x[0:n - 1 - i])
        coefNewton[i + 1:n] = np.divide((coefNewton[i + 1:n] -
                                         coefNewton[i:n - 1]), div)

    return coefNewton


if __name__ == '__main__':
    x = np.array([1, 2, 3, 4, 5, 6])
    y = np.array([1, 2, 3, 4])
    z = interpolNewton(x, x)
    print(z)
    z = polynomial.Polynomial(z)  # convierto z en un polinomio (para numpy)
    print(z)
    f = polynomial.hermite.
    print(f)
    # print(interpolNewton(x, y)) esto da error (como debe ser)
