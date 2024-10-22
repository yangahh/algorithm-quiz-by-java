import sys

input = sys.stdin.readline

n = int(input())
cards = list(map(int, input().split()))
m = int(input())
target_nums = list(map(int, input().split()))

cards_cnt_dict = {}
for card in cards:
    if card not in cards_cnt_dict:
        cards_cnt_dict[card] = 1
    else:
        cards_cnt_dict[card] += 1

result = [str(cards_cnt_dict.get(num, 0)) for num in target_nums]

# print(*result)
sys.stdout.write(' '.join(result))
