import numpy as np
from math import factorial
from interpol_newton import polinomio_newton


def coef_hermite(x: np.ndarray, y: list):
    m = np.size(x)

    if len(y) != m:
        raise Exception('Las dimensiones de x e y no coinciden')

    l = np.zeros(m, dtype=int)
    aux = np.ones(m + 1, dtype=int)

    for i in range(m):
        l[i] = np.size(y[i])
        aux[i + 1] = aux[i] + l[i]
    n = aux[m] - 2
    nodos_rep = np.zeros(n + 1)
    coef = np.zeros(n + 1)

    for i in range(m):
        for j in range(aux[i], aux[i + 1]):
            nodos_rep[j - 1] = x[i]

    for k in range(n):
        for i in range(m, -1, -1):
            for j in range(aux[i] - 2, max(aux[i - 1], k + 1) - 2, -1):
                if nodos_rep[j - k] == nodos_rep[j]:
                    coef[j] = y[i - 1][k] / factorial(k)
                else:
                    coef[j] = (coef[j] - coef[j - 1]) / (nodos_rep[j] - nodos_rep[j - k])

    return coef, nodos_rep


def interpol_hermite(x: np.ndarray, y: list, t: np.ndarray):
    pass


if __name__ == '__main__':
    x = np.array([0, 1])
    y = [[0, 0, 0], [1, 4]]
    c, nodos = coef_hermite(x, y)
    print(c)
    print(polinomio_newton(c, nodos))
    print(polinomio_newton(np.array([0, 0, 0, 1, 1]), nodos))
