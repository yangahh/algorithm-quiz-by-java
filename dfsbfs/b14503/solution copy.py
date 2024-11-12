import sys

input = sys.stdin.readline

# 0: 북, 1: 동, 2: 남, 3: 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n, m = map(int, input().split())
start_x, start_y, d = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]  # 0: 청소안한 곳, 2: 청소한 곳, 1: 벽
result = 0


def dfs(x, y, d):
    global result
    print()
    print("===============================================")
    print(f'x, y: {x}, {y}')
    print(f'현재 방향: {d}, ({dx[d]}, {dy[d]})')
    print()
    if graph[x][y] == 0:
        graph[x][y] = 2  # 청소했다는 의미
        result += 1

    for _ in range(4):
        print("===4방향 탐색(반시계)===")
        d = (d + 3) % 4  # 반시계 방향으로 회전
        print(f'nd: {d}')
        nx = x + dx[d]
        ny = y + dy[d]
        print(f'nx, ny: {nx}, {ny}')
        if nx >= 0 and nx < n and ny >= 0 and ny < m and graph[nx][ny] == 0:
            dfs(nx, ny, d)
            print("====끝======")
            return  # 한 방향을 처리했으므로 다음 방향으로 돌지 않게 재귀 종료

        # 한 칸 후진(현재 방향의 반대편)
    print("===주변 4칸에 빈칸 없음===")
    nx = x - dx[d]
    ny = y - dy[d]
    print(f'x, y: {x}, {y}')
    print(f'nx, ny: {nx}, {ny}')

    if nx >= 0 and nx < n and ny >= 0 and ny < m and graph[nx][ny] != 1:  # 벽이 아니라면 후진 가능(청소 했던 칸도 후진 가능)
        dfs(nx, ny, d)
    else:  # 후진을 할 수 없는 경우
        return


dfs(start_x, start_y, d)

print(result)
