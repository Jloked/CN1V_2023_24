import numpy as np


def simpson(f: callable, a, b, n=1):
    n *= 2
    h = (b - a) / n
    x = np.linspace(a, b, n + 1)
    y = f(x)
    return h / 3.0 * (y[0] + y[-1] + 4 * y[1::2].sum() + 2 * y[2:-1:2].sum())


if __name__ == '__main__':
    def f(x): return np.divide(1, np.sqrt(1 + x ** 4))
    print(simpson(f, 0, 1, 9))

    def g(x): return x**3
    print(simpson(g, 0, 1))
