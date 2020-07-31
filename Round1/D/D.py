import numpy

M = 10 ** 9 + 7
cas = int(input())
for casi in range(cas):
    n, m = map(int, input().split())
    s = input()

    tn = n // 3
    if tn < m:
        print("0")
        continue

    f = numpy.ndarray([8, tn + 2], int)
    g = numpy.ndarray([8, tn + 2], int)
    f.fill(0)
    g.fill(0)
    f[0][0] = 1
    for si, c in enumerate(s):
        nf = si // 3 + 1 

        for i in range(1, 8):
            g[i][: nf] = 0
        for k in range(3):
            if c != chr(48 + k) and c != '?':
                continue
            for i in range(7):
                g[i | 1 << k][: nf] += f[i][: nf]
        for i in range(1, 8):
            g[i][: nf] %= M

        g[0][0] = 0
        g[0][1: nf + 1] = g[7][: nf]
        f, g = g, f
    ans = sum(sum(f[i][m: ]) for i in range(7)) % M
    print(ans)
