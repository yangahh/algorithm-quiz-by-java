import sys
from copy import deepcopy

input = sys.stdin.readline
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]

array = [[0] * 4 for _ in range(4)]
for i in range(4):
    row = list(map(int, input().split()))
    for j in range(4):
        num = row[j * 2]
        di = row[j * 2 + 1] - 1
        array[i][j] = [num, di]  # [물고기 번호, 방향] 저장

result = 0  # 최종 답


def turn_left(di):
    return (di + 1) % 8


def find_fish(array, index):
    for i in range(4):
        for j in range(4):
            if array[i][j][0] == index:
                return (i, j)


def move_all_fishes(array, now_x, now_y):
    for i in range(1, 17):
        position = find_fish(array, i)
        if not position:
            continue

        x, y = position[0], position[1]
        direction = array[x][y][1]

        for j in range(8):
            nx = x + dx[direction]
            ny = y + dy[direction]

            # 해당 방향으로 이동이 가능하다면 이동시키기
            if 0 <= nx and nx < 4 and 0 <= ny and ny < 4:
                if not (nx == now_x and ny == now_y):
                    array[x][y][1] = direction  # 현재 방향으로 저장
                    array[x][y], array[nx][ny] = array[nx][ny], array[x][y]  # 값 교환
                    break

            direction = turn_left(direction)


def move_shark_and_get_possible_positions(array, now_x, now_y):
    positions = []
    direction = array[now_x][now_y][1]
    # 현재의 방향으로 계속 이동시키기
    for _ in range(4):
        now_x += dx[direction]
        now_y += dy[direction]
        # 범위를 벗어나지 않는지 확인하며
        if 0 <= now_x and now_x < 4 and 0 <= now_y and now_y < 4:
            # 물고기가 존재하는 경우
            if array[now_x][now_y][0] != 0:
                positions.append((now_x, now_y))
    return positions


def dfs(array, now_x, now_y, total):
    global result

    array = deepcopy(array)

    total += array[now_x][now_y][0]  # 현재 위치의 물고기 먹기
    array[now_x][now_y][0] = 0  # 물고기를 먹었으므로 번호 값을 0로 설정

    move_all_fishes(array, now_x, now_y)

    positions = move_shark_and_get_possible_positions(array, now_x, now_y)

    if len(positions) == 0:
        result = max(result, total)  # 최댓값 저장
        return

    for nx, ny in positions:
        dfs(array, nx, ny, total)


dfs(array, 0, 0, 0)
print(result)
