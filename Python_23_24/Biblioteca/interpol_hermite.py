from interpol_newton import polinomio_newton
import numpy as np


def coef_hermite(x: np.ndarray, y: np.ndarray):
    m = np.size(x)

    if len(x) != m:
        raise Exception('Las dimensiones de x e y no coinciden')

    l = np.zeros(m)
    aux = np.ones(m + 1)

    coef = y.copy()
    for i in range(n):
        div = (x[i + 1:n] - x[0:n - 1 - i])
        coef[i + 1:n] = np.divide((coef[i + 1:n] -
                                   coef[i:n - 1]), div)

    return coef


def interpol_newton(x: np.ndarray, y: np.ndarray, t: np.ndarray):
    coef = coef_newton(x, y)
    n = np.size(coef) - 1
    m = np.size(t)
    pt = np.ones(m) * coef[n]
    for i in range(n, -1, -1):
        pt = pt * (t - x[i]) + coef[i]
    return pt
