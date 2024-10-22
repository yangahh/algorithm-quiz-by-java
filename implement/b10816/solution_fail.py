import sys

input = sys.stdin.readline

n = int(input())
cards = list(map(int, input().split()))
m = int(input())
target_nums = list(map(int, input().split()))

target_nums_idx_dict = {target_num: i for i, target_num in enumerate(target_nums)}

cards.sort()
target_nums.sort()


def left_binary_search(array, target_num):
    left_idx = -1
    start = 0
    end = len(cards) - 1
    while start <= end:
        mid = (start + end) // 2

        if array[mid] < target_num:
            start = mid + 1
        elif array[mid] > target_num:
            end = mid - 1
        else:
            left_idx = mid  # 값 저장
            end = mid - 1  # 앞 부분에 같은 값이 또 있을 수 있으니 재탐색

    return left_idx


def right_binary_search(array, target_num):
    right_idx = -1
    start = 0
    end = len(cards) - 1
    while start <= end:
        mid = (start + end) // 2

        if array[mid] < target_num:
            start = mid + 1
        elif array[mid] > target_num:
            end = mid - 1
        else:
            right_idx = mid  # 값 저장
            start = mid + 1  # 뒷 부분에 같은 값이 또 있을 수 있으니 재탐색

    return right_idx


result = [0] * m
for target_num in target_nums:
    left_idx = left_binary_search(cards, target_num)

    if left_idx == -1:
        continue

    right_idx = right_binary_search(cards, target_num)
    result[target_nums_idx_dict[target_num]] = right_idx - left_idx + 1
    cards = cards[right_idx + 1:]

print(*result)
