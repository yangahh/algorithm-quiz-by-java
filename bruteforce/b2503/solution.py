import sys

input = sys.stdin.readline

n = int(input())
hints = [tuple(map(int, input().split())) for _ in range(n)]

result = 0
for x in range(123, 988):
    str_x = str(x)
    if str_x[0] == '0' or str_x[1] == '0' or str_x[2] == '0':
        continue
    if str_x[0] == str_x[1] or str_x[1] == str_x[2] or str_x[2] == str_x[0]:
        continue

    pass_cnt = 0
    for number, s, b in hints:
        s_cnt = 0
        b_cnt = 0
        for i in range(3):
            if str(number)[i] in str_x:
                if str_x[i] == str(number)[i]:
                    s_cnt += 1
                else:
                    b_cnt += 1

        if s_cnt == s and b_cnt == b:
            pass_cnt += 1

    if pass_cnt == n:
        result += 1

print(result)
