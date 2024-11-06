candy_cnt = int(input())

result = 0
for a in range(1, candy_cnt + 1):
    for b in range(1, candy_cnt + 1 - a):
        for c in range(1, candy_cnt + 1 - (a + b)):
            if a + b + c == candy_cnt and a >= b + 2 and c % 2 == 0:
                result += 1

print(result)
