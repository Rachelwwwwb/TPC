cas = int(input())
for casi in range(cas):
    s = input()
    a = s.count('0')
    b = len(s) - a
    if b * 2 + 2 < a:
        print('Impossible')
    elif a == 0:
        print(s)
    else:
        t = (a - 1) // 2
        print('1' * (b - t) + '001' * t + '0' * (a - 2 * t))
