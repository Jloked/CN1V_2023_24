import numpy as np


def trapecio(f, a: float, b: float, num_divisiones: int):
    x = np.linspace(a, b, num_divisiones + 1)
    g = np.vectorize(f)
    im = g(x)
    return (b - a) * (im[0] + im[-1] + 2 * sum(im[1:-1])) / (2 * num_divisiones)


if __name__ == '__main__':
    from math import sin, pi

    def f(x): return sin(x)

    aprox = trapecio(f, 0, pi / 4, 100)

    print(aprox)
