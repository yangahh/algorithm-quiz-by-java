# 시간초과

import sys
from itertools import combinations

input = sys.stdin.readline

n = int(input())
weights = list(map(int, input().split()))
max_range = sum(weights)

sum_comb_set = set(weights)
for i in range(2, n):
    for comb in combinations(weights, i):
        sum_comb_set.add(sum(comb))

sum_combs = list(sum_comb_set)

result = 1
for i in range(1, max_range):
    if i not in sum_combs:
        result = i
        break

print(result)
