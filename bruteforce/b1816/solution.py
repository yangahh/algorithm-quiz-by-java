import sys

input = sys.stdin.readline

n = int(input())

for _ in range(n):
    s = int(input())
    for i in range(2, 1_000_001):
        if s % i == 0:  # 100만 이하의 약수(소인수 포함)가 있다는 뜻
            print("NO")
            break
    else:
        print("YES")
