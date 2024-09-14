import sys
from collections import deque
from copy import deepcopy
from itertools import combinations

input = sys.stdin.readline
n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def make_3_wall(graph, wall_locations):
    for x, y in wall_locations:
        graph[x][y] = 1
    return graph


def infect_virus(graph):
    global virus
    
    q = deque(virus)
    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if graph[nx][ny] == 0:  # 전염 가능
                graph[nx][ny] = 2
                q.append((nx, ny))
                
    return graph


def count_safe_places(graph):
    cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                cnt += 1
    return cnt


safe_places = []
virus = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            safe_places.append((i, j))
        if graph[i][j] == 2:
            virus.append((i, j))

max_safe_place_cnt = 0
for combi in combinations(safe_places, 3):
    tmp_graph = make_3_wall(deepcopy(graph), combi)
    infected_graph = infect_virus(tmp_graph)
    cnt = count_safe_places(infected_graph)
    if max_safe_place_cnt < cnt:
        max_safe_place_cnt = cnt

print(max_safe_place_cnt)