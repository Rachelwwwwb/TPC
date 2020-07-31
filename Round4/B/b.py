
cas = int(input())
for casi in range(cas):
    n = int(input())
    a = list(zip(map(int, input().split()), range(n)))
    m = n // 2
    a.sort()

    ans = sum(i for _, i in a[: m] if i >= m)
    ans -= sum(i for _, i in a[m: ] if i < m)
    print(ans)
