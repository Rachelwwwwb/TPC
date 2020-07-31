from itertools import *

def gen(s):
    return [len(list(gp)) for _, gp in groupby(s)]

cas = int(input())
for casi in range(cas):
    n = int(input())
    a, b = input(), input()
    a = ''.join([b[0], a, b[-1]])
    b = ''.join([b[0], b, b[-1]])
    a, b = gen(a), gen(b)

    i = 0
    ans = 0
    for t in b:
        j = i
        while j < len(a) and t > 0:
            t -= a[j]
            j += 1
        if t < 0 or (j - i) % 2 == 0:
            ans = -1
            break
        ans += (j - i) // 2
        i = j

    print(ans)
