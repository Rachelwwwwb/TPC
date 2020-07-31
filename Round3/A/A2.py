cas = int(raw_input())
lst = ['ee', 'r', 've', 'le']
primes = [2, 3, 5, 7, 11, 13]
for casi in range(cas):
    num, com = raw_input().split()
    num = int(num)
    com = [i for i in range(4) if com.endswith(lst[i])][0]
    print(min(i for i in range(num, num + 5) if (i in primes if com == 3 else i % (com + 3) == 0)) - num)
