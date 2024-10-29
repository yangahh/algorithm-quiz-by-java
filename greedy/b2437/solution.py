import sys

input = sys.stdin.readline

n = int(input())
weights = list(map(int, input().split()))
weights.sort()

available_weight_range = [0, 0]

for weight in weights:
    cur_min_limit = available_weight_range[0]
    cur_max_limit = available_weight_range[1]

    new_min_limit = cur_min_limit + weight
    new_max_limit = cur_max_limit + weight

    if new_min_limit > cur_max_limit + 1:
        break

    available_weight_range = [cur_min_limit, new_max_limit]

print(available_weight_range[1] + 1)
