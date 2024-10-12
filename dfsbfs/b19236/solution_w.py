import sys
from copy import deepcopy

input = sys.stdin.readline
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]

graph = [[0] * 4 for _ in range(4)]
fish_info = [None] * 17
for i in range(4):
    row = list(map(int, input().split()))
    for j in range(0, 8, 2):
        num, di = row[j: j + 2]
        x, y = i, j // 2
        fish_info[num] = (x, y, di - 1)
        graph[x][y] = [num, di - 1]

# 최종 답
result = 0


# 물고기 이동
def move_fish(graph, fish_info):
    # global graph
    # global fish_info

    for num in range(1, 17):
        fish_info_result = fish_info[num]
        if not fish_info_result:  # 상어가 있던 자리면 패스
            continue

        x, y, di = fish_info_result

        loop_cnt = 1
        while loop_cnt <= 8:
            if di >= 8:
                di = di % 8
            nx = x + dx[di]
            ny = y + dy[di]

            if nx < 0 or nx >= 4 or ny < 0 or ny >= 4:
                di += 1
                loop_cnt += 1
                continue

            next_num, next_di = graph[nx][ny]
            if next_num == 0:
                di += 1
                loop_cnt += 1
                continue

            graph[x][y] = [next_num, next_di]
            graph[nx][ny] = [num, di]
            fish_info[num] = (nx, ny, di)
            fish_info[next_num] = (x, y, next_di)
            break

    return graph, fish_info


def move_shark_and_get_possible_positions(graph, x, y, di):  # 상어가 무조건 가장 큰 번호를 먹는건 아님!!!-> dfs를 해서 모든 케이스의 결과를 확인해야 한다. 그래서 이동 할 수 있는 모든 위치를 리스트로 반환해줘야 함
    positions = []
    while True:
        nx = x + dx[di]
        ny = y + dy[di]

        if nx < 0 or nx >= 4 or ny < 0 or ny >= 4:
            break

        fish_num, fish_di = graph[nx][ny]
        if fish_num != 0:  # 이미 상어가 먹은
            positions.append((nx, ny, fish_di))

        x, y = nx, ny

    return positions


def dfs(graph, fish_info, now_x, now_y, now_total):
    global result

    graph = deepcopy(graph)
    fish_info = deepcopy(fish_info)

    # 상어가 먹은 물고기 번호와 그 물고기의 방향 백업
    ate_fish_num = graph[now_x][now_y][0]
    shark_di = graph[now_x][now_y][1]

    # 상어가 먹은 곳은 번호를 0으로 초기화, fish_info에서 삭제하기
    graph[now_x][now_y][0] = 0
    fish_info[ate_fish_num] = None

    now_total += ate_fish_num

    graph, fish_info = move_fish(graph, fish_info)
    shark_possible_positions = move_shark_and_get_possible_positions(graph, now_x, now_y, shark_di)

    if len(shark_possible_positions) == 0:
        result = max(result, now_total)
        return

    for pos in shark_possible_positions:
        shark_x, shark_y, _ = pos
        dfs(graph, fish_info, shark_x, shark_y, now_total)


dfs(graph, fish_info, 0, 0, 0)
print(result)
