
cas = int(input())
for casi in range(cas):
    n = int(input())
    a = list(zip(map(int, input().split()), range(n)))
    a.sort()
    a.reverse()

    ans = ['a'] * n
    diff = 0
    for val, i in a:
        if diff <= 0:
            diff += val
        else:
            diff -= val
            ans[i] = 'b'

    print(''.join(ans))
