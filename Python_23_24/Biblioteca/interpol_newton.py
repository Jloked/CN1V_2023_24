import numpy as np
from numpy import polynomial


def coef_newton(x: np.ndarray, y: np.ndarray):
    if x.ndim > 1 or y.ndim > 1:
        raise Exception('Las dimensiones de x e y son incorrectas')

    n = np.size(x)
    if np.size(y) != n:
        raise Exception('Las dimensiones de x e y no coinciden')

    coef_newton = y.copy()
    for i in range(n):
        div = (x[i + 1:n] - x[0:n - 1 - i])
        coef_newton[i + 1:n] = np.divide((coef_newton[i + 1:n] -
                                          coef_newton[i:n - 1]), div)

    return coef_newton


def polinomio_newton(coef: np.ndarray, nodos: np.ndarray):
    n = np.size(coef) - 1
    a = np.zeros(n + 1)
    for i in range(n, -1, - 1):
        for k in range(n - i, 0, - 1):
            a[k] = a[k - 1] - a[k] * nodos[i]
        a[0] = coef[i] - a[0] * nodos[i]

    np.flip(a)
    return polynomial.polynomial.Polynomial(a).trim()


def interpol_newton(x: np.ndarray, y: np.ndarray, t: np.ndarray):
    coef = coef_newton(x, y)
    n = np.size(coef) - 1
    m = np.size(t)
    pt = np.ones(m) * coef[n]
    for i in range(n, -1, -1):
        pt = pt * (t - x[i]) + coef[i]
    return pt


if __name__ == '__main__':
    import matplotlib.pyplot as plt

    x = np.array([1, 2, 3, 4, 5, 6])
    y = np.array([1, 2, 3, 4])
    z = coef_newton(x, x)
    print(z)
    z = polinomio_newton(z, x)
    print(z)
    print(interpol_newton(x, x, [1, 2, 3, 4]))
    fig1, ax = plt.subplots()

    ax.plot(np.linspace(0, 2, 100), interpol_newton(x, x, np.linspace(0, 2, 100)))
    plt.show()
    # print(interpolNewton(x, y)) esto da error (como debe ser)
