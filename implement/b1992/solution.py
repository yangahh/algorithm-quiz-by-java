import sys

input = sys.stdin.readline
n = int(input())
graph = [[int(s) for s in input().rstrip()] for _ in range(n)]
result = ''


def quad_tree(x, y, size):
    global result

    # result += '('
    cur = graph[x][y]
    for i in range(x, x + size):
        for j in range(y, y + size):
            if cur != graph[i][j]:
                n_size = size // 2
                result += '('
                quad_tree(x, y, n_size)  # 왼쪽 위
                quad_tree(x, y + n_size, n_size)  # 오른쪽 위
                quad_tree(x + n_size, y, n_size)  # 왼쪽 아래
                quad_tree(x + n_size, y + n_size, n_size)  # 오른쪽 아래
                result += ')'
                return

            cur = graph[i][j]

    result += str(cur)
    return


quad_tree(0, 0, n)
print(result)
