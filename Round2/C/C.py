
import sys

lst = (
        ('TP', 'C'),
        ('T', 'CP'),
        ('T', 'PC'),
        ('PT', 'C')
    )
def solve(s):
    if s.rfind('C') + 1 < s.find('P') and s.rfind('P') + 1 < s.find('T'):
        return 3
    if s.find('TPC') != -1:
        return 0
    if s.find('CPT') != -1:
        return 1
    for l, r in lst:
        loc = s.find(l)
        if loc != -1 and s.find(r, loc + len(l)) != -1:
            return 1
    return 2

cas = int(input())
for casi in range(cas):
    n = int(input())
    s = input()
    
    if 'T' in s and 'P' in s and 'C' in s:
        print(solve(s))
    else:
        print('Impossible')
