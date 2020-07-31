idef check(num, k, K):
    if num == 1:
        return False
    for _ in range(k):
        j = 3
        while j * j <= num:
            if num % j == 0:
                return False
            j += 2
        num = num % K * 10 + num // K
    return True

s = raw_input().strip()
s = [ord(c) - 48 for c in s]
n = len(s)
ans = -1
for d in [2, 3, 5, 7]:
    if d in s:
        ans = d
use = set([1, 3, 7, 9])
for i in range(n):
    if s[i] not in use:
        continue
    j = i
    num, K = 0, 1
    while j < n and s[j] in use:
        num = num * 10 + s[j]
        j += 1
        if check(num, j - i, K):
            ans = max(ans, num)
        K *= 10
print(ans)
