import sys

input = sys.stdin.readline

n, c = map(int, input().split())
house = [int(input()) for _ in range(n)]
house.sort()


def search():
    if c == 2:
        return house[-1] - house[0]

    # 여기서부턴 공유기가 3개 이상일때
    # gap은 가장 인접한 두 공유기 사이의 거리를 의미. start와 end는 gap이 될 수 있는 수의 범위를 말한다
    # start가 1인 이유는 두 공유기 사이의 거리가 최소 1이기 때문
    # end는 두 공유기 사이의 최대 거리를 말함. 즉, 가장 양 끝의 집의 거리
    start = 1
    end = house[-1] - house[0]

    result = 0
    # 이진탐색을 활용하여 파라메트릭 서치
    while start <= end:
        gap = (start + end) // 2
        current_router = house[0]  # 첫번째 집에 무조건 설치. current_router는 이번에 공유기를 설치한 집의 위치를 말함
        cnt = 1  # 설치된 공유기의 개수. 현재 첫번째 집에 설치했으므로 1

        for i in range(1, n):  # 첫번째 집 이후에 공유기를 앞에서부터 하나씩 설치
            if house[i] >= current_router + gap:  # 현재 공유기가 설치된 위치에서 gap만큼 떨어진 집이 있으면 거기에 공유기 설치
                current_router = house[i]  # house[i]위치에 공유기를 설치 -> current_router 값 갱신
                cnt += 1

        if cnt < c:
            # 공유기를 더 설치해야하는데, 자리가 없음 -> gap을 현재 값보다 작게 조정해야 함
            end = gap - 1
        else:
            # 공유기를 c 개수 만큼 설치 했으나, gap 값을 더 크게 할 수 있는지 찾아야 함
            result = gap  # 일단 현재 gap 저장
            start = gap + 1

    return result


result = search()
print(result)
