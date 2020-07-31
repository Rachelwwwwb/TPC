
cas = int(raw_input())
for casi in range(cas):
    n = int(raw_input())
    a = list(zip(map(int, raw_input().split()), range(n)))
    m = n // 2
    a.sort()

    ans = sum(i for _, i in a[: m] if i >= m)
    ans -= sum(i for _, i in a[m: ] if i < m)
    print(ans)
