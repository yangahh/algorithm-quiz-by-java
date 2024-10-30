import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    input_str = input().rstrip()
    stack = []
    is_vps = True
    for x in input_str:
        if x == '(':
            stack.append(x)
        else:
            if stack:
                stack.pop()
            else:
                is_vps = False
                break

    if stack or is_vps is False:
        print("NO")
    else:
        print("YES")
