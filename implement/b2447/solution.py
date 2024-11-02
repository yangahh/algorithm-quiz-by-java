n = int(input())
graph = [[" "] * n for _ in range(n)]


def draw_stars(n):
    if n == 1:
        return ["*"]

    stars = draw_stars(n // 3)
    result = []

    for star in stars:
        result.append(star * 3)

    for star in stars:
        result.append(star + (" " * (n // 3)) + star)

    for star in stars:
        result.append(star * 3)
    return result


result = draw_stars(n)

for r in result:
    print(r)
