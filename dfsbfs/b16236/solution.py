import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
cur_size = 2
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
INF = int(1e9)

fish_cnt = 0
start_x, start_y = 0, 0
for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            start_x, start_y = i, j
            graph[i][j] = 0
        elif graph[i][j] != 0:
            fish_cnt += 1


def cal_fist_distance(from_x, from_y, cur_size):  # (x, y)위치에서 각 물고기 위치 까지의 거리 구하기
    dist = [[-1] * n for _ in range(n)]  # -1이면 갈 수 없는 칸임을 의미
    q = deque()
    q.append((from_x, from_y))

    dist[from_x][from_y] = 0

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue

            if dist[nx][ny] == -1 and graph[nx][ny] <= cur_size:  # 아직 한번도 처리한 적 없고, 이동할 수 있는 칸이면 거리 갱신
                dist[nx][ny] = dist[x][y] + 1
                q.append((nx, ny))

    return dist


def find_nearest_fish(dist, cur_size):
    min_dist = INF  # 먹을 수 있는 가장 가까운 물고기 거리
    x, y = 0, 0  # 먹을 수 있는 가장 가까운 물고기의 위치
    for i in range(n):
        for j in range(n):
            # 먹을 수 있는 물고기 조건: 이동 가능한 곳이면서 현재 크기보다 작은 것
            if dist[i][j] != -1 and 0 < graph[i][j] < cur_size:
                if dist[i][j] < min_dist:
                    min_dist = dist[i][j]
                    x, y = i, j
    if min_dist == INF:  # 먹을 수 있는 물고기가 없는 경우
        return None

    return x, y, min_dist


def count_fish(graph):
    cnt = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] > 0:
                cnt += 1
    return cnt


if not fish_cnt:
    print(0)
else:
    answer = 0
    ate_cnt = 0
    while True:
        dist = cal_fist_distance(start_x, start_y, cur_size)
        result = find_nearest_fish(dist, cur_size)

        if not result:
            break
        else:
            # 가장 가까운 물고기 먹기
            start_x = result[0]
            start_y = result[1]
            answer += result[2]
            ate_cnt += 1
            graph[start_x][start_y] = 0  # 물고기를 먹으면 0으로 초기화

            # 현재 크기보다 먹은 물고기 개수가 많아지면 현재 크기 증가
            if ate_cnt >= cur_size:
                cur_size += 1
                ate_cnt = 0

        if count_fish(graph) == 0:
            break

    print(answer)
