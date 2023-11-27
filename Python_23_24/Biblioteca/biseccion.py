import numpy as np


def biseccion(f, a: float, b: float, tol: float, max_iter: int):
    aa, bb, fa, fb = a, b, f(a), f(b)
    if fa * fb > 0:
        raise Exception('No hay cambio de signo')

    for k in range(max_iter):
        h = 0.5 * (bb - aa)
        c = aa + h
        fc = f(c)
        if abs(h) < tol and abs(fc) < tol:
            return c, k
        if fc * fa > 0:
            aa = c
            fa = fc
        else:
            bb = c
            fb = fc
    raise Exception('Numero maximo de iteraciones alcanzado')


if __name__ == '__main__':
    def f(x): return x ** 3 - 2007

    print('Aproximacion: %.16f | Iteraciones: %d' % biseccion(f, 12, 13, 10**-1, 100))
    print('Aproximacion: %.16f | Iteraciones: %d' % biseccion(f, 12, 13, 10 ** -12, 1000))