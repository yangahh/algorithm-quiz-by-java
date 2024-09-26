import heapq
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
INF = int(1e9)
dist = [INF] * (n + 1)
dist[0] = -1
dist[1] = 0

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b, x = map(int, input().split())
    graph[a].append((b, x))
    graph[b].append((a, x))

q = []
prev = [0] * (n + 1)  # 각 노드(=인덱스)의 부모(=어디에서 왔는지)를 저장하는 배열
heapq.heappush(q, (0, 1))

while q:
    x, now_node = heapq.heappop(q)
    if dist[now_node] < x:
        continue
    
    for linked_node, cost in graph[now_node]:
        if cost + dist[now_node] < dist[linked_node]:
            heapq.heappush(q, (cost + dist[now_node], linked_node))
            dist[linked_node] = cost + dist[now_node]
            prev[linked_node] = now_node

cnt = 0
route = []
for i in range(1, n + 1):
    if prev[i] != 0:
        cnt += 1
        route.append((i, prev[i]))

print(cnt)
for a, b in route:
    print(a, b)