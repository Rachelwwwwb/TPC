#!/bin/env python2

n = int(input())

for i in range(n):
    a = input().split(':')
    if '' in a:
        t = a.index('')
        a = [x for x in a if x]
        a[t: t] = ['0'] * (8 - len(a))
    print(':'.join(x.rjust(4, '0') for x in a))
