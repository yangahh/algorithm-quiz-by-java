import sys
from collections import deque

input = sys.stdin.readline
n, m, k, x = map(int, input().split())
gragh = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    gragh[a].append(b)

visited = [0] * (n + 1)
q = deque([x])
result = []
result.sort()
distance = [0] * (n + 1)  # 출발점 x에서 각 도시로의 최단 거리

while q:
    node = q.popleft()
    for next_node in gragh[node]:
        if not visited[next_node]:
            visited[next_node] = 1
            distance[next_node] = distance[node] + 1  # 최단 거리 갱신
            q.append(next_node)

is_existing = False
for i in range(1, n + 1):
    if distance[i] == k and i != x:
        is_existing = True
        print(i)

if not is_existing:
    print(-1)
