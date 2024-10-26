import sys

input = sys.stdin.readline
n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

white = 0
blue = 0


def quad_tree(start_x, start_y, graph_size):
    global white
    global blue

    cur = graph[start_x][start_y]
    for i in range(start_x, start_x + graph_size):
        for j in range(start_y, start_y + graph_size):
            if cur != graph[i][j]:
                next_size = graph_size // 2
                quad_tree(start_x, start_y, next_size)  # 왼쪽 위
                quad_tree(start_x, start_y + next_size, next_size)  # 오른쪽 위
                quad_tree(start_x + next_size, start_y, next_size)  # 왼쪽 아래
                quad_tree(start_x + next_size, start_y + next_size, next_size)  # 오른쪽 아래

                return

            cur = graph[i][j]

    if cur == 0:
        white += 1
    else:
        blue += 1
    return


quad_tree(0, 0, n)

print(white)
print(blue)
