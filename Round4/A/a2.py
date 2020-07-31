
cas = int(raw_input())
for casi in range(cas):
    n = int(raw_input())
    s = 0
    b = [0] * 3
    c = [1 << 60] * 3
    for i in range(n):
        a = list(map(int, raw_input().split()))
        for j in range(n):
            t = 0
            if i == j:
                t += 1
            if i + j == n - 1:
                t += 1
            s += (t + 2) * a[j]

            b[t] = max(b[t], a[j])
            c[t] = min(c[t], a[j])

    ts = max((b[j] - c[i]) * (i - j)
        for i in range(3)
            for j in range(i + 1))
    print(s + ts)
