
from heapq import *
from itertools import *

cas = int(raw_input())
for casi in range(cas):
    n = int(raw_input())

    a = groupby(sorted(map(int, raw_input().split())))
    a = sorted(list(map(lambda x: (len(list(x[1])), x[0]), a)))
    if (n - a[-1][0]) * 4 + 1 < n:
        print('No')
        continue

    f = [[], [a[-1][1], 0, 0]]
    a[-1] = (a[-1][0] - 1, a[-1][1])
    a.sort()

    if a[-1][0] >= n // 2:
        A = a[-1: ]
        B = a[: -1]
    else:
        s = 0
        limit = 3 * (n - 1) // 4
        for i in range(len(a)):
            s += a[i][0]
            if s <= limit and (n - 1 - s) <= limit:
                A = a[: i + 1]
                B = a[i + 1: ]
                if s < n - s:
                    A, B = B, A
                break

    h = []
    heappush(h, (0, 1))
    A = sum([[k] * c for c, k in A], [])
    B = sum([[k] * c for c, k in B], [])
    while len(A) > 0 and len(B) > 0:
        dep, u = heappop(h)
        nc = len(f)
        if len(A) - 2 >= len(B):
            v1, v2 = A.pop(), B.pop()
            v3 = A.pop()
            v4 = A.pop()
            f[u][1] = nc
            f[u][2] = nc + 1
            f.append([v1, 0, 0])
            f.append([v2, nc + 2, nc + 3])
            f.append([v3, 0, 0])
            f.append([v4, 0, 0])
            heappush(h, (dep + 1, nc))
            heappush(h, (dep + 2, nc + 2))
            heappush(h, (dep + 2, nc + 3))
        else:
            v1, v2 = A.pop(), B.pop()
            f[u][1] = nc
            f[u][2] = nc + 1
            f.append([v1, 0, 0])
            f.append([v2, 0, 0])
            heappush(h, (dep + 1, nc))
            heappush(h, (dep + 1, nc + 1))

    last = None
    if len(A) > 0:
        last = A[-1]
    elif len(B) > 0:
        last = B[-1]
    if last:
        while True:
            _, u = heappop(h)
            if f[u][0] != last:
                f[u][1] = n
                f.append((last, 0, 0))
                break
    for i in range(1, n + 1):
        if f[i][1] > 0 and f[f[i][1]][0] < f[i][0]:
            f[i][1], f[i][2] = f[i][2], f[i][1]
        elif f[i][2] > 0 and f[f[i][2]][0] > f[i][0]:
            f[i][1], f[i][2] = f[i][2], f[i][1]

    print('Yes')
    print('\n'.join(' '.join(map(str, x)) for x in f[1: ]))
