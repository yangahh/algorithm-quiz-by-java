a, b, c, d, e, f = map(int, input().split())


def brute_force_search():
    for x in range(-999, 1000):
        for y in range(-999, 1000):
            if (a * x + b * y == c) and (d * x + e * y == f):
                return x, y


x, y = brute_force_search()
print(x, y)
