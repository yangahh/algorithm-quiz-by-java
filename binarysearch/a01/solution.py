n, m = map(int, input().split())
array = list(map(int, input().split()))
array.sort()

start = 0
end = array[-1]

max_height = 0
while start <= end:
    mid = (start + end) // 2
    total = sum([x - mid for x in array if x - mid > 0])

    if total >= m:
        max_height = max(max_height, mid)
        start = mid + 1
    else:
        end = mid - 1

print(max_height)
