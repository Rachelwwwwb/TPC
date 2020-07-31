import sys

def get_perm(s):
    return tuple(int(c) - 1 for c in ''.join(s))

lst = {}

def prework():
    S = 0
    for i in range(9):
        S = S << 4  | i

    Q, tail = [], 0
    lst[S] = 0
    Q.append(S)
    while tail < len(Q):
        u = Q[tail]
        tail += 1
        dis = lst[u]

        vs = [
            u & 0xffffff000 | (u & 0x00000000f) << 8 | (u & 0x000000ff0) >> 4,
            u & 0xfff000fff | (u & 0x00000f000) << 8 | (u & 0x000ff0000) >> 4,
            u & 0x000ffffff | (u & 0x00f000000) << 8 | (u & 0xff0000000) >> 4,
            u & 0xff0ff0ff0 | (u & 0x00000000f) << 24 | (u & 0x00f00f000) >> 12,
            u & 0xf0ff0ff0f | (u & 0x0000000f0) << 24 | (u & 0x0f00f0000) >> 12,
            u & 0x0ff0ff0ff | (u & 0x000000f00) << 24 | (u & 0xf00f00000) >> 12
        ]
        for v in vs:
            if v not in lst:
                lst[v] = dis + 1
                Q.append(v)

if __name__ == '__main__':
    prework()
    data = sys.stdin.read().split('\n')

    case = int(data[0])
    ans = []
    for i in range(case):
        loc = i * 6 + 1
        
        a = get_perm(data[loc: loc + 3])
        b = get_perm(data[loc + 3: loc + 6])

        c = [0] * 9
        for i in range(9):
            c[a[i]] = i

        u = sum(c[b[i]] << 4 * (8 - i) for i in range(9))
        if u in lst:
            ans.append(str(lst[u]))
        else:
            ans.append('impossible')
    print('\n'.join(ans))
