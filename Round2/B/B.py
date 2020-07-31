import sys
from collections import *
from itertools import *

n, first = input().split()
n = int(n)
a = list(map(int, input().split()))

a = [len(list(x)) for key, x in groupby(sorted(a))]
x = a.count(1)
y = a.count(2)
z = len(a) - x - y

winner = 'Alice'
if x == 0:
    if y == 0:
        winner = 'Bob'
    elif y == 1:
        winner = first
print(winner)
