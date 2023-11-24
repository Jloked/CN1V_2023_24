import numpy as np


def coeficientes_newton(x: np.array, y: np.array):
    n = len(x) - 1
    p = y.copy()
    for i in range(1, n + 1):
        for j in range(n, i - 1, -1):
            p[j] = (p[j] - p[j - 1]) / (x[j] - x[j - i])
    return p


if __name__ == '__main__':

    print(coeficientes_newton(np.array([5, -7, -6, 0]), np.array([1, -23, -54, -954])))
    print(coeficientes_newton(np.array([1.2, 1.22, 1.24, 1.25]), np.array([0.18232, 0.19885, 0.21511, 0.22314])))
