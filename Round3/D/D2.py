from heapq import *

E = []
F = []
vis = []

def DFS(u):
    sta = [u]
    vis[u] = True
    while sta:
        u = sta[-1]
        if E[u]:
            v = E[u].pop()
            if not vis[v]:
                vis[v] = True
                F[u].append(v)
                sta.append(v)
        else:
            sta.pop()

def BFS(u):
    h = []
    heappush(h, u)
    ans = []
    while h:
        u = heappop(h)
        ans.append(u)
        for v in F[u]:
            heappush(h, v)
    return ans

cas = int(raw_input())
for casi in range(cas):
    n, m = list(map(int, raw_input().split()))
    E = [[] for _ in range(n + 1)]
    F = [[] for _ in range(n + 1)]
    vis = [False for _ in range(n + 1)]
    for _ in range(m):
        u, v = list(map(int, raw_input().split()))
        E[u].append(v)
        E[v].append(u)
    for arr in E:
        arr.sort()
    DFS(1)
    ans = BFS(1)
    print(' '.join(str(x) for x in ans))
