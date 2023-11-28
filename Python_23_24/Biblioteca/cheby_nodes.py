import numpy as np


def cheby_nodes(a, b, n):
    indic = (2 * np.arange(n, 0, -1) - 1) / (2 * n) * np.pi
    return (1 + np.cos(indic)) * (b - a) * 0.5 + a


if __name__ == '__main__':
    print(cheby_nodes(-1, 1, 5))
